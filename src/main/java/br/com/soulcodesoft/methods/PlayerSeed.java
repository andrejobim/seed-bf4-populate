package br.com.soulcodesoft.methods;

public class PlayerSeed {

    private  String user;
    private  String password;


    public PlayerSeed(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
