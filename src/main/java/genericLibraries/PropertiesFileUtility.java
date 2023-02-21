package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains all reusable methods to perform operation on properties file
 * @author sunil
 *
 */
public class PropertiesFileUtility {

	private	Properties property;
	/**
	 * This method is used to initialize the properties file
	 * @param path
	 */
	public void propertiesFileInitialization(String filepath)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * This method return the data from properties file based on the key .
	 * @param key
	 * @return
	 */
	public String fetchProperty(String key)
	{
		return property.getProperty(key);
	}
}	
