@CoinMarket
Feature: Ensure user register to Coin Market and select the Filter

  As a customer
  I want to Launch the Coin Market site in the web browser
  So I can Filter UI and extract data for comparison

  @CoinMarket
  Scenario: To Filter UI and extract data for comparison
    Given Launch the CoinMarket web site
    When verify CoinMarket website loaded successfully
    Then Select the Show rows dropdown to display twenty rows
    And Capture all the page contents for Name Price and position
    Then Click on POW button
    Then Click on the add filter option
    And then select Mienable and click on all crypto currencies and select coins and click on show results button
    Then Compare the page content with the content displayed in step three



