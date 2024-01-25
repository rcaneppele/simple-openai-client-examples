package br.com.rcaneppele.openai.examples.run;

import br.com.rcaneppele.openai.OpenAIClient;

public class RetrieveRunStepExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var runStep = client.retrieveRunStep("thread_id", "run_id", "step_id");

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
    }

}
