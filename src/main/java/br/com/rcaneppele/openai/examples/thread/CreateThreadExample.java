package br.com.rcaneppele.openai.examples.thread;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.endpoints.thread.request.builder.CreateThreadRequestBuilder;

public class CreateThreadExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var request = new CreateThreadRequestBuilder()
                .addUserMessage("User message", null, null)
                .build();

        // To create an empty thread:
        // var assistant = client.createThread();

        var thread = client.createThread(request);

        System.out.println("id: " +thread.id());
        System.out.println("Object: " +thread.object());
        System.out.println("Created at: " +thread.createdAt());
        System.out.println("Metadata: " +thread.metadata());
    }

}
