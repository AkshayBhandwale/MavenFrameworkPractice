package com.saucelab.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	String path = "C:\\Akshay\\Softwares\\Automation Testing\\FrameworkPractice\\Configuration\\Config.properties";
	
	//create constructor
	public ReadConfig() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Read data from properties file
	public String getBrowser() {
		String browserKey = prop.getProperty("browser");
		
		//Check if value is valid or not
		if(browserKey!=null)
			return browserKey;
		else throw new RuntimeException("Browser not valid");			
	}
	
	public String getURL() {
		String UrlKey = prop.getProperty("url");
		if(UrlKey!=null)
			return UrlKey;
		else throw new RuntimeException("URL not valid");
	}
}
