package br.com.soulcodesoft.methods;

import io.netty.handler.codec.http.HttpMethod;
import org.asynchttpclient.Response;

public class RequestExitServer {

    private static final String URL_EXIT_SERVER = "https://battlelog.battlefield.com/bf4/launcher/mpleavegameserver/1/%s/%s";

    public void execute(RequestSeed requestSeed, String personalId, String gameId, String postChecksum){
        Response responseExitServer = requestSeed.executeRequest(requestSeed.createRequest(String.format(URL_EXIT_SERVER, personalId, gameId), HttpMethod.POST)
                .addFormParam("post-check-sum", postChecksum)
                .build());
        System.out.printf("RequestExitServer status : %s%n", responseExitServer.getStatusCode());
        System.out.printf("ResponseBody status : %s%n", responseExitServer.getResponseBody());
        requestSeed.closeRequest();
    }


}
