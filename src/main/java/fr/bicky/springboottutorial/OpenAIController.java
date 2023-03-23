package fr.bicky.springboottutorial;

import fr.bicky.springboottutorial.OpenAI.ChatGPT.CompletionResponse;
import fr.bicky.springboottutorial.OpenAI.OpenAI;
import fr.bicky.springboottutorial.OpenAI.ResponseAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAIController {

    @GetMapping("/completion")
    public ResponseEntity<ResponseAPI> complete(String message) {
        try {
            OpenAI openai = new OpenAI();
            CompletionResponse response = openai.chatCompletion(message);
            ResponseAPI result = new ResponseAPI(response.firstAnswer().toString());
            return new ResponseEntity<ResponseAPI>(result, HttpStatus.OK);
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
