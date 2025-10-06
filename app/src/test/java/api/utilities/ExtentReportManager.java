package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // mỗi thread 1 ExtentTest
    private static final String REPORT_PATH = "test-output/ExtentReport_" + new SimpleDateFormat("yyyyMMdd_hh_mm_ss").format(new Date()) + ".html";

    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
        //Config Report
        sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
        sparkReporter.config().setReportName("Pet Store Users API");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "Pet Store Users API");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");;
        extent.setSystemInfo("user", "GRH");
    }

    public void onTestSuccess(ITestResult result) {
        createTest(result, Status.PASS);
    }

    public void onTestFailure(ITestResult result) {
        createTest(result, Status.FAIL);
    }

    public void onTestSkipped(ITestResult result) {
        createTest(result, Status.SKIP);
    }

    public void onFinish(ITestContext context) {
        flushReports();
    }

    public static void createTest(ITestResult result, Status statusResult) {
        ExtentTest extentTest = extent.createTest(result.getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.createNode(result.getName());

        switch (statusResult) {
            case PASS:
                extentTest.log(Status.PASS, "Test Passed");
                break;
            case FAIL:
                extentTest.log(Status.FAIL, "Test Failed");
                extentTest.log(Status.FAIL, result.getThrowable().getMessage());
                break;
            case SKIP:
                extentTest.log(Status.SKIP, "Test Skipped");
                extentTest.log(Status.SKIP, result.getThrowable().getMessage());
            default:
                break;
        }

        test.set(extentTest);
    }

    private static ExtentTest getTest() {
        return test.get();
    }

    public static void info(String msg) {
        getTest().info(msg);
    }

    public static void pass(String msg) {
        getTest().pass(msg);
    }

    public static void fail(String msg) {
        getTest().fail(msg);
    }

    public static void flushReports() {
        if(extent != null) {
            extent.flush();
        }
    }
}
