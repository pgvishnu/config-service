package com.config.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
/**
 * The ConfigPropertiesJPA class.
 * @author pgvishnu
 *
 */
@Entity
@Table(name = "APP_CONFIGURATION_DETAILS")
public class ConfigPropertiesJPA {

	/** Primary key Id **/

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	/** The app code. */
	@Column(name = "APP_CODE", nullable = false)
	private String appCode;

	/** The version number. */
	@Column(name = "VERSION", nullable = false)
	private Double version;

	/** The config document. */
	@Column(name = "DOCUMENT", nullable = false)

	@Lob
	private String configDoc;

	/** The created date. */
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	/** The created by. */
	@Column(name = "CREATED_BY")
	private String createdBy;

	/** The last modified date. */
	@Column(name = "LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

	/** The last modified by. */
	@Column(name = "LAST_MODIFIED_BY")
	private String lastModifiedBy;

	/**
	 * Gets the configDoc.
	 *
	 * @return the configDoc
	 */
	public String getConfigDoc() {
		return configDoc;
	}

	/**
	 * Sets the configDoc.
	 *
	 * @param configDoc
	 *            the new configDoc
	 */
	public void setConfigDoc(String configDoc) {
		this.configDoc = configDoc;
	}

	/**
	 * Gets the createdDate.
	 *
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
	 * Gets the createdBy.
	 *
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
	 * Gets the lastModifiedDate.
	 *
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

	/**
	 * Gets the lastModifiedBy.
	 *
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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
