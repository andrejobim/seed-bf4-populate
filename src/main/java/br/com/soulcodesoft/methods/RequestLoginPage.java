package br.com.soulcodesoft.methods;

import io.netty.handler.codec.http.HttpMethod;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RequestLoginPage {

    private String REGEX_LOGIN_BTN_HREF = "<a\\s+class=\"login-btn\"\\s+href=\"([^\"]+)\"";

    public Response execute(RequestSeed requestSeed, String responseRequestOpen) {

        Pattern patternPostChecksum = Pattern.compile(REGEX_LOGIN_BTN_HREF);
        Matcher matcherPostChecksum = patternPostChecksum.matcher(responseRequestOpen);
        System.out.printf("Found Regex Url Login: %s%n", matcherPostChecksum.find());
        String urlRedirectLogin = matcherPostChecksum.group(1);

        Request build = requestSeed.createRequest(urlRedirectLogin, HttpMethod.GET)
                .addQueryParam("locale","en_US")
                .addQueryParam("state","bf4")
                .addQueryParam("redirect_uri","https://battlelog.battlefield.com/sso/?tokentype=code")
                .addQueryParam("response_type","code")
                .addQueryParam("client_id","battlelog")
                .addQueryParam("display","web/login")
                .build();
        Response requestLoginPage = requestSeed.executeRequest(build);
        System.out.printf("RequestLoginPage status : %s%n", requestLoginPage.getStatusCode());
        return requestLoginPage;
    }
}
