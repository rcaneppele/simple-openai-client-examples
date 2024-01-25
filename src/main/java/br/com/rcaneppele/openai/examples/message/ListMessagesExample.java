package br.com.rcaneppele.openai.examples.message;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.common.request.builder.QueryParametersBuilder;

public class ListMessagesExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        // To list all messages:
        //var listOfMessages = client.listMessages("thread_id");

        var filters = new QueryParametersBuilder().limit(3).ascOrder().build();
        var listOfMessages = client.listMessages("thread_id", filters);

        System.out.println("Object: " +listOfMessages.object());
        System.out.println("Has more: " +listOfMessages.hasMore());
        System.out.println("First id: " +listOfMessages.firstId());
        System.out.println("Last id: " +listOfMessages.lastId());

        System.out.println("\n===== MESSAGES =====\n");
        listOfMessages.data().forEach(message -> {
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
            System.out.println("-------------------------");
        });
    }

}
