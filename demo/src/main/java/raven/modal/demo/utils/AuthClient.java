package raven.modal.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AuthClient {
    private String LOGIN_URL;

    public String obterTokenJWT(String username, String password) {
        try {
            ConfigParametros config = new ConfigParametros("application.properties");
            this.LOGIN_URL = config.getProperty("api.base-url") + "/" + config.getProperty("login.url");

            URL url = new URL(LOGIN_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Authorization", "Basic YW5ndWxhcjpAbmd1bEByMA==");
            connection.setDoOutput(true);
            String data = "grant_type=password&username=" + username + "&password=" + password;

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = data.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int status = connection.getResponseCode();
            if (status != 200) {
                throw new IOException("Falha na autenticação, status: " + status);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            String responseString = response.toString();
            String token = responseString.split("\"access_token\":\"")[1].split("\"")[0];

            return token;
        } catch (IOException e) {

        }
        return null;
    }
}

