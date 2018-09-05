package project.apitests.utils;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

@Slf4j
@Data
public class SettingsManager {

    private String baseUrl;
    private String url;
    @Getter
    private static String login;
    @Getter
    private static String password;
    private String pathToExpectedJson;
    @Getter
    private static File file;


    public void initialization() {

        log.info("Initialization....");

        // declare filestream variables and property
        FileInputStream fileStream;
        Properties property = new Properties();

        try {
            // set variables from api.properties file
            fileStream = new FileInputStream("src/test/resources/api.properties");
            property.load(fileStream);

            baseUrl = property.getProperty("api.base.url");
            url = baseUrl;
            login = property.getProperty("api.login");
            password = property.getProperty("api.password");
            pathToExpectedJson = property.getProperty("api.path.json");
            file = new File(System.getProperty("user.dir") + pathToExpectedJson);

            log.info("Property API url: " + baseUrl);
            log.info("Property API login: " + login);
            log.info("Property API password: " + password);
            log.info("Path to expected JSON: " + pathToExpectedJson);

        } catch (IOException e) {
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }

}

