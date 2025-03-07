package raven.modal.demo.integracao.impl;

import raven.modal.demo.integracao.ConvenioIntegracao;
import raven.modal.demo.model.Convenio;
import raven.modal.demo.model.dto.ConvenioDTO;
import raven.modal.demo.utils.ConfigParametros;
import raven.modal.demo.utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ConvenioIntegracaoImpl implements ConvenioIntegracao {
    private String baseUrl;
    private String endpoint;

    public ConvenioIntegracaoImpl(String configFilePath) {
        ConfigParametros config = new ConfigParametros(configFilePath);
        this.baseUrl = config.getProperty("api.base-url");
        this.endpoint = "convenioResources";
    }

    @Override
    public Convenio salvar(Convenio convenio) {
        try {
            String urlStr = this.baseUrl + this.endpoint;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            String jsonInputString = Utils.convertObjectToJson(convenio);

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

            return Utils.convertJsonToObject(response.toString(), Convenio.class);
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

            connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Convenio buscarId(Long codigo) {
        try {
            String urlStr = this.baseUrl + this.endpoint + "/" + codigo;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return Utils.convertJsonToObject(response.toString(), Convenio.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Convenio> listar() {
        try {
            String urlStr = this.baseUrl + this.endpoint;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return Utils.convertJsonToList(response.toString(), Convenio.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Convenio> filtrando(ConvenioDTO filtro, String tokenJWT) {
        try {
            String urlStr = this.baseUrl + "/" + this.endpoint + "/listarDesktop";
            URL url = new URL(urlStr);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + tokenJWT);
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

            return Utils.convertJsonToList(response.toString(), Convenio.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
