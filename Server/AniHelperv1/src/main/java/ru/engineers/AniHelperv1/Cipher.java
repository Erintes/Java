package ru.engineers.AniHelperv1;

import java.nio.charset.StandardCharsets;

public class Cipher {

    public static int getHash(String password){

        byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
        int hash = 7;
        for (int i = 0; i < password.length(); i++) {
            hash = hash*17 + bytes[i];
        }

        return hash;
    }
}
