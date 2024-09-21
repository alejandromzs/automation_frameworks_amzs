package pages;

import com.aprende.web.dataEntities.BlockEntity;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public class BlockChainPages {
    WebDriver driver;
    HashMap<String,String> keyMap = new HashMap<>();
    BlockEntity[] blocks;

    protected By jsonStringLocator = By.xpath("/html/body/pre");
    String blockNumber;

public BlockChainPages(WebDriver driver){
    this.driver = driver;
}

    public void openUrl(String baseUrl, String blockNumber) {
        driver.get(baseUrl+blockNumber);
        this.blockNumber=blockNumber;
    }

    public String getValueFromJson(String key){
        String jsonString =  driver.findElement(jsonStringLocator).getText();
        JSONObject obj = new JSONObject(jsonString);
        return  obj.getString(key);
    }

    public void saveValueFromKey(String key) {
        String value = getValueFromJson(key);
        keyMap.put(key,value);
        System.out.println("saved (Key: " + key + " = "+value);
    }

    public void validateKeys(String currentKey, String sessionKey) {
        String jsonString =  driver.findElement(jsonStringLocator).getText();
        JSONObject obj = new JSONObject(jsonString);
        String currentValue = obj.getString(currentKey);
        Assert.assertEquals(currentValue,keyMap.get(sessionKey));
        System.out.println("currentValue " + currentValue + "is equal to " + keyMap.get(sessionKey));
    }

    public void saveValueFromKey(int iterations, String url) {
        blocks = new BlockEntity[iterations+1];
        int currentBlockNumber = Integer.parseInt(blockNumber);

        for (int i = 0; i <=iterations; i++) {
            String newUrl= url+(currentBlockNumber+i);
            //System.out.println("Searching in url: " + newUrl);
            driver.get(newUrl);
            blocks[i]= new BlockEntity(getValueFromJson("prev_block"),getValueFromJson("hash"));
        }

    }

    public void validateStoredHashes() {
        for (int i = 1; i < blocks.length; i++) {
            //System.out.println(blocks[i-1].getHash() + "  & " +blocks[i].getPrev_block());
             Assert.assertEquals(blocks[i-1].getHash(),blocks[i].getPrev_block());
        }
    }
}
