package br.com.soulcodesoft.methods;

import io.netty.handler.codec.http.HttpMethod;
import org.asynchttpclient.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public  class RequestSeed {

    private AsyncHttpClient clientRequest;

    public RequestSeed() {
        clientRequest = Dsl.asyncHttpClient();
    }

    public BoundRequestBuilder createRequest(String url, HttpMethod method){
        return clientRequest.prepareGet(url)
                .setFollowRedirect(Boolean.TRUE)
                .setMethod(method.name());
    }

    public Response executeRequest(Request request){
        try {
            return clientRequest.executeRequest(request)
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeRequest(){
        try {
            clientRequest.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
