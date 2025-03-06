package raven.modal.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {

    private static final String API_BASE_URL = "http://localhost:8087/api/convenioResources"; // Base URL da API

    public String buscarConvenio(String tokenJWT) {
        try {
            URL url = new URL(API_BASE_URL + "/listarDesktop");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + tokenJWT); // Passa o token JWT aqui

            int status = connection.getResponseCode();
            if (status != 200) {
                throw new IOException("Falha na requisição, status: " + status);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString(); // Retorna a resposta da API
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
