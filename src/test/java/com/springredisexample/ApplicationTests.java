package com.springredisexample;

import com.springredisexample.controller.MainController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private MainController controller;


	@Test
	public void test() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(content().string(containsString("")));
	}

	@Test
	public void getEmployeeByIdAPI() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/add/{id}/{name}", 1,"Peter")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("/all").value(1));
	}

}
