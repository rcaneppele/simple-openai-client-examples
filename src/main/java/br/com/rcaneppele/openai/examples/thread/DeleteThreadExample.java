package br.com.rcaneppele.openai.examples.thread;

import br.com.rcaneppele.openai.OpenAIClient;

public class DeleteThreadExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var deletionStatus = client.deleteThread("thread_id");

        System.out.println("id: " +deletionStatus.id());
        System.out.println("Object: " +deletionStatus.object());
        System.out.println("Deleted: " +deletionStatus.deleted());
    }

}
