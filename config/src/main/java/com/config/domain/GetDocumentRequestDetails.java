package com.config.domain;

/**
 * The GetDocumentRequestDetails class.
 * 
 * @author pgvishnu
 *
 */
public class GetDocumentRequestDetails {

	/** The app code. */

	private String appCode;

	/** The version number. */

	private Double version;

	/**
	 * Gets the appCode.
	 *
	 * @return the appCode
	 */
	public String getAppCode() {
		return appCode;
	}

	/**
	 * Sets the appCode.
	 *
	 * @param appCode
	 *            the new appCode
	 */
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public Double getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version
	 *            the new version
	 */
	public void setVersion(Double version) {
		this.version = version;
	}

}
