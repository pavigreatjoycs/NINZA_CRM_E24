package com.ninza.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileUtility {
	
	public String toGetDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader fr = new FileReader("./src/test/resources/commondata.json");
		
		JSONParser jp = new JSONParser();
		Object obj =jp.parse(fr);
		JSONObject jobj = (JSONObject)obj;
		
		String value = jobj.get(key).toString();
		return value;
	}

}
