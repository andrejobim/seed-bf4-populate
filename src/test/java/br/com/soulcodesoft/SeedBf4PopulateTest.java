package br.com.soulcodesoft;

import br.com.soulcodesoft.methods.PlayerSeed;

import java.util.ArrayList;
import java.util.List;

public class SeedBf4PopulateTest {

    public static void main(String[] args) {
        // https://battlelog.battlefield.com/bf4/servers/show/pc/SERVER_ID
        List<PlayerSeed> playerSeeds = new ArrayList<>();
        playerSeeds.add(new PlayerSeed("ACCOUNT_USER_EA", "PASSWORD_USER_EA"));
        new BattlefieldSeed("SERVER_ID",playerSeeds).execute();
    }
}
