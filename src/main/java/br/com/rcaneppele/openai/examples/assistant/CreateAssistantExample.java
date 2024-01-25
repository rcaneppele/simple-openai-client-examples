package br.com.rcaneppele.openai.examples.assistant;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.common.OpenAIModel;
import br.com.rcaneppele.openai.endpoints.assistant.request.CreateAssistantRequest;
import br.com.rcaneppele.openai.endpoints.assistant.request.builder.CreateAssistantRequestBuilder;

public class CreateAssistantExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var request = new CreateAssistantRequestBuilder()
                .model(OpenAIModel.GPT_4_1106_PREVIEW)
                .name("Math tutor")
                .description("Math tutor assistant")
                .instructions("You are a helpful math tutor assistant")
                .build();

        var response = client.createAssistant((CreateAssistantRequest) request);

        System.out.println("Response ID: " +response.id());
        System.out.println("Object: " +response.object());
        System.out.println("Created at: " +response.createdAt());
        System.out.println("Model: " +response.model());
        System.out.println("Name: " +response.name());
        System.out.println("Description: " +response.description());
        System.out.println("Instructions: " +response.instructions());
        System.out.println("File ids: " +response.fileIds());
        System.out.println("Metadata: " +response.metadata());
        System.out.println("Tools: " +response.tools());
    }

}
