package br.com.rcaneppele.openai.examples.chat;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.common.OpenAIModel;
import br.com.rcaneppele.openai.endpoints.chatcompletion.request.ChatCompletionRequestBuilder;

public class ChatCompletionExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var request = new ChatCompletionRequestBuilder()
                .model(OpenAIModel.GPT_4_1106_PREVIEW)
                .systemMessage("You are a helpful assistant")
                .userMessage("Explain me what is GPT in simple terms")
                .n(2)
                .frequencyPenalty(1.3)
                .maxTokens(256)
                .temperature(1.2)
                .build();

        var response = client.chatCompletion(request);

        System.out.println("Response ID: " +response.id());
        System.out.println("Fingerprint: " +response.systemFingerprint());
        System.out.println("Object: " +response.object());
        System.out.println("Created: " +response.created());
        System.out.println("Usage: " +response.usage());

        System.out.println("\n===== RESPONSE CHOICES =====\n");
        response.choices().forEach(c -> {
            System.out.println("Index: " +c.index());
            System.out.println("Message Role: " +c.message().role());
            System.out.println("Message Content: " +c.messageContent());
            System.out.println("Finish Reason: " +c.finishReason());
            System.out.println("LogProbability: " +c.logProbs());
            System.out.println("-------------------------");
        });
    }

}
