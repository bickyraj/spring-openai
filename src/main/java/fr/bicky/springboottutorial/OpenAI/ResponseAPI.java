package fr.bicky.springboottutorial.OpenAI;

public class ResponseAPI {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public ResponseAPI(String message) {
        this.message = message;
    }
}
