package Tests;

import Utils.ReadFromFile;
import org.testng.annotations.*;

@Test
public class NdosiTests extends Base {

    public void verifyHomePageIsDisplayed() {
        homePage.verifyHomePageIsDisplayed();
        //takeScreenshots.takeSnapShots(driver, "HomePageScreenshot001");
    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayed")
    public void clickLoginButton() {
        homePage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginButton")
    public void userEnterEmail() {
        loginPage.enterEmail(ReadFromFile.email);
    }

    @Test(dependsOnMethods = "userEnterEmail")
    public void userEnterPassword() {
        loginPage.enterPassword(ReadFromFile.password);
    }

    @Test(dependsOnMethods = "userEnterPassword")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "userClicksLoginButton")
    public void loginPageIsDisplayed() throws InterruptedException {
        loginPage.verifyLoginPageIsDisplayed();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "loginPageIsDisplayed")
    public void clickLearningMaterials() {
        myLearningPage.clickLearningMaterials();
    }

    @Test(dependsOnMethods = "clickLearningMaterials")
    public void verifyPracticeSectionIsDisplayed() throws InterruptedException {
        myLearningPage.verifyTestingPracticeIsDisplayed();
    }

}
