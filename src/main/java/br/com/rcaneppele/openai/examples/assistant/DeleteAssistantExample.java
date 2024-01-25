package br.com.rcaneppele.openai.examples.assistant;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.error.exception.NotFoundException;

public class DeleteAssistantExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        try {
            var deletionStatus = client.deleteAssistant("asst_id");

            System.out.println("Id: " +deletionStatus.id());
            System.out.println("Object: " +deletionStatus.object());
            System.out.println("Deleted: " +deletionStatus.deleted());
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
