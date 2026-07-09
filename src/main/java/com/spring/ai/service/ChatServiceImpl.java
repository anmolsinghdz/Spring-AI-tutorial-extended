package com.spring.ai.service;

import com.spring.ai.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.metadata.ChatResponseMetadata;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatClient chatClient;

    @Value("classpath:/prompts/user-message.st")
    private Resource userMessage;

    @Value("classpath:/prompts/system-message.st")
    private Resource systemMessage;

    public  ChatServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public String chat(String query) {
//        String prompt="List top 5 most powerful leaders of the world in 2026";

//        String response = chatClient
//                .prompt()
//                .user(prompt)
//                .system("As an expert in Geopolitics")
//                .call()
//                .content();


//        Prompt prompt1 = new Prompt(query, GoogleGenAiChatOptions.builder()
//                .model("")
//                .temperature(0.3)
//                .maxTokens(100)
//                .build());

        Prompt prompt1=new Prompt(query);

        String queryStr="As an expert in coding and programming. " +
                "Always write programs in java. Now reply for this questions: {query}";
//        String response = chatClient.prompt(prompt1).call().content();

//        String response = chatClient
//                .prompt(prompt1)
//                .call()
//                .chatResponse()
//                .getResult()
//                .getOutput()
//                .getText();


//        List<Tut> tutorials = chatClient
//                .prompt(prompt1)
//                .call()
//                .entity(new ParameterizedTypeReference<List<Tut>>() {
//                });


        //using fluent api we got prompt
//        String response = chatClient
//                .prompt()
//                .user(u->u.text(queryStr).param("query",query))
//                .call()
//                .content();

        //using prompt template
        //prompt
        //get prompt template from resources

        //System.out.println(response);

        return "response";
    }

    public String chatTemplate(String q){

        /*
        //prompt template
        PromptTemplate strTemplate = PromptTemplate.builder()
                .template("Tell me about {techName}? Explain using example {exampleName}")
                .build();

        //render the template
        String renderedMessage = strTemplate.render(Map.of(
                "techName","Spring","exampleName","Spring Boot"));

        //prepare the prompt
        Prompt prompt = new Prompt(renderedMessage);

        //give the prompt to chatClient
        String response = chatClient
                .prompt(prompt)
                .call()
                .content();

         */


        //role based prompting
//        SystemPromptTemplate systemPromptTemplate = SystemPromptTemplate.builder()
//                .template("You are a helpful coding assistant. You are an expert in coding")
//                .build();
//        Message systemMessage = systemPromptTemplate.createMessage();
//
//        PromptTemplate userPromptTemplate = PromptTemplate.builder()
//                .template("Tell me about {techName}? Explain using example {exampleName}")
//                .build();
//        Message userMessage = userPromptTemplate.createMessage(
//                Map.of("techName", "Spring", "exampleName", "Spring Boot"));
//
//        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
//
//        String response = chatClient
//                .prompt(prompt)
//                .call()
//                .content();


        //fluent api prompting
//        String response = chatClient
//                .prompt()
//                .system(system->
//                        system.text("You are a helpful coding assistant. You are an expert in coding"))
//                .user(user->
//                        user.text("Tell me about {techName}? Explain using example {exampleName}")
//                        .params(Map.of("techName","Spring","exampleName","Spring Boot")))
//                .call()
//                .content();


        //reading prompt from external resource
//        String response = chatClient
//                .prompt()
//                .system(system->
//                        system.text(systemMessage))
//                .user(user->
//                        user.text(userMessage).param("concept","Spring Boot"))
//                .call()
//                .content();

        String response = chatClient
                .prompt()
                .system(system ->
                        system.text(systemMessage))
                .user(user ->
                        user.text(userMessage).param("concept", q))
                .call()
                .content();

        return response;
    }
}
