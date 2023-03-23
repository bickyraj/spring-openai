package fr.bicky.springboottutorial.OpenAI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpRequest;

@Service
public class ChatService {

    public String createRequestBody(String message) throws JsonProcessingException {
        // Create the request body
        ObjectMapper mapper = new ObjectMapper();
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel("gpt-3.5-turbo");
        ChatMessage chatmessage = new ChatMessage();
        chatmessage.setRole("user");
        chatmessage.setContent(message);
        chatRequest.setMessages(new ChatMessage[]{chatmessage});
        chatRequest.setTemperature(0.7);
        String requestBody = mapper.writeValueAsString(chatRequest);
        return requestBody;
    }
}

class ChatRequest {
    private String model;
    private ChatMessage[] messages;
    private double temperature;

    public ChatMessage[] getMessages() {
        return messages;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setMessages(ChatMessage[] messages) {
        this.messages = messages;
    }
}

class ChatMessage {
    private String role;
    private String content;

    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
