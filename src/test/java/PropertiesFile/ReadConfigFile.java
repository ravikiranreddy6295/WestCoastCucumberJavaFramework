package PropertiesFile;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadConfigFile {

	Properties properties;
	String path= "/Users/ravikiranreddy/eclipse-workspace/WestCoastCucumberJavaFramework/src/test/java/PropertiesFile/Config.properties";
	
	public ReadConfigFile() {
		properties= new Properties();
		
		try {
			FileInputStream fis= new FileInputStream(path);
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getURl() {
		String url= properties.getProperty("url");
		if(url!=null) {
			return url;
		}
		else {
			throw new RuntimeException("url not specified in config file");
		}
	}
	
	public String getSource() {
		String source= properties.getProperty("source");
		return source;
	}
	
	public String getDestination() {
		String destination= properties.getProperty("destination");
		return destination;
	}
	
}
