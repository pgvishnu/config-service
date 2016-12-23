package com.config.domain;

import java.util.Date;

/**
 * The ConfigurationDocumentDetails class.
 * 
 * @author pgvishnu
 *
 */
public class ConfigurationDocumentDetails {

	/** The app code. */
	private String appCode;

	/** The version. */
	private Double version;

	/** The configDoc. */
	private byte[] configDoc;

	/** The createdBy. */
	private String createdBy;

	/** The createdDate */
	private Date createdDate;

	/** The lastModifiedBy */
	private String lastModifiedBy;

	/** The lastModifiedDate */
	private Date lastModifiedDate;

	/**
	 * Gets the appCode.
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

	/**
	 * Gets the createdBy.
	 * @return the createdBy
	 */
	public byte[] getConfigDoc() {
		return configDoc;
	}

	/**
	 * Sets the configDoc.
	 *
	 * @param configDoc
	 *            the new configDoc
	 */
	public void setConfigDoc(byte[] configDoc) {
		this.configDoc = configDoc;
	}

	/**
	 * Gets the createdBy.
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the createdBy.
	 *
	 * @param createdBy
	 *            the new createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the createdDate.
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the createdDate.
	 *
	 * @param createdDate
	 *            the new createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	/**
	 * Gets the lastModifiedBy.
	 * @return the lastModifiedBy
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * Sets the lastModifiedBy.
	 *
	 * @param lastModifiedBy
	 *            the new lastModifiedBy
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * Gets the lastModifiedDate.
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * Sets the lastModifiedDate.
	 *
	 * @param lastModifiedDate
	 *            the new lastModifiedDate
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
