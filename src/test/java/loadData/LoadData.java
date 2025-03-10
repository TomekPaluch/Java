package loadData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadData {
    private String url;
    private String validUsername;
    private String validPassword;
    private String invalidPassword;
    private String invalidUsername;
    private static LoadData instance;

    private LoadData(){
        getDataFromProperties();
    }
    public static LoadData getInstance() {
        if (instance == null) {
            instance = new LoadData();
        }
        return instance;
    }
    private void getDataFromProperties(){
        Properties properties = new Properties();
        try {


            FileInputStream fi = new FileInputStream("src/test/resources/testConfiguration.properties");
            properties.load(fi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        url = properties.getProperty("url");
        validUsername = properties.getProperty("validUsername");
        validPassword = properties.getProperty("validPassword");
        invalidPassword = properties.getProperty("invalidPassword");
        invalidUsername = properties.getProperty("invalidUsername");
    }
    public String getUrl() {
        return url;
    }

    public String getValidUsername() {
        return validUsername;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public String getInvalidUsername() {
        return invalidUsername;
    }









}
