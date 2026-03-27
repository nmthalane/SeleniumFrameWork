package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage {

    WebDriver driver;
    //Verify that the home page is displayed
    @FindBy(id = "overview-section")
    WebElement verify_homePage;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")
    WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(loginButton));
        loginButton.click();
    }

    public void verifyHomePageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(verify_homePage));
        verify_homePage.isDisplayed();
    }

}
