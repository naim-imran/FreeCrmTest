package com.crm.qa.initialComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class InitialSetups {

    public static WebDriver driver;
    public static Properties prop;

    public InitialSetups() {
        try {

            FileInputStream fs = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/java/com/crm/qa/configurations/config.properties");
            prop = new Properties();
            prop.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializeBrowser() {
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));

    }

}
