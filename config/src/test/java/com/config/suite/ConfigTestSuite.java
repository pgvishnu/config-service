package com.config.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.config.controller.ConfigControllerTest;
import com.config.jpa.repository.ConfigPropertiesRepositoryTest;
import com.config.service.ConfigServiceTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({ ConfigControllerTest.class, ConfigServiceTest.class, ConfigPropertiesRepositoryTest.class

})

/**
 * The ConfigTestSuite class.
 * @author pgvishnu
 *
 */
public class ConfigTestSuite {

}
