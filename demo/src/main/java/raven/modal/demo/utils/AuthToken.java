package raven.modal.demo.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AuthToken {
    private static final String TOKEN_FILE = "auth_token.txt";

    public static String getToken() {
        try {
            if (Files.exists(Paths.get(TOKEN_FILE)))
                return new String(Files.readAllBytes(Paths.get(TOKEN_FILE)));
        } catch (IOException e) {
        }
        return null;
    }

    public static void setToken(String token) {
        try {
            Files.write(Paths.get(TOKEN_FILE), token.getBytes());
        } catch (IOException e) {
        }
    }

    public static void clear() {
        try {
            Files.delete(Paths.get(TOKEN_FILE));
        } catch (IOException e) {
        }
    }
}
