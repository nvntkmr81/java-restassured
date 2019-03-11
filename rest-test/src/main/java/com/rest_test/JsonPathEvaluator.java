package com.rest_test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.rest_APICaller.Configuration;

public class JsonPathEvaluator {
	public static void main(String[] args) throws IOException {
		Map<String,Object> map = new HashMap<String,Object>();	
		String json = Configuration.loadJson("test");
		Configuration.prettyPrint(json);
		String bookCategoryJsonPath = "$..book[1].category";
		String bicycleColorJsonPath = "$..bicycle.color";
		map.put(bookCategoryJsonPath,"Local");
		map.put(bicycleColorJsonPath, "Green");
		String newJson = Configuration.jsonCreator(json, map);
		Configuration.prettyPrint(newJson);
		System.out.println(Configuration.jsonValueExtractor(newJson, bicycleColorJsonPath));
		System.out.println(Configuration.jsonValueExtractor(newJson, bookCategoryJsonPath));
		
	}

}
