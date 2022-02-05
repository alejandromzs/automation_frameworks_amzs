package glue;

import com.aprende.web.lib.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BlockChainPages;

public class BlockchainStepDefinition {
    WebDriverManager seleniumDriver;
    BlockChainPages blockChain;

    @Before
    public void beforeClass() {
        seleniumDriver = new WebDriverManager();

    }

    @After
    public void afterClass() {
        seleniumDriver.getDriver().close();
        seleniumDriver.getDriver().quit();
    }

    @Given("I want to test a blockchain page")
    public void i_want_to_test_a_blockchain_page() {
        blockChain = new BlockChainPages(seleniumDriver.getDriver());
    }


    @When("I open the endpoint {string} for block number {string}")
    public void i_open_the_endpoint_for_block_number(String baseUrl, String blockNumber) {
        blockChain.openUrl(baseUrl,blockNumber);
    }

    //------------ For imperative style ------------- //
    @Given("I save the value from the {string} key in session")
    public void i_save_the_value_from_the_key_in_session(String key) {
        blockChain.saveValueFromKey(key);
    }


    @Then("the current {string} key is equal to the value from session {string}")
    public void the_current_key_is_equal_to_the_value_from_session(String currentKey, String sessionKey) {
        blockChain.validateKeys(currentKey,sessionKey);
    }



//------------ For Declarative style ------------- //
    @When("I save the prev_block and the hash for the next {int} block(s) using the same endpoint {string}")
    public void i_save_the_and_the_for_the_next_blocks_using_same_endpoint(int iterations, String url) {

        blockChain.saveValueFromKey(iterations,url);
    }

    @Then("I verify that each hash for a block is equal to the prev_block of the next block")
    public void i_verify_that_each_hash_for_a_block_is_equal_to_the_prev_block_of_the_next_block() {
       blockChain.validateStoredHashes();
    }


}
