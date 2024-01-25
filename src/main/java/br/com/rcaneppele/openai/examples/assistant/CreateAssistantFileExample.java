package br.com.rcaneppele.openai.examples.assistant;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.endpoints.assistant.request.builder.CreateAssistantFileRequestBuilder;

public class CreateAssistantFileExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var request = new CreateAssistantFileRequestBuilder()
                .fileId("file-id")
                .build();

        var assistantFile = client.createAssistantFile("asst_id", request);

        System.out.println("Id: " +assistantFile.id());
        System.out.println("Object: " +assistantFile.object());
        System.out.println("Created at: " +assistantFile.createdAt());
        System.out.println("Assistant id: " +assistantFile.assistantId());
    }

}
