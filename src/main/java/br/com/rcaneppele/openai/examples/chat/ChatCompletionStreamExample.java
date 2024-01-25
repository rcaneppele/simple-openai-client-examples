package br.com.rcaneppele.openai.examples.chat;

import br.com.rcaneppele.openai.OpenAIClient;
import br.com.rcaneppele.openai.common.OpenAIModel;
import br.com.rcaneppele.openai.endpoints.chatcompletion.request.ChatCompletionRequestBuilder;

public class ChatCompletionStreamExample {

    public static void main(String[] args) {
        var apiKey = System.getenv("OPENAI_API_KEY");
        var client = new OpenAIClient(apiKey, 30);

        var request = new ChatCompletionRequestBuilder()
                .model(OpenAIModel.GPT_4_1106_PREVIEW)
                .systemMessage("You are a helpful assistant")
                .userMessage("Explain me what is GPT in simple terms")
                .frequencyPenalty(1.3)
                .maxTokens(256)
                .temperature(1.2)
                .build();

        client.streamChatCompletion(request).subscribe(response -> {
            var message = response.firstChoiceMessageContent();
            if (message != null) {
                System.out.print(message);
            }
        }, error -> {
            System.out.println("\n\nError during streaming: " +error.getMessage());
        }, () -> {
            System.out.println("\n\n=== Streaming completed ===");
        });
    }

}
