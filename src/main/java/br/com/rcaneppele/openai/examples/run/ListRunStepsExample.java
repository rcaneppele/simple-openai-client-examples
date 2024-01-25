package br.com.rcaneppele.openai.examples.run;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.common.request.builder.QueryParametersBuilder;

public class ListRunStepsExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        // To list all run steps:
        //var listOfRunSteps = client.listRunSteps("thread_id", "run_id");

        var filters = new QueryParametersBuilder().limit(3).ascOrder().build();
        var listOfRunSteps = client.listRunSteps("thread_id", "run_id", filters);

        System.out.println("Object: " +listOfRunSteps.object());
        System.out.println("Has more: " +listOfRunSteps.hasMore());
        System.out.println("First id: " +listOfRunSteps.firstId());
        System.out.println("Last id: " +listOfRunSteps.lastId());

        System.out.println("\n===== RUN STEPS =====\n");
        listOfRunSteps.data().forEach(runStep -> {
            System.out.println("Id: " + runStep.id());
            System.out.println("Object: " + runStep.object());
            System.out.println("Created at: " + runStep.createAt());
            System.out.println("Run id: " + runStep.runId());
            System.out.println("Assistant id: " + runStep.assistantId());
            System.out.println("Thread id: " + runStep.threadId());
            System.out.println("Type: " + runStep.type());
            System.out.println("Status: " + runStep.status());
            System.out.println("Cancelled at: " + runStep.cancelledAt());
            System.out.println("Completed at: " + runStep.completedAt());
            System.out.println("Expired at: " + runStep.expiredAt());
            System.out.println("Failed at: " + runStep.failedAt());
            System.out.println("Last error: " + runStep.lastError());
            System.out.println("Step details: " + runStep.stepDetails());
            System.out.println("Metadata: " + runStep.metadata());
        });
    }

}
