package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyLearningPage;
import Utils.BrowserFactory;
import Utils.TakeScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = browserFactory.startBrowser("chrome","https://ndosisimplifiedautomation.vercel.app/");

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    MyLearningPage myLearningPage = PageFactory.initElements(driver, MyLearningPage.class);
    TakeScreenshots takeScreenshots = new TakeScreenshots();
}
