package com.coinmarket.website.automation.utils;

public class ConfigUtils {

    private static final String BASE_URL = "https://coinmarketcap.com";
    private static final String DRIVER_PATH = "src/test/resources/driver/chromedriver.exe";

    public static String getBaseURL() {
        return BASE_URL;
    }

    public static String getDriverPath() {
        return DRIVER_PATH;
    }
}