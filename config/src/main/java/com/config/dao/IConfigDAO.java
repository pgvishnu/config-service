package com.config.dao;

import java.util.List;

import com.config.domain.ConfigurationDocumentDetails;
import com.config.domain.GetDocumentRequestDetails;

/**
 * The IConfigDAO interface.
 * @author pgvishnu
 *
 */

public interface IConfigDAO {

	 /**
     * Find the app configuration document
     *
     * @param docRequest the document request object
     * @return the ConfigurationDocumentDetails
     */
	ConfigurationDocumentDetails findConfigDocument(GetDocumentRequestDetails docRequest);
	
	/**
	 * add or update config doc.
	 * @param configDoc
	 */
	void addOrUpdateConfigDoc(ConfigurationDocumentDetails configDoc);
	
	/**
	 *  retrieve versions of config doc for given appcode.
	 * @param appCode
	 * @return the list of ConfigurationDocumentDetails
	 */
	List<ConfigurationDocumentDetails> getConfigDocVersionsByAppCode(String appCode);
}
