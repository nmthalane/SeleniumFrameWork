package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyLearningPage;
import Utils.BrowserFactory;
import Utils.TakeScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected MyLearningPage myLearningPage;
    protected TakeScreenshots takeScreenshots;

    BrowserFactory browserFactory = new BrowserFactory();

    @BeforeClass
    public void setUp() {

        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

        driver = browserFactory.startBrowser("chrome","https://ndosisimplifiedautomation.vercel.app/",headless);

        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        myLearningPage = PageFactory.initElements(driver, MyLearningPage.class);
        takeScreenshots = new TakeScreenshots();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}