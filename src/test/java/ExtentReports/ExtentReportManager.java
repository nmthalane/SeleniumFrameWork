package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {

    // Define the path where the HTML report will be generated
// System.getProperty("user.dir") gets the current project directory
// "/Reports/sauceDemo.html" is appended to create the full report path
    private static final String reportDir = System.getProperty("user.dir") + "/Reports/ndosiAutomation.html";

    // Declare an ExtentReports object (main reporting engine)
    private static ExtentReports extentReports;

    // Declare an ExtentSparkReporter object (used to generate HTML reports)
    private static ExtentSparkReporter extentSparkReporter;

    // Method to initialize and configure Extent Reports
    public static ExtentReports extentReports(){

        // Create a new instance of ExtentReports
        extentReports = new ExtentReports();
//        String reportPath = System.getProperty("user.dir") + "/Reports/ndosiAutomation.html";
//
//        File reportFolder = new File(System.getProperty("user.dir") + "/Reports");
//        if (!reportFolder.exists()) {
//            reportFolder.mkdirs();
//        }
        // Create a new Spark Reporter and pass the report file location
        extentSparkReporter = new ExtentSparkReporter(new File(reportDir));

        // Attach the Spark Reporter to the ExtentReports instance
        extentReports.attachReporter(extentSparkReporter);

        // Set the title that appears in the browser tab of the report
        extentSparkReporter.config().setDocumentTitle("Extent Report");

        // Optional: Set the theme of the report (e.g., DARK or STANDARD)
         extentSparkReporter.config().setTheme(Theme.DARK);

        // Set the name/title displayed inside the report
        extentSparkReporter.config().setReportName("Ndosi Automation");

        // Add system/environment information to the report
        // This helps identify where the tests were executed
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));

        // Add the username of the machine running the tests
        extentReports.setSystemInfo("Execution Machine", System.getProperty("user.name"));

        // Return the configured ExtentReports object so it can be used in tests
        return extentReports;
    }
}
