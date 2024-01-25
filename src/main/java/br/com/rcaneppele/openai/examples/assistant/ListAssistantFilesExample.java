package br.com.rcaneppele.openai.examples.assistant;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.common.request.builder.QueryParametersBuilder;

public class ListAssistantFilesExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        // To list all:
        //var listOfAssistants = client.listAssistantFiles("assistant_id");

        var filters = new QueryParametersBuilder().limit(3).ascOrder().build();
        var assistantFiles = client.listAssistantFiles("assistant_id", filters);

        System.out.println("Object: " +assistantFiles.object());
        System.out.println("Has more: " +assistantFiles.hasMore());
        System.out.println("First id: " +assistantFiles.firstId());
        System.out.println("Last id: " +assistantFiles.lastId());

        System.out.println("\n===== FILES =====\n");
        assistantFiles.data().forEach(file -> {
            System.out.println("File id: " +file.id());
            System.out.println("Object: " +file.object());
            System.out.println("Created at: " +file.createdAt());
            System.out.println("Assistant id: " +file.assistantId());
            System.out.println("-------------------------");
        });
    }

}
