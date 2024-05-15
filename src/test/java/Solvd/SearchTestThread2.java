package Solvd;

import Solvd.automationteststore.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SearchTestThread2 extends BaseTest{

    @Test(enabled = false)
    public void searchProductTest2() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.searchForProduct("eyes");
        homePage.clickSearchButton();
        homePage.printTitles();
    }
}