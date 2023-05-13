package br.com.soulcodesoft.methods;

import io.netty.handler.codec.http.HttpMethod;
import org.asynchttpclient.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;


public class RequestAuthentication {

    private static final String KEY_EMAIL = "email";
    private static final String KEY_REGION_CODE = "regionCode";
    private static final String KEY_PHONE_NUMBER = "phoneNumber";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EVENT_ID = "_eventId";
    private static final String KEY_CID = "cid";
    private static final String KEY_SHOWAGE_UP = "showAgeUp";
    private static final String KEY_THIRD_PARTY_CAPTCHA_RESPONSE = "thirdPartyCaptchaResponse";
    private static final String KEY_LOGIN_METHOD = "loginMethod";
    private static final String KEY_REMEMBER = "_rememberMe";

    public Response execute(RequestSeed requestSeed, Response responseLoginPage, String user, String password) {

        try {
            String urlAuthenticacao = responseLoginPage.getHeaders().get("selflocation");
            urlAuthenticacao = URLDecoder.decode(urlAuthenticacao,
                    StandardCharsets.UTF_8.toString());
            Response responseAuthentication = requestSeed.executeRequest(
                    requestSeed.createRequest(urlAuthenticacao, HttpMethod.POST)
                            .addFormParam(KEY_EMAIL, user)
                            .addFormParam(KEY_REGION_CODE, "US")
                            .addFormParam(KEY_PHONE_NUMBER, "")
                            .addFormParam(KEY_PASSWORD, password)
                            .addFormParam(KEY_EVENT_ID, "submit")
                            .addFormParam(KEY_CID, "")
                            .addFormParam(KEY_SHOWAGE_UP, "true")
                            .addFormParam(KEY_THIRD_PARTY_CAPTCHA_RESPONSE, "")
                            .addFormParam(KEY_LOGIN_METHOD, "emailPassword")
                            .addFormParam(KEY_REMEMBER, "on")
                            .setFollowRedirect(Boolean.TRUE)
                            .build());
            System.out.printf("RequestAuthentication status : %s%n", responseAuthentication.getStatusCode());
            return responseAuthentication;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
