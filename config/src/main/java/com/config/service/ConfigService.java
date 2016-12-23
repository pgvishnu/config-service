package com.config.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.config.dao.IConfigDAO;
import com.config.domain.ConfigurationDocumentDetails;
import com.config.domain.GetDocumentRequestDetails;

/**
 * Handles all application configuration related services.
 * @author pgvishnu
 *
 */
@Named("configService")
public class ConfigService implements IConfigService {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/** The database dao. */
	@Inject
	@Named("configDAO")
	private IConfigDAO configDao;

	/**
	 * handles get jsondoc requests for the given document request.
	 *
	 * @param docRequest
	 *            the document request
	 * @return the ConfigurationDocumentDetails
	 * 
	 */
	@Override
	public ConfigurationDocumentDetails getConfigDoc(GetDocumentRequestDetails docRequest)  {

		log.info("inside Config service.. getConfigDoc");
		log.info("appCode :" + docRequest.getAppCode());
		log.info("versionNum :" + docRequest.getVersion());

		return configDao.findConfigDocument(docRequest);

	}

	/**
	 * add or update config document to the database.
	 *
	 * @param configDoc
	 *            the document details.
	 * 
	 * 
	 */
	@Override
	public void addOrUpdateConfigDoc(ConfigurationDocumentDetails configDoc) {

		configDao.addOrUpdateConfigDoc(configDoc);

	}

	/**
	 * handles get jsondoc versions for the given appcode.
	 *
	 * @param appCode
	 *            the appCode
	 * @return the list of AppCodeVersions.
	 * 
	 */
	@Override
	public List<ConfigurationDocumentDetails> getConfigDocVersionsForAppCode(String appCode) {

		List<ConfigurationDocumentDetails> appVersions = configDao.getConfigDocVersionsByAppCode(appCode);
		if (appVersions == null) {
			return new ArrayList<>(); // return an empty list if there is no matching data found.
		} else {
			return appVersions;
		}

	}

}
