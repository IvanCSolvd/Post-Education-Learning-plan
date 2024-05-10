package Solvd.automationPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    @FindBy(css = "#filter_keyword")
    private WebElement searchInput;

    @FindBy(css = ".button-in-search")
    private WebElement searchButton;

    @FindBy(css = ".prdocutname")
    private List<WebElement> searchResults;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://automationteststore.com/");
    }

    public void searchForProduct(String productName) {
        searchInput.sendKeys(productName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void printTitles() {
        for (WebElement result : searchResults) {
            System.out.println(result.getText());
        }
    }
}