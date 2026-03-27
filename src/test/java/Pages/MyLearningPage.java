package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MyLearningPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"practice-section\"]/div[3]/div/div[2]/div[1]/h4")
    WebElement practiceSection_xpath;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]")
    WebElement learningMaterial_dropDown_xpath;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")
    WebElement learningMaterial_option_xpath;


    public MyLearningPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLearningMaterials() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(learningMaterial_dropDown_xpath));
        learningMaterial_dropDown_xpath.click();
        learningMaterial_option_xpath.click();
    }

    public void verifyTestingPracticeIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(practiceSection_xpath));
        practiceSection_xpath.isDisplayed();
    }
}
