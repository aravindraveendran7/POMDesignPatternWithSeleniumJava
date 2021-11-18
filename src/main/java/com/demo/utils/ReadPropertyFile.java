package com.demo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.demo.constants.FrameworkConstants;
import com.demo.enums.ConfigProperties;

public final class ReadPropertyFile {

	private static Properties prop=new Properties();
	private static final Map<String,String>CONFIGMAP=new HashMap<String,String>();
	private ReadPropertyFile() {

	}
	static {

		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
			prop.load(file);

			/*one way of iterating thru the properites file
			 for(Object key:prop.keySet()) {
			 CONFIGMAP.put(String.valueOf(key), String.valueOf(prop.get(key)));
			} 
			 */
			for(Map.Entry<Object, Object>entry:prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String get(ConfigProperties key) throws Exception {
		if(Objects.isNull(key)||Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
			throw new Exception("Property file"+key+"is not found");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}


}
