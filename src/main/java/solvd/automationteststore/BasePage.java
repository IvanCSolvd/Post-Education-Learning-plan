package solvd.automationteststore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public abstract class BasePage {
    protected static Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String URL;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        this.logger = LogManager.getLogger(this.getClass());
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element) {
        try {
            waitForElementToBeClickable(element);
            element.click();
            logger.info("Clicked on " + element.getText());
        } catch (Exception e) {
            //logger.error("Failed to click on button " + e.getMessage());
        }
    }

    protected void sendKeys(WebElement element, String text) {
        try {
            element.sendKeys(text);
            logger.info("Entered text '" + text + "' into " + element.getText());
        } catch (Exception e) {
            //logger.error("Failed to enter text into " + element.getText() + ": " + e.getMessage());
        }
    }
}