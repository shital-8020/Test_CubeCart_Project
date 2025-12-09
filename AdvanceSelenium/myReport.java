package com.AdvanceSelenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class myReport {
    
	  public static ExtentReports viewReport() {
		  //ExtentSparkReporter 
		  //ExtentReports
		  //ExtentTest
		  
		  ExtentSparkReporter spark= new ExtentSparkReporter("report/TestReport.html");
		  spark.config().setDocumentTitle("Automation Test report");
		  spark.config().setReportName("Regression testing");
		  spark.config().setTheme(Theme.DARK);
		  
		  ExtentReports reports= new ExtentReports();
		  reports.setSystemInfo("Enviroment","QA");
		  reports.setSystemInfo("Tester Name","shital");
		  reports.setSystemInfo("OS","Windows");
		  reports.setSystemInfo("Browser","chrome");
		  reports.attachReporter(spark);
		  return reports;
		  
	  }
}
