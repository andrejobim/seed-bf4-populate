package br.com.soulcodesoft.methods;

import io.netty.handler.codec.http.HttpMethod;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestValidationPlayer {

    private static final String URL_PLAYER_INFO = "https://battlelog.battlefield.com/bf4/user/%s/";
    private static final String REGEX_PLAYER_INFO =  "(?s)<div class=\"box presentation margin-bottom\">\\s*<header>\\s*<h1>Presentation</h1>\\s*</header>\\s*<div class=\"box-content\">([\\s\\S]*?)</div>\\s*</div>";

    public Boolean execute(RequestSeed requestSeed, String playerName, String chaveValidation){

        Request build = requestSeed.createRequest(String.format(URL_PLAYER_INFO, playerName), HttpMethod.GET)
                .setFollowRedirect(Boolean.TRUE)
                .build();
        Response responseRequestPresentation = requestSeed.executeRequest(build);
        System.out.printf("RequestPresentation Status : %s%n", responseRequestPresentation.getStatusCode());

        Pattern presentationPattern = Pattern.compile(REGEX_PLAYER_INFO);
        Matcher matcherPresentation = presentationPattern.matcher(responseRequestPresentation.getResponseBody());
        System.out.printf("Found Regex Presentation: %s%n", matcherPresentation.find());

        String presentationProfile = matcherPresentation.group(1);
        boolean hasValuePresentation = presentationProfile.contains(chaveValidation);

        System.out.printf("Found Value Key Presentation: %s%n", hasValuePresentation);
        return hasValuePresentation;
    }

}
