package com.rest_APICaller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;


public class Configuration {

	public static String environment;


	@BeforeSuite(alwaysRun = true)
	@Parameters({"environment"})
	public void initializeEnvironment(String environment) {

		Configuration.environment = environment;

	}

	public static Properties loadProperties(String fileName, Properties properties)
			throws IOException {

		final String fileLocation = System.getProperty("user.dir") + "/resources/properties/"
				+ environment + "-" + fileName + "-" + "properties";
		final FileReader reader = new FileReader(fileLocation);
		properties = new Properties();
		properties.load(reader);
		return properties;
	}

	/**
	 * 
	 * @param fileName: Name of the Json Template
	 * @return json string
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String loadJson(String fileName) throws IOException{
		StringBuilder sb = new StringBuilder();
		final String fileLocation = System.getProperty("user.dir")+"/resources/jsontemplates/"+fileName;
		final FileReader reader = new FileReader(fileLocation);
		BufferedReader buff = new BufferedReader(reader);
		while(true) {
			String inputText = buff.readLine();
			if(inputText == null) 
				break;
			sb.append(' ').append(inputText);
		}
		return sb.toString().replaceAll(" ","");
	}

	/**
	 * 
	 * @param Json
	 * @param jsonPath
	 * @return
	 */
	public static String jsonValueExtractor(String Json, String jsonPath){
		List<Object> value = JsonPath.read(Json, jsonPath);
		return value.get(0).toString();
	}
	/**
	 * 
	 * @param Json
	 * @param jsonPath
	 * @return
	 */
	public static String[] jsonValuesExtractor(String Json, String jsonPath){
		ArrayList<Object> values = JsonPath.read(Json, jsonPath);
		String[] value = new String[values.size()];
		int i=0;
		for(Object data:values){
			
			System.out.println(data);
			value[i] =  data.toString();
			i++;
		}
		
		return value;
	}
	
	
	/**
	 * 
	 * @param json
	 * @param jsonPath
	 * @param value
	 */
	public static String jsonCreator(String json,Map<String,Object>map){
		DocumentContext doc = JsonPath.parse(json);
		for(String jsonPath:map.keySet()){
			if(map.get(jsonPath).equals("missing")){
				doc.delete(jsonPath);
			}
			else
			doc.set(jsonPath, map.get(jsonPath));
			
		}
		JsonObject jsonObj = new GsonBuilder().create().toJsonTree(doc.json()).getAsJsonObject();
		
		return jsonObj.toString();
		
	}
	
	/**
	 * 
	 * @param json: Ugly json string
	 */
	public static  void prettyPrint(String json){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		String prettyJsonString = gson.toJson(je);
		System.out.println(prettyJsonString);
	}

}
