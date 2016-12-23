package com.config.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.config.ConfigApplicationTests;
import com.config.dao.IConfigDAO;
import com.config.domain.ConfigurationDocumentDetails;
import com.config.domain.GetDocumentRequestDetails;
import com.config.exception.ConfigException;
import com.config.util.ConfigConstants;
/**
 * The ConfigServiceTest class.
 * @author pgvishnu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ConfigServiceTest extends ConfigApplicationTests {

	/** The database dao. */
	@Inject
	@Named("configDAO")
	private IConfigDAO databaseDao;

	/** The redeem anywhere enrollment service. */
	@Inject
	private IConfigService configService;

	/** The request for getconfigdoc */
	private GetDocumentRequestDetails docRequest = null;

	/** The config document details */

	private ConfigurationDocumentDetails docDetails = null;

	/**
	 * the setup.
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception {

		docRequest = new GetDocumentRequestDetails();
		docRequest.setAppCode("newtype");
		docRequest.setVersion(Double.valueOf("7.0"));

		// Configuration document details

		docDetails = new ConfigurationDocumentDetails();

		docDetails.setAppCode(docRequest.getAppCode());
		docDetails.setVersion(docRequest.getVersion());
		docDetails.setConfigDoc(ConfigConstants.ADD_CONFIGDOC_REQUEST.getBytes());

		// add document to db
		configService.addOrUpdateConfigDoc(docDetails);

	}

	/**
	 * getConfigDocTest
	 * 
	 */
	@Test
	public void getConfigDocTest() {

		ConfigurationDocumentDetails response = configService.getConfigDoc(docRequest);
		assertNotNull(response);

		if (response != null) {
			assertTrue(response.getAppCode().equals(docRequest.getAppCode()));
			assertTrue(response.getVersion().doubleValue() == (docRequest.getVersion().doubleValue()));
			assertNotNull(response.getConfigDoc());
			assertTrue(Arrays.equals(response.getConfigDoc(), docDetails.getConfigDoc()));

		}
	}

	/**
	 * getConfigDocVersionsTest
	 * 
	 */
	@Test
	public void getConfigDocVersionsTest() {

		List<ConfigurationDocumentDetails> response = configService.getConfigDocVersionsForAppCode(docRequest.getAppCode());

		assertNotNull(response);

	}

}
