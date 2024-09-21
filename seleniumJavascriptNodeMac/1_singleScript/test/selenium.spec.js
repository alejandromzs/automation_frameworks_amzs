const {By, Builder, Browser} = require('selenium-webdriver');
const assert = require("assert");

describe('First script', function () {
  let driver;

  before(async function () {
    driver = await new Builder().forBrowser(Browser.CHROME).build();
  });

  it('First Selenium script with mocha', async function () {
    this.timeout(15000); // By default, Mocha has a timeout of 2000ms (2 seconds) for each test.
                        // If your test exceeds this time, Mocha will throw a timeout error.
                        //Setting timeout to 15 seconds just for testing purpose
    await driver.get('https://www.selenium.dev/selenium/web/web-form.html');

    let title = await driver.getTitle();
    assert.equal("Web form", title);

    await driver.manage().setTimeouts({implicit: 500});

    let textBox = await driver.findElement(By.name('my-text'));
    let submitButton = await driver.findElement(By.css('button'));
    await new Promise(resolve => setTimeout(resolve, 5000));
    await textBox.sendKeys('Selenium');
    await submitButton.click();

    let message = await driver.findElement(By.id('message'));
    let value = await message.getText();
    assert.equal("Received!", value);
    await new Promise(resolve => setTimeout(resolve, 3000));
  });

  after(async () => await driver.quit());
});