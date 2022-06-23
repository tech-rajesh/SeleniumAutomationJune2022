package configReadExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	Properties prop;

	public ReadDataFromPropertyFile() throws Exception {

		FileInputStream fis = new FileInputStream(".\\data\\config.properties");

		prop = new Properties();

		prop.load(fis);

	}

	public String getAppURL() {

		String appURL = prop.getProperty("qa_url");
		return appURL;

	}

	public String getAdminUser() {

		return prop.getProperty("userName");

	}

	public String getPasword() {

		return prop.getProperty("password");

	}

}
