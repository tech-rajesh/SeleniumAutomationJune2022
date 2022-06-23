package log4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfigFile {

    Properties prop;

    public ReadConfigFile() throws Exception {

        FileInputStream fis = new FileInputStream("./configFolder/config.properties");

        prop = new Properties();

        prop.load(fis);

    }

    public String getAppURL() {

        String url = prop.getProperty("appURL");
        return url;
    }

    public String getAdminUserName() {

        return prop.getProperty("adminUserName");

    }

    public String getPassword() {

        return prop.getProperty("adminPassword");

    }

}
