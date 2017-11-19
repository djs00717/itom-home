package com.chinadrtv.itom.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
private static Properties prop;
private static Logger logger = LogManager.getLogger(PropertiesUtil.class);
	static{
		InputStream is = PropertiesUtil.class.getClassLoader()
						.getResourceAsStream("ApplicationResources.properties");
		prop = new Properties();
		try {
			prop.load(is);
		} catch (Exception e) {
		    logger.error("Can not read properties file!" + e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				    logger.error("Close inputstream error!" + e);
				}
				is = null;
			}
		}
	}
	
	/**
	 * Get property value by key
	 * @Date        :      2011-4-6
	 * @param key property key
	 * @return property value
	 */
	public static String getProperties(String key){
		String value = prop.getProperty(key);
		return value;
	}
	
	public static Properties loadResource(String fileName){
		InputStream is = PropertiesUtil.class.getClassLoader()
				.getResourceAsStream(fileName);
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (Exception e) {
		    logger.error("Can not read properties file!" + e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				    logger.error("Close inputstream error!" + e);
				}
				is = null;
			}
		}
		return prop;
	}
}
