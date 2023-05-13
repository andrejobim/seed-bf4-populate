package br.com.soulcodesoft.methods;

import io.netty.handler.codec.http.HttpMethod;
import org.asynchttpclient.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RequestRedirectAuthentication {

    private static final String REGEX_WINDOW_LOCATION_REDIRECT = "window\\.location\\s*=\\s*\"([^\"]+)\";";

    public String execute(RequestSeed requestSeed, Response responseAuthentication){
        try {
            Pattern pattern = Pattern.compile(REGEX_WINDOW_LOCATION_REDIRECT);
            Matcher matcher = pattern.matcher(responseAuthentication.getResponseBody());

            System.out.printf("Found Regex Url Redirect: %s%n", matcher.find());
            String urlRedirectLogin = matcher.group(1);
            urlRedirectLogin= URLDecoder.decode(urlRedirectLogin+"&_eventId=end",
                    StandardCharsets.UTF_8.toString());
            Response responseRedirectAuthentication = requestSeed.executeRequest(
                    requestSeed.createRequest(urlRedirectLogin, HttpMethod.GET)
                            .build());
            System.out.printf("RequestRedirectAuthentication status : %s%n",
                    responseRedirectAuthentication.getStatusCode());
            return responseRedirectAuthentication.getResponseBody();

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
