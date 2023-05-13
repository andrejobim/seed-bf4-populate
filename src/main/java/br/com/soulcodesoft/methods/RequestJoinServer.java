package br.com.soulcodesoft.methods;

import io.netty.handler.codec.http.HttpMethod;
import org.asynchttpclient.Response;

public class RequestJoinServer  {

    private static final String URL_JOIN_SERVER = "https://battlelog.battlefield.com/bf4/launcher/reserveslotbygameid/1/%s/%s/1/%s/0";

    public void execute(RequestSeed requestSeed, String personalId, String gameId, String serverID, String postChecksum){
        Response responseJoinServer = requestSeed.executeRequest(
                requestSeed.createRequest(String.format(URL_JOIN_SERVER, personalId, gameId, serverID), HttpMethod.POST)
                        .addFormParam("post-check-sum", postChecksum)
                        .build());
        System.out.printf("RequestJoinServer status : %s%n", responseJoinServer.getStatusCode());
        System.out.printf("ResponseBody status : %s%n", responseJoinServer.getResponseBody());
    }
}
