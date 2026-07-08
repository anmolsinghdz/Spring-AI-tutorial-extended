package com.spring.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.ai.google.genai.GoogleGenAiChatModel.ChatModel.GEMINI_2_5_FLASH;

@Configuration
public class AiConfig {

//    @Bean(name = "googleGenAiChatClient")
//    public ChatClient googleGenAiChatModel(GoogleGenAiChatModel googleGenAiChatModel) {
//        return ChatClient.builder(googleGenAiChatModel).build();
//    }
//
//    @Bean(name = "ollamaChatClient")
//    public ChatClient ollamaChatModel(OllamaChatModel ollamaChatModel) {
//        return ChatClient.builder(ollamaChatModel).build();
//    }

//    @Bean
//    public ChatClient chatClient(ChatClient.Builder builder) {
//        return builder
//                .defaultOptions(GoogleGenAiChatOptions.builder()
//                        .temperature(0.7)
//                        .maxOutputTokens(100))
//                .build();
//    }
}
