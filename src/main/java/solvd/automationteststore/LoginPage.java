package solvd.automationteststore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private final String URL = "https://automationteststore.com/index.php?rt=account/login";
    @FindBy(xpath = "//*[@id='loginFrm_loginname']")
    public WebElement loginNameInput;
    @FindBy(css = "[title='Continue']")
    private WebElement registrationContinueButton;
    @FindBy(css = "#loginFrm_password")
    private WebElement passwordInput;
    @FindBy(css = "[title='Login']")
    private WebElement loginButton;
    @FindBy(css = ".maintext")
    private WebElement accountText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage clickRegistrationContinueButton() {
        click(registrationContinueButton);
        return new CreateAccountPage(driver);
    }

    public void login(String name, String password) {
        sendKeys(loginNameInput, name);
        sendKeys(passwordInput, password);
        click(loginButton);
    }

    public boolean isPageOpen() {
        return driver.getCurrentUrl().equals(URL);
    }

    public boolean accountIsLogged() {
        return accountText.getText().equals("My Account");
    }
}