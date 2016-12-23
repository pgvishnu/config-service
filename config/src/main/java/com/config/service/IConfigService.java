package com.config.service;

import java.util.List;

import com.config.domain.ConfigurationDocumentDetails;
import com.config.domain.GetDocumentRequestDetails;

public interface IConfigService {

	/**
	 * handles get jsondoc requests for the given document request.
	 *
	 * @param docRequest
	 *            the document request
	 * @return the ConfigurationDocumentDetails
	 * 
	 */
	ConfigurationDocumentDetails getConfigDoc(GetDocumentRequestDetails docRequest);

	/**
	 * add or update config document to the database.
	 *
	 * @param configDoc
	 *            the document details.
	 * 
	 * 
	 */
	void addOrUpdateConfigDoc(ConfigurationDocumentDetails configDoc);

	/**
	 * handles get jsondoc versions for the given appcode.
	 *
	 * @param appCode
	 *            the appCode
	 * @return the list of AppCodeVersions.
	 * 
	 */
	List<ConfigurationDocumentDetails> getConfigDocVersionsForAppCode(String appCode);

}
