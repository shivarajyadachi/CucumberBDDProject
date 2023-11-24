package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	String path="config.properties";
	//Constructor
	
	public ReadConfig() {
		try {
			properties = new Properties();
			// to open .config properties in input mode and load the file
			FileInputStream file = new FileInputStream(path);
			properties.load(file);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		if(value!=null)
		return value;
		else
			throw new RuntimeException("URL is not specified in config file");
	}

}
