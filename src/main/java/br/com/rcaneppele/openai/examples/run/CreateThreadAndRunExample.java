package br.com.rcaneppele.openai.examples.run;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.endpoints.run.request.builder.CreateThreadAndRunRequestBuilder;

public class CreateThreadAndRunExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var request = new CreateThreadAndRunRequestBuilder()
                .assistantId("asst_id")
                .addThreadUserMessage("user message content", null, null)
                .build();

        var run = client.createThreadAndRun(request);

        System.out.println("Id: " +run.id());
        System.out.println("Object: " +run.object());
        System.out.println("Created at: " +run.createAt());
        System.out.println("Assistant id: " +run.assistantId());
        System.out.println("Thread id: " +run.threadId());
        System.out.println("Status: " +run.status());
        System.out.println("Started at: " +run.startedAt());
        System.out.println("Expires at: " +run.expiresAt());
        System.out.println("Cancelled at: " +run.cancelledAt());
        System.out.println("Failed at: " +run.failedAt());
        System.out.println("Completed at: " +run.completedAt());
        System.out.println("Last error: " +run.lastError());
        System.out.println("Model: " +run.model());
        System.out.println("Instructions: " +run.instructions());
        System.out.println("Tools: " +run.tools());
        System.out.println("File ids: " +run.fileIds());
        System.out.println("Metadata: " +run.metadata());
        System.out.println("Required action: " +run.requiredAction());
    }

}
