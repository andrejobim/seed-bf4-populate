package br.com.soulcodesoft;


import br.com.soulcodesoft.methods.*;
import org.asynchttpclient.Response;

import java.util.List;

public class BattlefieldSeed {

    private final RequestOpen requestOpen;
    private final RequestLoginPage requestLoginPage;
    private final RequestAuthentication requestAuthentication;
    private final RequestRedirectAuthentication requestRedirectAuthentication;
    private final RequestServerGameId requestServerGameId;
    private final RequestJoinServer requestJoinServer;
    private final RequestExitServer requestExitServer;
    private final UtilParseResponse utilParseResponse;
    private final String serverID;
    private final List<PlayerSeed> playerSeeds;

    public BattlefieldSeed(String serverID, List<PlayerSeed> playerSeeds) {
        this.serverID = serverID;
        this.playerSeeds = playerSeeds;
        this.requestOpen = new RequestOpen();
        this.requestLoginPage = new RequestLoginPage();
        this.requestAuthentication = new RequestAuthentication();
        this.requestRedirectAuthentication = new RequestRedirectAuthentication();
        this.requestServerGameId = new RequestServerGameId();
        this.requestJoinServer = new RequestJoinServer();
        this.requestExitServer = new RequestExitServer();
        this.utilParseResponse = new UtilParseResponse();
    }

    public void execute(){
        for (PlayerSeed playerSeed: this.playerSeeds) {
            populate(playerSeed, this.serverID, playerSeed.getUser(), playerSeed.getPassword());
        }
    }

    private void populate(PlayerSeed playerSeed, String serverId, String user, String password) {
        RequestSeed requestSeed = new RequestSeed();
        String responseOpen = requestOpen.execute(requestSeed);
        Response responseEntryLoginPage = requestLoginPage.execute(requestSeed, responseOpen);
        Response responseAuthentication = requestAuthentication.execute(requestSeed, responseEntryLoginPage, user, password);
        String responseRedirectAuthentication = requestRedirectAuthentication.execute(requestSeed, responseAuthentication);
        String responseServerGameId = requestServerGameId.execute(requestSeed, serverId);
        String gameId = utilParseResponse.getGameId(responseServerGameId);
        String personaId = utilParseResponse.getPersonaId(responseRedirectAuthentication);
        String postChecksum = utilParseResponse.getPostChecksumAuth(responseRedirectAuthentication);
        System.out.printf("gameId : %s%n", gameId);
        System.out.printf("personaId : %s%n", personaId);
        System.out.printf("postChecksum : %s%n", postChecksum);
        requestJoinServer.execute(requestSeed, personaId, gameId, serverId, postChecksum);
        requestExitServer.execute(requestSeed, personaId, gameId, postChecksum);
    }


}
