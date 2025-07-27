package com.TCC.SistemaPaese.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class EmailValidatorService {

    private final String baseURL = "http://apilayer.net/api/check?access_key=";
    private final String finalURL = "&smtp=1&format=1";
    private String apiKey;
    public EmailValidatorService(@Value("${MAILBOX_API_KEY}") String apiKey){
        this.apiKey = apiKey;
    }
    private final ObjectMapper objectMapper = new ObjectMapper();

    public boolean isEmailValidFormat(String email){

        var adress = baseURL + apiKey + "&email=" + email + finalURL;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(adress))
                .build();
        HttpResponse<String> response = null;
        try{
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            JsonNode root = objectMapper.readTree(json);
            if(root.has("sucess") && !root.get("sucess").asBoolean()){
                return false;
            }
            return root.get("format_valid").asBoolean();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao validar o e-mail", e);
        }
    }
}
