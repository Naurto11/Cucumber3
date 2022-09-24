package org.run;

import org.base.BaseClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.step.JVM;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources",glue="org.step",monochrome=true,plugin= {"io.qameta.allure.cucumberjvm.AllureCucumberJvm"})
	//	"pretty","html:target\\Reports.html","junit:target\\Reports\\fb.xml","json:target\\Reports\\output.json"})

public class Runner  {
	
	
	@AfterClass
	public static void jvmReportGenerate() {

		
		JVM.genarateJvmReport(System.getProperty("user.dir")+ "\\target\\Reports\\output.json");
	
		System.out.println("done");
	
	}                 
	

	
//	@AfterClass
//	public static void gener`ateReport() {
//		//blank html
//		ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");
//		
//		//report
//		ExtentReports extent=new ExtentReports();
//		
//		extent.attachReporter(reporter);
//		
//		ExtentTest Test = extent.createTest("tc001-search");
//		
//		Test.pass("enter the userid");
//		Test.pass("enter the password");
//		Test.pass("click btn");
//		//last
//		extent.flush();
//
//}
}