package com.coinmarket.website.automation.stepDefinitions;

import com.coinmarket.website.automation.base.AbstractSteps;
import com.coinmarket.website.automation.pageclass.ProductPageObjects;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductPage extends AbstractSteps {
    private List<WebElement> stepThreeResults;

    @When("^verify CoinMarket website loaded successfully$")
    public void verifyCoinMarketWebsiteLoadedSucessfully() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Cryptocurrency Prices, Charts And Market Capitalizations | CoinMarketCap";

        assertEquals(expectedTitle, actualTitle);

    }
    @Then("^Select the Show rows dropdown to display twenty rows$")
    public void selectTheShowRowsDropdownToDisplayTwentyRows() {
        driver.findElement(By.xpath(ProductPageObjects.ShowrowsDropDownList)).click();
        driver.findElement(By.xpath(ProductPageObjects.ListToSelectTwnetyRows)).click();
    }

    @And("^Capture all the page contents for Name Price and position$")
    public void captureAllThePageContentsForNamePriceAndPosition() {

        List <WebElement> col = driver.findElements(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[5]/table/thead/tr/th"));
        System.out.println("No of cols are : " +col.size());
        //No.of rows
        List <WebElement> rows = driver.findElements(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr/td[1]"));
        System.out.println("No of rows are : " + rows.size());
        //get all the search result in the frame
        stepThreeResults=driver.findElements(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[5]/table"));
        //iterate the above list to get all the search titles
        for(WebElement eachResult : stepThreeResults) {
            System.out.println("Selected Results for twenty rows : "+eachResult.getText()+",");
       }

    }

    @And("^then select Mienable and click on all crypto currencies and select coins and click on show results button$")
    public void thenSelectMienableAndClcikOnAllCryptocurriencisAndSelectCoinsAndClickOnShowResultsButton() throws InterruptedException {
        WebElement mineableradiobutton = driver.findElement(By.xpath(ProductPageObjects.mineableButton));
        mineableradiobutton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductPageObjects.allCryptocurrenciesButton)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductPageObjects.CoinsButton)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[6]/div[1]/div[1]/div[2]/div[1]/div[3]/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[6]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/input[1]")).sendKeys("100");
        driver.findElement(By.xpath("//div[contains(@class,'cmc-input-row')]//following-sibling::input[contains(@class,'cxm5lu-0 sc-1wbb12d-3 eCjdin')]")).sendKeys("10000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Apply Filter')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Show results')]")).click();
    }

    @Then("^Compare the page content with the content displayed in step three$")
    public void compareThePageCuntentWithTheContentDisplayedInStepThree() {

        //get all the search result in the frame
        List<WebElement> stepFiveResults=driver.findElements(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[5]/table"));
        //iterate the above list to get all the search titles & links from that page
        for (WebElement eachResult : stepFiveResults) {
            System.out.println("Selected Results for stepFiveResults : " + eachResult.getText() + ",");
            for (WebElement result : stepThreeResults) {
                System.out.println("Selected Results for stepThreeResults : " + result.getText() + ",");
                if (eachResult.getText().equalsIgnoreCase(result.getText())) {
                    System.out.println("Results are matching");
                } else {
                    System.out.println("Results are not matching");
                }
            }
        }

    }

    @Then("^Click on POW button$")
    public void clickOnPOWButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@class,'sc-1hxnufv-4 dEpvVp')]//descendant::button[contains(@class,'x0o17e-0 ewuQaX sc-36mytl-0 bBafzO table-control-filter')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'sc-1hxnufv-4 dEpvVp')]//descendant::button[contains(@class,'x0o17e-0 ewuQaX sc-36mytl-0 bBafzO table-control-filter')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class,'sc-1nwkt86-0 iNCnIe')]//descendant::button[text()='Algorithm']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("PoW");
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductPageObjects.powButton)).click();
        Thread.sleep(5000);
    }

    @Then("^Click on the add filter option$")
    public void clickOnTheAddFilterOption() {
        driver.findElement(By.xpath(ProductPageObjects.moreFilterButton)).click();

    }
}
