package Solvd;

import Solvd.automationPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchProductTest() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.searchForProduct("shirt");
        homePage.clickSearchButton();
        homePage.printTitles();
    }
}