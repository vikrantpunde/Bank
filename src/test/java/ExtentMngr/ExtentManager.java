package ExtentMngr;

import java.io.File;

import org.openqa.selenium.Platform;

import com.relevantcodes.extentreports.ExtentReports;



public class ExtentManager {
	  private static ExtentReports extent;
	  
	    public synchronized static ExtentReports getReporter(){
	        if(extent == null){
	            //Set HTML reporting file location
	            String workingDir = System.getProperty("user.dir");
	            extent = new ExtentReports(workingDir+"\\test-output\\ExtentReportResults.html", true);
	        }
	        return extent;
	    }
	}

