package br.com.rcaneppele.openai.examples.thread;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.endpoints.thread.request.builder.ModifyThreadRequestBuilder;

import java.util.Map;

public class ModifyThreadExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var request = new ModifyThreadRequestBuilder()
                .metadata(Map.of("key", "value"))
                .build();

        var thread = client.modifyThread("thread_id", request);

        System.out.println("id: " +thread.id());
        System.out.println("Object: " +thread.object());
        System.out.println("Created at: " +thread.createdAt());
        System.out.println("Metadata: " +thread.metadata());
    }

}
