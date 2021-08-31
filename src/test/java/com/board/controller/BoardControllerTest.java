package com.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.board.controller.*;

@SpringBootTest
public class BoardControllerTest {
	
	@Autowired
	BoardController bcont;
	
	private MockMvc mock;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardControllerTest.class);

	@BeforeEach
	public void setup() {
	    mock = MockMvcBuilders.standaloneSetup(bcont).build();
		logger.debug("setup BoardControllerTest mockMvc...");
	}
	
	
	@Test
	public void testList() throws Exception {
		mock.perform(get("/board/list.do"))
		.andDo(print())
        	//정상 처리 되는지 확인
		.andExpect(status().isOk())
        	//담당 컨트롤러가 BoardController인지 확인
		.andExpect(handler().handlerType(BoardController.class))
        	//메소드 이름이 list인지 확인
		.andExpect(handler().methodName("openBoardList"));
	}
	
	
}
