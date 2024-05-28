package solvd.automationteststore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
    private static String URL = "https://automationteststore.com/index.php?rt=account/create";

    @FindBy(css = "#AccountFrm_agree")
    private WebElement policyButton;

    @FindBy(css = ".btn-orange")
    private WebElement continueButton;

    @FindBy(css = ".alert-error")
    private WebElement alertErrorText;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAlertErrorDisplayed() {
        waitForVisibilityOfElement(alertErrorText);
        return alertErrorText.isDisplayed();
    }

    public void acceptPolicy() {
        click(policyButton);
    }

    public void verifyRegistration() {
        click(continueButton);
    }
}