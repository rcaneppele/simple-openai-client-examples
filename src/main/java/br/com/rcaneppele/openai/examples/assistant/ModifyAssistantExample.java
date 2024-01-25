package br.com.rcaneppele.openai.examples.assistant;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.endpoints.assistant.request.ModifyAssistantRequest;
import br.com.rcaneppele.openai.endpoints.assistant.request.builder.ModifyAssistantRequestBuilder;

public class ModifyAssistantExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var request = (ModifyAssistantRequest) new ModifyAssistantRequestBuilder()
                .name("Modified name")
                .description("Modified description")
                .instructions("Modified instructions")
                .build();

        var assistant = client.modifyAssistant("asst_vUT0OWmD2jrAgf4vTeZpWVCq", request);

        System.out.println("Response ID: " +assistant.id());
        System.out.println("Object: " +assistant.object());
        System.out.println("Created at: " +assistant.createdAt());
        System.out.println("Model: " +assistant.model());
        System.out.println("Name: " +assistant.name());
        System.out.println("Description: " +assistant.description());
        System.out.println("Instructions: " +assistant.instructions());
        System.out.println("File ids: " +assistant.fileIds());
        System.out.println("Metadata: " +assistant.metadata());
        System.out.println("Tools: " +assistant.tools());
    }

}
