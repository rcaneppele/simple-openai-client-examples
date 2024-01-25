package br.com.rcaneppele.openai.examples.message;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.endpoints.message.request.builder.CreateMessageRequestBuilder;

import java.util.Map;

public class CreateMessageExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var request = new CreateMessageRequestBuilder()
                .content("Message content")
                .fileIds("file-id-1", "file-id-2")
                .metadata(Map.of("my-key", "my-value"))
                .build();

        var message = client.createMessage("thread_id", request);

        System.out.println("Id: " +message.id());
        System.out.println("Object: " +message.object());
        System.out.println("Created at: " +message.createdAt());
        System.out.println("Role: " +message.role());
        System.out.println("Content list: " +message.content());
        System.out.println("Assistant id: " +message.assistantId());
        System.out.println("Thread id: " +message.threadId());
        System.out.println("Run id: " +message.runId());
        System.out.println("File ids: " +message.fileIds());
        System.out.println("Metadata: " +message.metadata());
    }

}
