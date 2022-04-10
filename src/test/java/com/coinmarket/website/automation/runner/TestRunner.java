package com.coinmarket.website.automation.runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        glue = {"com.coinmarket.website.automation"},
        features = {"src/test/resources/features"},
        tags = {"@CoinMarket"},
        format = {"pretty", "html:target/report"}
)
public class TestRunner {
}