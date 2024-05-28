package solvd.automationteststore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(xpath = "//div[@class='contentpanel']")
    private WebElement cartIsEmptyText;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartIsEmpty() {
        return cartIsEmptyText.getText().equals("Your shopping cart is empty!");
    }
}