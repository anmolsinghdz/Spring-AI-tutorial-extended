package com.spring.ai;

import com.spring.ai.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstAiProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ChatService chatService;

	@Test
	void TestTemplateRender(){
		System.out.println("template renderer");

		String output = this.chatService.chatTemplate();

		System.out.println(output);
	}
}
