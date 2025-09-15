package com.ninza.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	public String toGetDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
}
