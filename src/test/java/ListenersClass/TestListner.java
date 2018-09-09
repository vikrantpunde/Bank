package ListenersClass;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import DriverInstance.BaseClass;
import ExtentMngr.ExtentManager;
import ExtentMngr.ExtentTestManager;

public class TestListner extends BaseClass implements ITestListener {
	 WebDriver webDriver;
	 private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }
	    
	    //Before starting all tests, below method runs.
	    @Override
	    public void onStart(ITestContext iTestContext) {
	        System.out.println("I am in onStart method " + iTestContext.getName());
	        iTestContext.setAttribute("WebDriver", this.driver);
	    }
	 
	    //After ending all tests, below method runs.
	    @Override
	    public void onFinish(ITestContext iTestContext) {
	        System.out.println("I am in onFinish method " + iTestContext.getName());
	        //Do tier down operations for extentreports reporting!
	        ExtentTestManager.endTest();
	        ExtentManager.getReporter().flush();
	    }
	 
	    @Override
	    public void onTestStart(ITestResult iTestResult) {
	        System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
	        //Start operation for extentreports.
	        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
	    }
	 
	    @Override
	    public void onTestSuccess(ITestResult iTestResult) {
	        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
	        //Extentreports log operation for passed tests.
	        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
	    }
	 
	    @Override
	    public void onTestFailure(ITestResult iTestResult) {
	        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
	 
	        //Get driver from BaseTest and assign to local webdriver variable.
	        Object testClass = iTestResult.getInstance();
	         this.webDriver = BaseClass.driver;
	         
	 
	        //Take base64Screenshot screenshot.
	        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
	                getScreenshotAs(OutputType.BASE64);
	 
	        //Extentreports log and screenshot operations for failed tests.
	        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed"+ iTestResult.getThrowable().getMessage(),
	        ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	    }
	 
	    @Override
	    public void onTestSkipped(ITestResult iTestResult) {
	        System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
	        //Extentreports log operation for skipped tests.
	        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
	    }
	 
	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	    }

}
