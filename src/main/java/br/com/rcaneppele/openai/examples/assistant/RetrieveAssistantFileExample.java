package br.com.rcaneppele.openai.examples.assistant;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.error.exception.NotFoundException;

public class RetrieveAssistantFileExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        try {
            var file = client.retrieveAssistantFile("asst_id", "file-id");

            System.out.println("File id: " +file.id());
            System.out.println("Object: " +file.object());
            System.out.println("Created at: " +file.createdAt());
            System.out.println("Assistant id: " +file.assistantId());
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
