package com.AdvanceSelenium;



import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShots extends RegistertestCase{
	
	public static String getInstance(String name) throws IOException{
		
		String path=System.getProperty("user.dir")+"/ScreenShot/"+name+".png";
		 TakesScreenshot tks=(TakesScreenshot)driver;
		 File sourceFile =tks.getScreenshotAs(OutputType.FILE); 
		 File targetFile =new File(path); 
		 FileHandler.copy(sourceFile,targetFile);
		 return path;
	}
   
}
