package com.config.util;

public class ConfigConstants {

	 /** The Constant APP_NAME. */
    public static final String APP_NAME = "configapp";

    /** The Constant APP_ENV. */
    public static final String APP_ENV = "DEV";

    /** The Constant APP_TYPE. */
    public static final String APP_TYPE = "web";
    
    /** The Constant APP_TYPE. */
    public static final String APP_VERSION = "1.0";
    
    /** The Constant APP_TYPE. */
    public static final String APP_USER = "pgvishnu";
    
    /** The Constant APP_TYPE. */
    public static final String NO_DATA_FOUND = "No Data found for the given request";
    
    /** The Constant add config doc request. */
    public static final String ADD_CONFIGDOC_REQUEST = "{\"Configdata\":"
                    +"{\"name\": \""+ APP_NAME + "\",\n"
                    +"\"env\":\""+ APP_ENV + "\",\n"
                    +"\"type\":\""+ APP_TYPE + "\" \n}"
                    +"}";
    
    
    
    /** The Constant ADD_CONFIGDOC_POST_URL. */
    public static final String ADD_CONFIGDOC_POST_URL = "/api/" + APP_TYPE + "/config/"+ APP_VERSION;
    

    /** The Constant GET_CONFIGDOC_BY_APPCODEVERSION_URL. */
    public static final String GET_CONFIGDOC_BY_APPCODEVERSION_URL = "/api/" + APP_TYPE + "/config/"+ APP_VERSION;
    

    /** The Constant GET_CONFIGDOC_VERSIONS_BY_APPCODE_URL. */
    public static final String GET_CONFIGDOC_VERSIONS_BY_APPCODE_URL = "/api/" + APP_TYPE + "/config/";
    
}

