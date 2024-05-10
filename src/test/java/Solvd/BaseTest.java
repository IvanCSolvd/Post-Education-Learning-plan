package Solvd;

import Solvd.amazonPages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    public void searchProductTest() {
        homePage.open();
        homePage.searchForProduct("shirt");
        homePage.clickSearchButton();
        homePage.printTitles();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}