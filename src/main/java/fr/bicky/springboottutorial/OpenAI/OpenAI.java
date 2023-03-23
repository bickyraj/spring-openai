package fr.bicky.springboottutorial.OpenAI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.bicky.springboottutorial.OpenAI.ChatGPT.CompletionRequest;
import fr.bicky.springboottutorial.OpenAI.ChatGPT.CompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpResponse;

@Service
public class OpenAI {

    @Value("${openai.api_key}")
    private String openAIApiKey;

    private final HttpClient client = HttpClient.newHttpClient();
    public CompletionResponse chatCompletion(String message) throws Exception {
        URI uri = URI.create("https://api.openai.com/v1/chat/completions");
        ChatService chatService = new ChatService();
        String requestBody = chatService.createRequestBody(message);
        var request = HttpRequest.newBuilder()
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer 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")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        var responseBody = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        ObjectMapper jsonMapper = new ObjectMapper();
        return  jsonMapper.readValue(responseBody, CompletionResponse.class);
    }
}
