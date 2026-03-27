package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    static WebDriver driver;


    public static WebDriver startBrowser(String browserChoice, String url, boolean headless) {

        if (browserChoice.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();

            if (headless) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }

            driver = new ChromeDriver(options);

        } else if (browserChoice.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();

            if (headless) {
                options.addArguments("--headless");
            }

            driver = new FirefoxDriver(options);

        } else if (browserChoice.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();

            if (headless) {
                options.addArguments("--headless=new");
            }

            driver = new EdgeDriver(options);

        } else if (browserChoice.equalsIgnoreCase("safari")) {
            driver = new SafariDriver(); // ❌ Safari doesn't support headless

        } else {
            driver = new InternetExplorerDriver(); // ⚠️ Avoid in CI
        }

        if (!headless) {
            driver.manage().window().maximize();
        }

        driver.get(url);
        return driver;
    }

//    @Test
//    public void lauchBroswer(){
//        startBrowser("EdGe","https://ndosisimplifiedautomation.vercel.app/");
//    }
}
