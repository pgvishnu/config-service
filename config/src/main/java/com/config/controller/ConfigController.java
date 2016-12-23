package com.config.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.config.domain.ConfigurationDocumentDetails;
import com.config.domain.GetDocumentRequestDetails;
import com.config.exception.ConfigException;
import com.config.service.IConfigService;
import com.config.util.ConfigConstants;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * The Class ConfigController
 * 
 * @author pgvishnu
 *
 */
@RestController
@Api(value = "Config Service", description = "a rest service", basePath = "/api")
@RequestMapping("/api")
public class ConfigController {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/** The Config service. */
	@Inject
	private IConfigService configService;

	/**
	 * Returns the Json document for the given Appcode and version.
	 *
	 * @param appCode
	 *            the application code
	 * @param version
	 *            the version number
	 * @return the response
	 * @throws ConfigException
	 */
	@RequestMapping(value = "/{appCode}/config/{version}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public byte[] getConfigDoc(
			@ApiParam(value = "app code", defaultValue = "ios") @PathVariable("appCode") String appCode,
			@ApiParam(value = "version ", defaultValue = "1") @PathVariable("version") String versionNum)
			throws ConfigException {

		log.info("inside Config controller.. getConfigDoc()");
		log.info("appCode :" + appCode);
		log.info("versionNum :" + versionNum);

		GetDocumentRequestDetails docRequest = new GetDocumentRequestDetails();
		docRequest.setAppCode(appCode);
		docRequest.setVersion(Double.valueOf(versionNum));
		ConfigurationDocumentDetails configDocDetails = configService.getConfigDoc(docRequest);
		if (configDocDetails != null && configDocDetails.getConfigDoc() != null) {
			return configDocDetails.getConfigDoc();
		} else {
			return ConfigConstants.NO_DATA_FOUND.getBytes();
		}

	}

	/**
	 * Create or update the Json document for the given Appcode and version.
	 *
	 * @param appCode
	 *            the application code
	 * @param version
	 *            the version number
	 * @return the response
	 * 
	 */
	@RequestMapping(value = "/{appCode}/config/{version}", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<HttpStatus> addOrUpdateConfigDoc(HttpEntity<String> httpEntity,
			@ApiParam(value = "app code", defaultValue = "ios") @PathVariable("appCode") String appCode,
			@ApiParam(value = "version ", defaultValue = "1") @PathVariable("version") String versionNum) {

		log.info("json string :" + httpEntity.getBody());

		log.info("inside Config controller.. addOrUpdateConfigDoc()");
		log.info("appCode :" + appCode);
		log.info("versionNum :" + versionNum);

		ConfigurationDocumentDetails configDoc = new ConfigurationDocumentDetails();
		configDoc.setAppCode(appCode);
		configDoc.setConfigDoc(httpEntity.getBody().getBytes());
		configDoc.setVersion(Double.valueOf(versionNum));
		configService.addOrUpdateConfigDoc(configDoc);

		// Return Ok response back to front end
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}

	/**
	 * Returns list of available versions of config document for the app code
	 * sorted by last modified date in descending order
	 *
	 * @param appCode
	 *            the application code
	 * @return List<AppCode Versions> the list of versions of document.
	 * @throws ConfigException
	 */
	@RequestMapping(value = "/{appCode}/config", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ConfigurationDocumentDetails> getConfigDocVersionsforAppCode(
			@ApiParam(value = "app code", defaultValue = "ios") @PathVariable("appCode") String appCode)
	{

		log.info("inside Config controller.. getConfigDocVersionsforAppCode()");
		log.info("appCode :" + appCode);

		return configService.getConfigDocVersionsForAppCode(appCode);

	}

}
