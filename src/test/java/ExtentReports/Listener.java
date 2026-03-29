package ExtentReports;

import com.aventstack.extentreports.*;
import org.testng.*;

public class Listener implements ITestListener {

    // Declare a static ExtentReports object (shared across all tests)
// This is the main reporting engine
    private static ExtentReports extent;

    // Declare a static ExtentTest object
// This represents an individual test in the report
    private static ExtentTest extentTest;

    // This method runs BEFORE each test starts
    @Override
    public void onTestStart(ITestResult result){

        // Create a new test entry in the report using the test method name
        // result.getMethod().getMethodName() gets the current test method name
        extentTest = extent.createTest(result.getMethod().getMethodName());
    }

    // This method runs when a test FAILS
    @Override
    public void onTestFailure(ITestResult result){

        // Log the failure status in the report
        // Adds a message showing which test failed
        extentTest.log(Status.FAIL,
                "Test Case " + result.getMethod().getMethodName() + " Has failed");
    }

    // This method runs when a test PASSES
    @Override
    public void onTestSuccess(ITestResult result){

        // Log the success status in the report
        // Adds a message showing which test passed
        extentTest.log(Status.PASS,
                "Test Case " + result.getMethod().getMethodName() + " Has Passed");
    }

    // This method runs when a test is SKIPPED
    @Override
    public void onTestSkipped(ITestResult result){

        // Log the skipped status in the report
        // Adds a message showing which test was skipped
        extentTest.log(Status.SKIP,
                "Test Case " + result.getMethod().getMethodName() + " Has been Skipped");
    }

    // This method runs AFTER all tests in the suite have finished
    @Override
    public void onFinish(ITestContext result){

        // Flush writes all the logged information into the report file
        // VERY IMPORTANT: without this, the report will be empty or incomplete
        extent.flush();
    }

    // This method runs BEFORE any test in the suite starts
    @Override
    public void onStart(ITestContext result){

        // Initialize the ExtentReports instance using your custom manager class
        // This sets up the report configuration (path, title, etc.)
        extent = ExtentReportManager.extentReports();
    }
}
