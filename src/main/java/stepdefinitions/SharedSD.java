package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigReader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class SharedSD {

    private static WebDriver driver = null;

    @Before //("@web")
    public static void before() throws IOException {
        ConfigReader config = new ConfigReader();

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(config.getUrl());

    }

    @After//("@web")
    public static void after() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            //driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
