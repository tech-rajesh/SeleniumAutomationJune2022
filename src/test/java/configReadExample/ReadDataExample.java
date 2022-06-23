package configReadExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataExample {

	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fis = new FileInputStream(".\\data\\config.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		
		System.out.println("AppURL: " +prop.getProperty("qa_url"));
		System.out.println("Dev AppURL: " +prop.getProperty("dev_url"));
		System.out.println("userName: " + prop.getProperty("userName"));
		
		
		
		
	}

}
