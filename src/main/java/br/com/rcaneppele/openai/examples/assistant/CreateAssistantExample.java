package br.com.rcaneppele.openai.examples.assistant;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.common.OpenAIModel;
import br.com.rcaneppele.openai.endpoints.assistant.request.CreateAssistantRequest;
import br.com.rcaneppele.openai.endpoints.assistant.request.builder.CreateAssistantRequestBuilder;

public class CreateAssistantExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var request = (CreateAssistantRequest) new CreateAssistantRequestBuilder()
                .model(OpenAIModel.GPT_4_1106_PREVIEW)
                .name("Math tutor")
                .description("Math tutor assistant")
                .instructions("You are a helpful math tutor assistant")
                .build();

        var assistant = client.createAssistant(request);

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
    }

}
