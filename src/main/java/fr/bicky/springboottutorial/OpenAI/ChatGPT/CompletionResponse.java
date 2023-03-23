package fr.bicky.springboottutorial.OpenAI.ChatGPT;

import java.util.List;
import java.util.Optional;

public record CompletionResponse(String id, String object, Integer created, String model, Usage usage, List<Choice> choices) {
    public Optional<String> firstAnswer() {
        if (choices == null || choices.isEmpty())
            return Optional.empty();
        return Optional.of(choices.get(0).message.content);
    }

    record Usage(int prompt_tokens, int completion_tokens, int total_tokens) {}

    record Choice(Message message, String finish_reason, Integer index) {}
}

class Message {
    String role;
    String content;

    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }
}
