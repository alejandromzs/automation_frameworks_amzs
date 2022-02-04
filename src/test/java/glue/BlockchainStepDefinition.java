package glue;

import com.aprende.web.lib.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BlockChain;

import java.io.IOException;

public class BlockchainStepDefinition {
    WebDriverManager seleniumDriver;
    BlockChain blockChain;

    @Before
    public void beforeClass() throws IOException {
        seleniumDriver = new WebDriverManager();

    }

    @After
    public void afterClass() {
        seleniumDriver.getDriver().close();
        seleniumDriver.getDriver().quit();
    }

    @Given("I want to test a blockchain page")
    public void i_want_to_test_a_blockchain_page() {
        blockChain = new BlockChain(seleniumDriver.getDriver());
    }


    @When("I open the endpoint {string} for block number {string}")
    public void i_open_the_endpoint_for_block_number(String baseUrl, String blocknumber) {
        blockChain.openUrl(baseUrl,blocknumber);
    }

    @Given("I save the value from the {string} key in session")
    public void i_save_the_value_from_the_key_in_session(String key) {
        blockChain.saveValueFromKey(key);
    }


    @Then("the current {string} key is equal to the value from session {string}")
    public void the_current_key_is_equal_to_the_value_from_session(String currentKey, String sessionKey) {
        blockChain.validateKeys(currentKey,sessionKey);
    }


}
