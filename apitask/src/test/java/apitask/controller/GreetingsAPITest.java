package apitask.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import apitask.common.Messages;

public class GreetingsAPITest {

		private MockMvc mockMvc;

		@InjectMocks
		GreetingsAPIController greetingsController;
		
		@Before
		public void setUp() throws Exception {
			MockitoAnnotations.initMocks(this);
			this.mockMvc = MockMvcBuilders.standaloneSetup(greetingsController).build();
		}

		@Test
		public void testHappyDay() throws Exception {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/greetings"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string(Messages.HELLO_WORLD));
		}

		@Test
		public void testNotFound() throws Exception {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/greetings/badurl")).andExpect(MockMvcResultMatchers.status().isNotFound());
		}

	}