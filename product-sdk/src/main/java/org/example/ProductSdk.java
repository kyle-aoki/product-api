package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ProductSdk implements ProductInterface {

    HttpClient client = HttpClient.newHttpClient();
    ObjectMapper om = new ObjectMapper();

    private HttpRequest POST(String uri, String body) throws URISyntaxException {
        return HttpRequest
                .newBuilder()
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(new URI("http://localhost:8080" + uri))
                .build();
    }
    private String send(HttpRequest hr) throws IOException, InterruptedException {
        return client.send(hr, HttpResponse.BodyHandlers.ofString()).body();
    }

    public CreateProductOutput createProduct(CreateProductInput createProductInput) {
        try {
            String body = om.writeValueAsString(createProductInput);
            System.out.println(body);
            String respBody = send(POST("/create/product", body));
            return om.readValue(respBody, CreateProductOutput.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("request failed");
        }
    }
}
