package br.com.soulcodesoft.methods;

import io.netty.handler.codec.http.HttpMethod;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

public class RequestOpen  {

    private static final String URL_OPEN_BATTLELOG = "https://battlelog.battlefield.com/sso/?";
    private static final String KEY_TOKEN_TYPE = "tokentype";
    private static final String KEY_RESPONSE_TYPE = "response_type";
    private static final String KEY_CLIENT_ID = "client_id";
    private static final String KEY_DISPLAY = "display";
    private static final String VALUE_CODE = "code";
    private static final String VALUE_BATTLELOG = "battlelog";
    private static final String VALUE_WEBLOGIN = "web/login";

    public String execute(RequestSeed requestSeed) {

        Request build = requestSeed.createRequest(URL_OPEN_BATTLELOG, HttpMethod.GET)
                .addQueryParam(KEY_TOKEN_TYPE, VALUE_CODE)
                .addQueryParam(KEY_RESPONSE_TYPE, VALUE_CODE)
                .addQueryParam(KEY_CLIENT_ID, VALUE_BATTLELOG)
                .addQueryParam(KEY_DISPLAY, VALUE_WEBLOGIN)
                .setFollowRedirect(Boolean.TRUE)
                .build();

        Response requestOpenBattlelog = requestSeed.executeRequest(build);

        System.out.printf("RequestOpenBattlelog status : %s%n", requestOpenBattlelog.getStatusCode());
        return requestOpenBattlelog.getResponseBody();
    }
}
