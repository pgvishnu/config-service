package com.config.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.config.domain.ConfigurationDocumentDetails;
import com.config.domain.GetDocumentRequestDetails;
import com.config.jpa.entity.ConfigPropertiesJPA;
import com.config.jpa.repository.IConfigPropertiesRepository;
import com.config.util.ConfigConstants;

/**
 * The ConfigDAO class.
 * @author pgvishnu
 *
 */
@Named("configDAO")
public class ConfigDAO implements IConfigDAO {

	 /** The log. */
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
	/** The configuration property repository. */
	@Resource
	private IConfigPropertiesRepository configPropertiesRepository;

	 /**
     * Find the app configuration document
     *
     * @param docRequest the document request object
     * @return the ConfigurationDocumentDetails
     */
	@Override
	public ConfigurationDocumentDetails findConfigDocument(GetDocumentRequestDetails docRequest) {

		log.info("inside ConfigDAO.... findConfigDocument");
		ConfigPropertiesJPA configPropJPA = configPropertiesRepository.findByAppCodeAndVersion(docRequest.getAppCode(),docRequest.getVersion());

		log.info("configPropJPA :" + configPropJPA);
		// configPropertiesRepository.findByAppCodeAndVersion(docRequest.getAppCode(),
		// docRequest.getVersion());
		if (configPropJPA != null)
			return createConfigurationDocumentDetailsFromJPA(configPropJPA);
		else
			return null;

	}

	/**
	 * add or update config doc.
	 * @param configDoc
	 */
	@Override
	public void addOrUpdateConfigDoc(ConfigurationDocumentDetails configDoc) {

		// Retrieve if already exists for the given appcode and version.

		ConfigPropertiesJPA configPropJPA = configPropertiesRepository.findByAppCodeAndVersion(configDoc.getAppCode(),
				configDoc.getVersion());

		// Create a new JPA only if it doesn't exists in db. Set created by
		// and created date for the new record.
		if (configPropJPA == null) {

			configPropJPA = new ConfigPropertiesJPA();
			configPropJPA.setCreatedBy(ConfigConstants.APP_USER);
			configPropJPA.setCreatedDate(new Date());
		}

		// if already exists, do not change created date and created by.

		configPropJPA.setAppCode(configDoc.getAppCode());
		configPropJPA.setVersion(configDoc.getVersion());
		configPropJPA.setConfigDoc(new String(configDoc.getConfigDoc()));
		configPropJPA.setLastModifiedBy(ConfigConstants.APP_USER);
		configPropJPA.setLastModifiedDate(new Date());

		configPropertiesRepository.saveAndFlush(configPropJPA);

	}

	/**
	 * 
	 * @param configPropJPA
	 * @return
	 */
	private ConfigurationDocumentDetails createConfigurationDocumentDetailsFromJPA(ConfigPropertiesJPA configPropJPA) {

		/*
		 * for simplicity, this is manually mapped. In actual projects, I would
		 * use Dozer API (DozerBeanMapper) to map between JPA and domain
		 * objects.
		 */

		ConfigurationDocumentDetails configDetails = new ConfigurationDocumentDetails();

		configDetails.setAppCode(configPropJPA.getAppCode());
		configDetails.setVersion(configPropJPA.getVersion());
		configDetails.setConfigDoc(configPropJPA.getConfigDoc().getBytes());
		configDetails.setCreatedBy(configPropJPA.getCreatedBy());
		configDetails.setCreatedDate(configPropJPA.getCreatedDate());
		configDetails.setLastModifiedBy(configPropJPA.getLastModifiedBy());
		configDetails.setLastModifiedDate(configPropJPA.getLastModifiedDate());

		return configDetails;

	}

	/**
	 *  retrieve versions of config doc for given appcode.
	 * @param appCode
	 * @return the list of ConfigurationDocumentDetails
	 */
	@Override
	public List<ConfigurationDocumentDetails> getConfigDocVersionsByAppCode(String appCode) {

		List<ConfigurationDocumentDetails> configDocList = new ArrayList<>();
		
		List<ConfigPropertiesJPA> configPropJPAList = configPropertiesRepository.findByAppCode(appCode);
		
		for(ConfigPropertiesJPA configJPA : configPropJPAList){
			
			configDocList.add(createConfigurationDocumentDetailsFromJPA(configJPA));
			
		}
		
		return configDocList;
	}

}
