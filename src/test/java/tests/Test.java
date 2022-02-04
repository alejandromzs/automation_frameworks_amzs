package tests;

import com.aprende.web.lib.PropertiesVault;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Test {
        
	private static WebDriver driver;
	

	
	@After
	public void afterClass() {
        driver.quit();
	}

}