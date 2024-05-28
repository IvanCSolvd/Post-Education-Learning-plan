package solvd.automationteststore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    private final String URL = "https://automationteststore.com/";
    private WebDriver driver;
    @FindBy(css = "#filter_keyword")
    private WebElement searchInput;

    @FindBy(css = ".button-in-search")
    private WebElement searchButton;

    @FindBy(css = ".prdocutname")
    private List<WebElement> searchResults;

    @FindBy(css = ".header-logo img")
    private WebElement logo;

    @FindBy(xpath = "/html/body/div/header/div[1]/div/div[2]/div/div[2]/div/ul/li/a")
    private WebElement loginAndRegistrationButton;

    @FindBy(css = "li[data-id=menu_cart]")
    private WebElement cartButton;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    public void searchForProduct(String productName) {
        sendKeys(searchInput, productName);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public CartPage clickCartButton() {
        click(cartButton);
        return new CartPage(driver);
    }

    public LoginPage clickRegisterButton() {
        click(loginAndRegistrationButton);
        return new LoginPage(driver);
    }

    public void printTitles() {
        logger.info("The results of the search are:");
        for (WebElement result : searchResults) {
            System.out.println(result.getText());
        }
    }

    public String getLogoText() {
        return logo.getAccessibleName();
    }

    public boolean isPageOpen() {
        return driver.getCurrentUrl().equals(URL);
    }
}