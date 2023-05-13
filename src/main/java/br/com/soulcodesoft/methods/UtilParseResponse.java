package br.com.soulcodesoft.methods;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilParseResponse {

    private static final String REGEX_POSTCHECKSUM = "\"postChecksum\":\"([a-f0-9]+)\"";

    private static final String REGEX_PERSONAID = "\"personaId\":\"(\\d+)\"";

    private static final String REGEX_GAMEID = "\"gameId\":\"(\\d+)\"";


    public String getPostChecksumAuth(String responseRedirectAuthentication){
        Pattern patternPostChecksum = Pattern.compile(REGEX_POSTCHECKSUM);
        Matcher matcherPostChecksum = patternPostChecksum.matcher(responseRedirectAuthentication);
        System.out.printf("Found Regex PostChecksum: %s%n", matcherPostChecksum.find());
        return matcherPostChecksum.group(1);
    }

    public String getPersonaId(String responseRedirectAuthentication){
        Pattern patternPersonalId = Pattern.compile(REGEX_PERSONAID);
        Matcher matcherPersonalId = patternPersonalId.matcher(responseRedirectAuthentication);
        System.out.printf("Found Regex PersonalId: %s%n", matcherPersonalId.find());
        return matcherPersonalId.group(1);
    }

    public String getGameId(String responseServerGameId){
        Pattern patternGamelId = Pattern.compile(REGEX_GAMEID);
        Matcher matcherPersonalId = patternGamelId.matcher(responseServerGameId);
        System.out.printf("Found Regex GameId: %s%n", matcherPersonalId.find());
        return matcherPersonalId.group(1);
    }

}
