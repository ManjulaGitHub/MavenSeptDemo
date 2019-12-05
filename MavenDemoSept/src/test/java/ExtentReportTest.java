import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReportTest {
	static ExtentReports reports;
	static ExtentTest logger;
	
	@Test
	public void testApp(){
	
	String fileName = new SimpleDateFormat("'SampleDemo_'yyyyMMddHHmm'.html'").format(new Date(0));
	String path = "C:\\ExtentReport\\"+fileName;
	reports = new ExtentReports(path);
	logger = reports.startTest("Login into Gmail");                                                          
	logger.log(LogStatus.INFO,"Enter valid email id");
	logger.log(LogStatus.PASS, "Enter email id");
	logger.log(LogStatus.INFO, "We have Entered valid password");
	logger.log(LogStatus.PASS, "Enter password");
	logger.log(LogStatus.PASS, "Click on Login");
	
	logger = reports.startTest("Remember Me");
	logger.log(LogStatus.INFO,"We have Entered valid email id");
	logger.log(LogStatus.PASS, "Enter email id");
	logger.log(LogStatus.INFO, "We have Entered valid password");
	logger.log(LogStatus.PASS, "Enter password");
	logger.log(LogStatus.FAIL, "Click on Remember Me");
	logger.log(LogStatus.FAIL, "Click on Login");
	
	reports.endTest(logger);
	reports.flush();
	}

}
