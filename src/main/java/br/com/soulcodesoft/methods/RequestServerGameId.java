package br.com.soulcodesoft.methods;

import io.netty.handler.codec.http.HttpMethod;
import org.asynchttpclient.Response;

public class RequestServerGameId {

    private static final String URL_GET_GAMEID = "https://battlelog.battlefield.com/bf4/servers/show/pc/%s/?json=1";

    public String execute(RequestSeed requestSeed, String serverId){
        Response responseRequestGameId = requestSeed.executeRequest(
                requestSeed.createRequest(String.format(URL_GET_GAMEID, serverId), HttpMethod.GET)
                        .build());
        System.out.printf("RequestRequestGameId status : %s%n", responseRequestGameId.getStatusCode());
        return responseRequestGameId.getResponseBody();
    }
}
