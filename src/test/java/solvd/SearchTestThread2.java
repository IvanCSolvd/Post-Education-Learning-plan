package solvd;

import solvd.automationteststore.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTestThread2 extends BaseTest{
    protected static Logger logger = LogManager.getLogger(SearchTestThread2.class);


    @Test()
    public void searchProductTest2() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        logger.info(" automation exercise page is opened");
        Assert.assertTrue(homePage.isPageOpen(), "Page is not opened correctly in the HomePage.");
        String logoText = homePage.getLogoText();
        Assert.assertEquals(logoText, "Automation Test Store", "Logo text is not the same");
        homePage.searchForProduct("eyes");
        homePage.clickSearchButton();
        homePage.printTitles();
    }
}