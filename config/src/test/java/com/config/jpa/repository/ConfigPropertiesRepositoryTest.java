package com.config.jpa.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.config.ConfigApplicationTests;
import com.config.jpa.entity.ConfigPropertiesJPA;
import com.config.util.ConfigConstants;
/**
 * The ConfigPropertiesRepositoryTest class.
 * @author pgvishnu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ConfigPropertiesRepositoryTest   extends ConfigApplicationTests{

	/** The configRepository. */
	@Resource
	private IConfigPropertiesRepository configRepository;

	private ConfigPropertiesJPA configJPA = null;

	@Before
	public void setup() throws Exception {
		configJPA = new ConfigPropertiesJPA();
		configJPA.setAppCode("repotype");
		configJPA.setVersion(Double.valueOf(1));
		configJPA.setConfigDoc(ConfigConstants.ADD_CONFIGDOC_REQUEST);
		configJPA.setCreatedBy(ConfigConstants.APP_USER);
		configJPA.setLastModifiedBy(ConfigConstants.APP_USER);
		configJPA.setCreatedDate(new Date());
		configJPA.setLastModifiedDate(new Date());
		
		configRepository.saveAndFlush(configJPA);

	}

	/**
     * testCreateConfigDoc.
     */
    @Test
    public void testCreateConfigDoc() {
    	ConfigPropertiesJPA savedJPA = configRepository.saveAndFlush(configJPA);
    	assertNotNull(savedJPA);
    }
    
    /**
     * testFindByAppCodeAndVersion
     */
	@Test
	public void testFindByAppCodeAndVersion() {
		ConfigPropertiesJPA configJPA = configRepository.findByAppCodeAndVersion("repotype", Double.valueOf(1));
		assertNotNull(configJPA);
	}

	/**
	 * testFindVersionsByAppCode.
	 */
	@Test
	public void testFindVersionsByAppCode() {
		List<ConfigPropertiesJPA> versions = configRepository.findByAppCode("repotype");
		assertNotNull(versions);
	}

	

}
