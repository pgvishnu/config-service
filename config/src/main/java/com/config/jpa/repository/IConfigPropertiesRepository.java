package com.config.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.config.jpa.entity.ConfigPropertiesJPA;

/**
 * 
 * The Interface IConfigPropertiesRepository.
 *
 * @author pgvishnu
 *
 */
public interface IConfigPropertiesRepository extends JpaRepository<ConfigPropertiesJPA, Long> {

	/**
	 * finds the config json document by app code and version.
	 * 
	 * @param appCode
	 * @param version
	 * @return ConfigPropertiesJPA the
	 */
	ConfigPropertiesJPA findByAppCodeAndVersion(String appCode, Double version);

	/**
	 * finds the config document versions for the appcode in the descending
	 * order of last modified date.
	 * 
	 * @param appCode
	 * @return List<AppCodeVersions> the list of versions of config documents
	 *         for the given app code.
	 */
	@Query("SELECT cfgJPA FROM ConfigPropertiesJPA cfgJPA where cfgJPA.appCode = :appCode order by cfgJPA.lastModifiedDate desc")
	List<ConfigPropertiesJPA> findByAppCode(@Param("appCode") String appCode);

}
