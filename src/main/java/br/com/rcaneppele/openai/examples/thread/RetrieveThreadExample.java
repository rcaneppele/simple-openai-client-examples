package br.com.rcaneppele.openai.examples.thread;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.error.exception.NotFoundException;

public class RetrieveThreadExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        try {
            var thread = client.retrieveThread("thread_id");

            System.out.println("Id: " +thread.id());
            System.out.println("Object: " +thread.object());
            System.out.println("Created at: " +thread.createdAt());
            System.out.println("Metadata: " +thread.metadata());
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
