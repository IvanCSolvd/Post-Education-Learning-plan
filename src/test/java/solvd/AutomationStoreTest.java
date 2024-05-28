package solvd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.automationteststore.CartPage;
import solvd.automationteststore.CreateAccountPage;
import solvd.automationteststore.HomePage;
import solvd.automationteststore.LoginPage;

public class AutomationStoreTest extends BaseTest {
    protected static Logger logger = LogManager.getLogger(AutomationStoreTest.class);

    @Test(enabled = false)
    public void failedRegistration() throws InterruptedException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        LoginPage loginPage = homePage.clickRegisterButton();
        Assert.assertTrue(loginPage.isPageOpen());
        CreateAccountPage createAccountPage = loginPage.clickRegistrationContinueButton();
        createAccountPage.acceptPolicy();
        createAccountPage.verifyRegistration();
        Assert.assertTrue(createAccountPage.isAlertErrorDisplayed());
    }

    @Test
    public void login() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        LoginPage loginPage = homePage.clickRegisterButton();
        Assert.assertTrue(loginPage.isPageOpen());
        loginPage.login("Testeandoando", "Test123");
        Assert.assertTrue(loginPage.accountIsLogged());
    }

    @Test
    public void searchProductTest() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        logger.info(" automation exercise page is opened");
        Assert.assertTrue(homePage.isPageOpen(), "Page is not opened correctly in the HomePage.");
        String logoText = homePage.getLogoText();
        Assert.assertEquals(logoText, "Automation Test Store", "Logo text is not the same");
        homePage.searchForProduct("shirt");
        homePage.clickSearchButton();
        homePage.printTitles();
    }

    @Test
    public void checkEmptyCart() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        CartPage cartPage = homePage.clickCartButton();
        Assert.assertTrue(cartPage.isCartIsEmpty());
    }
}