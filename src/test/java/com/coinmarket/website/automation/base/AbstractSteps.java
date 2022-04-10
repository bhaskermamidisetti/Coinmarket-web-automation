package com.coinmarket.website.automation.base;

import com.coinmarket.website.automation.utils.ConfigUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractSteps {
    public static WebDriver driver;
    private String WEB_DRIVER = "webdriver.chrome.driver";

    public WebDriver getDriver() throws InterruptedException {
        System.setProperty(WEB_DRIVER, ConfigUtils.getDriverPath());
        System.out.println(ConfigUtils.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigUtils.getBaseURL());
        Thread.sleep(5000);
        return driver;
    }

}