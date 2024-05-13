package Solvd.automationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "#filter_keyword")
    private WebElement searchInput;

    @FindBy(css = ".button-in-search")
    private WebElement searchButton;

    @FindBy(css = ".prdocutname")
    private List<WebElement> searchResults;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://automationteststore.com/");
    }

    public void searchForProduct(String productName) {
        sendKeys(searchInput, productName, "Search Bar");
    }

    public void clickSearchButton() {
        click(searchButton, "Search Button");
    }

    public void printTitles() {
        logger.info("The results of the search are:");
        for (WebElement result : searchResults) {
            System.out.println(result.getText());
        }
    }
}