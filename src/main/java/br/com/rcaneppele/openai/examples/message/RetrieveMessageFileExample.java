package br.com.rcaneppele.openai.examples.message;

import br.com.rcaneppele.openai.OpenAIClient;

public class RetrieveMessageFileExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var file = client.retrieveMessageFile("thread_id", "message_id", "file-id");

        System.out.println("Id: " +file.id());
        System.out.println("Object: " +file.object());
        System.out.println("Created at: " +file.createdAt());
        System.out.println("Message id: " +file.messageId());
    }

}
