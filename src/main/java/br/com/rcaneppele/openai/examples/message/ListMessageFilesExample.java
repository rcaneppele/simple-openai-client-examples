package br.com.rcaneppele.openai.examples.message;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.common.request.builder.QueryParametersBuilder;

public class ListMessageFilesExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        // To list all message files:
        //var listOfMessageFiles = client.listMessageFiles("thread_id", "message_id");

        var filters = new QueryParametersBuilder().limit(3).ascOrder().build();
        var listOfMessageFiles = client.listMessageFiles("thread_id", "message_id", filters);

        System.out.println("Object: " +listOfMessageFiles.object());
        System.out.println("Has more: " +listOfMessageFiles.hasMore());
        System.out.println("First id: " +listOfMessageFiles.firstId());
        System.out.println("Last id: " +listOfMessageFiles.lastId());

        System.out.println("\n===== MESSAGE FILES =====\n");
        listOfMessageFiles.data().forEach(file -> {
            System.out.println("id: " +file.id());
            System.out.println("Object: " +file.object());
            System.out.println("Created at: " +file.createdAt());
            System.out.println("Message id: " +file.messageId());
            System.out.println("-------------------------");
        });
    }

}
