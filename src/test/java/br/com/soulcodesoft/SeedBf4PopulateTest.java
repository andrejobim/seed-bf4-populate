package br.com.soulcodesoft;

import br.com.soulcodesoft.methods.PlayerSeed;

import java.util.ArrayList;
import java.util.List;

public class SeedBf4PopulateTest {

    public static void main(String[] args) {
        // https://battlelog.battlefield.com/bf4/servers/show/pc/SERVER_ID
        List<PlayerSeed> playerSeeds = new ArrayList<>();
//        playerSeeds.add(new PlayerSeed("ACCOUNT_USER_EA", "PASSWORD_USER_EA"));
        playerSeeds.add(new PlayerSeed("umjogadorfpsbf42@gmail.com", "agj14m3N$@$"));
        new BattlefieldSeed("ea23e931-143c-4164-8334-4ae1ddfa6bbe",playerSeeds).execute();
    }
}
