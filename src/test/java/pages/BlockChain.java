package pages;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class BlockChain {
    WebDriver driver;
    HashMap<String,String> keyMap = new HashMap<>();


    protected By jsonStringLocator = By.xpath("/html/body/pre");

public BlockChain(WebDriver driver){
    this.driver = driver;
}

    public void openUrl(String baseUrl, String blocknumber) {
    driver.get(baseUrl+blocknumber);
    }

    public void saveValueFromKey(String key) {
        String jsonString =  driver.findElement(jsonStringLocator).getText();
        //System.out.println(jsonString);
         JSONObject obj = new JSONObject(jsonString);
         String value = obj.getString(key);
         keyMap.put(key,value);
        System.out.println(keyMap);

    }

    public void validateKeys(String currentKey, String sessionKey) {
        String jsonString =  driver.findElement(jsonStringLocator).getText();
        JSONObject obj = new JSONObject(jsonString);
        String currentValue = obj.getString(currentKey);
        System.out.println(currentValue +" , " +keyMap.get(sessionKey));
        Assert.assertEquals(currentValue,keyMap.get(sessionKey));
    }
}
