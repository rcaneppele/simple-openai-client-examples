package br.com.rcaneppele.openai.examples.message;

import br.com.rcaneppele.openai.OpenAIClient;

public class RetrieveMessageExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var message = client.retrieveMessage("thread_id", "message_id");

        System.out.println("id: " +message.id());
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
