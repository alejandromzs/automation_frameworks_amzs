package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
        
	private static WebDriver driver;
	
	@Before
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
	}
	
	@After
	public void afterClass() {
        driver.quit();
	}

}