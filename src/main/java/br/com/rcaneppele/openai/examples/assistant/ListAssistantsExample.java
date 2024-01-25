package br.com.rcaneppele.openai.examples.assistant;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.common.request.builder.QueryParametersBuilder;

public class ListAssistantsExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        // To list all:
        //var listOfAssistants = client.listAssistants();

        var filters = new QueryParametersBuilder().limit(3).ascOrder().build();
        var listOfAssistants = client.listAssistants(filters);

        System.out.println("Object: " +listOfAssistants.object());
        System.out.println("Has more: " +listOfAssistants.hasMore());
        System.out.println("First id: " +listOfAssistants.firstId());
        System.out.println("Last id: " +listOfAssistants.lastId());

        System.out.println("\n===== ASSISTANTS =====\n");
        listOfAssistants.data().forEach(assistant -> {
            System.out.println("Id: " +assistant.id());
            System.out.println("Object: " +assistant.object());
            System.out.println("Created at: " +assistant.createdAt());
            System.out.println("Model: " +assistant.model());
            System.out.println("Name: " +assistant.name());
            System.out.println("Description: " +assistant.description());
            System.out.println("Instructions: " +assistant.instructions());
            System.out.println("File ids: " +assistant.fileIds());
            System.out.println("Metadata: " +assistant.metadata());
            System.out.println("Tools: " +assistant.tools());
            System.out.println("-------------------------");
        });
    }

}
