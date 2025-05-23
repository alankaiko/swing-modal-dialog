package raven.modal.demo.integracao.impl;

import raven.modal.demo.integracao.ExameIntegracao;
import raven.modal.demo.model.Exame;
import raven.modal.demo.model.dto.ExameDTO;
import raven.modal.demo.utils.ConfigParametros;
import raven.modal.demo.utils.PageResponse;
import raven.modal.demo.utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ExameIntegracaoImpl implements ExameIntegracao {
    private String baseUrl;
    private String endpoint;
    private String token;

    public ExameIntegracaoImpl(String configFilePath, String token) {
        ConfigParametros config = new ConfigParametros(configFilePath);
        this.baseUrl = config.getProperty("api.base-url");
        this.endpoint = "exames";
        this.token = token;
    }

    @Override
    public Exame salvar(Exame exame) {
        try {
            String urlStr = this.baseUrl + this.endpoint;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + this.token);
            connection.setDoOutput(true);

            String jsonInputString = Utils.convertObjectToJson(exame);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return Utils.convertJsonToObject(response.toString(), Exame.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletar(Long codigo) {
        try {
            String urlStr = this.baseUrl + this.endpoint + "/" + codigo;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + this.token);

            connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Exame buscarId(Long codigo) {
        try {
            String urlStr = this.baseUrl + "/" + this.endpoint + "/" + codigo;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + this.token);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return Utils.convertJsonToObject(response.toString(), Exame.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Exame> listar() {
        try {
            String urlStr = this.baseUrl + this.endpoint;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + this.token);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return Utils.convertJsonToList(response.toString(), Exame.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PageResponse filtrando(ExameDTO filtro) {
        try {
            String urlStr = this.baseUrl + "/" + this.endpoint + "/listarDesktop";
            URL url = new URL(urlStr);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + this.token);
            connection.setDoOutput(true);

            String jsonInputString = Utils.convertObjectToJson(filtro);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            PageResponse pageResponse = new PageResponse();

            List<Exame> lista = new ArrayList<>();
            lista.addAll(Utils.convertJsonToList(response.toString(), Exame.class));
            pageResponse.setContent(lista);
            pageResponse.setSize(10);
            pageResponse.setTotalElements(10);
            pageResponse.setTotalPages(1);

            return pageResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
