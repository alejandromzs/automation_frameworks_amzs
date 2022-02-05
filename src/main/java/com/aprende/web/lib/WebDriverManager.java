package com.aprende.web.lib;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    String browser = PropertiesVault.getProp("webdriver.browser");
    WebDriver driver;

    public WebDriverManager(){

        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/"+PropertiesVault.getProp("webdriver.driver.path")+"/"+PropertiesVault.getProp("webdriver.driver.version"));
                driver = new ChromeDriver();
                break;
            default:
                //chrome browser Dimension
                Dimension dimension = new Dimension(Integer.parseInt(PropertiesVault.getProp("webdriver.browser.dimension.width")), Integer.parseInt(PropertiesVault.getProp("webdriver.browser.dimension.height")));
                driver.manage().window().setSize(dimension);
                //implicit wait
                driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertiesVault.getProp("webdriver.wait.implicit")), TimeUnit.SECONDS);
                break;

        }

    }

    public WebDriver getDriver() {
        return driver;
    }
}
