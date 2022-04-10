package com.coinmarket.website.automation.stepDefinitions;

import com.coinmarket.website.automation.base.AbstractSteps;
import cucumber.api.java.en.Given;

public class LoginPage extends AbstractSteps {

    @Given("^Launch the CoinMarket web site$")
    public void launchTheCoinMarketWebSite() throws InterruptedException {
            getDriver();
        Thread.sleep(4000);
    }
}