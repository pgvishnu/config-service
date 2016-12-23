package com.config.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.config.ConfigApplicationTests;
import com.config.util.ConfigConstants;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

/**
 * The ConfigControllerTest class.
 * 
 * @author pgvishnu
 *
 */
public class ConfigControllerTest extends ConfigApplicationTests {
	/** controller to test **/
	@Autowired
	private ConfigController controllerToTest;
	/** MockMvc **/
	private MockMvc mockMvc;

	/**
	 * the setup
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controllerToTest).build();
	}

	/**
	 * testAddConfigDocumentSuccess
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddConfigDocumentSuccess() throws Exception {
		this.mockMvc
				.perform(post(ConfigConstants.ADD_CONFIGDOC_POST_URL)
						.content(ConfigConstants.ADD_CONFIGDOC_REQUEST.getBytes())
						.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk());

	}

	/**
	 * testGetConfigDocByAppCodeAndVersion
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetConfigDocByAppCodeAndVersion() throws Exception {
		this.mockMvc
				.perform(get(ConfigConstants.GET_CONFIGDOC_BY_APPCODEVERSION_URL)
						.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));

	}

	/**
	 * testGetConfigDocVersionsByAppCode
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetConfigDocVersionsByAppCode() throws Exception {
		this.mockMvc
				.perform(get(ConfigConstants.GET_CONFIGDOC_VERSIONS_BY_APPCODE_URL)
						.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));

	}
}