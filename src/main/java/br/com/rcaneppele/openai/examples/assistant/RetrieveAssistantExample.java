package br.com.rcaneppele.openai.examples.assistant;

import br.com.rcaneppele.openai.OpenAIClient;

public class RetrieveAssistantExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        try {
            var asssistant = client.retrieveAssistant("asst_xxxxxxxxxxxxxxxxxxxxxxxx");

            System.out.println("Response ID: " +asssistant.id());
            System.out.println("Object: " +asssistant.object());
            System.out.println("Created at: " +asssistant.createdAt());
            System.out.println("Model: " +asssistant.model());
            System.out.println("Name: " +asssistant.name());
            System.out.println("Description: " +asssistant.description());
            System.out.println("Instructions: " +asssistant.instructions());
            System.out.println("File ids: " +asssistant.fileIds());
            System.out.println("Metadata: " +asssistant.metadata());
            System.out.println("Tools: " +asssistant.tools());
        } catch (Exception e) {
            System.out.println("Assistant not found with given id");
        }
    }

}
