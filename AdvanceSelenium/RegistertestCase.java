package com.AdvanceSelenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testNG.practice.ReadExcel;

public class RegistertestCase {

	static WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver= new ChromeDriver();
		driver.get("https://javabykiran.in/other/CC/register");
	}
	@AfterMethod
	void close() {
		driver.quit();
	}
	@Test(dataProvider="registerTestData")
	void registerTestData(String title, String fname,String lname,String email, String phone ,String mobile,String password,String confrimpassword,String isvalid) throws InterruptedException {
		driver.findElement(By.id("title")).sendKeys(title);
		driver.findElement(By.id("first_name")).sendKeys(fname);
		driver.findElement(By.id("last_name")).sendKeys(lname);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("phone")).sendKeys(phone);
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("passconf")).sendKeys(confrimpassword);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("register_submit")).click();
        
		if(isvalid.equals("1")) {
			Thread.sleep(3000);
			String actualURL =driver.getCurrentUrl();
			Assert.assertEquals(actualURL,"https://javabykiran.in/other/CC/index.php?_a=account");	
		}else if(isvalid.equals("2")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='email-error']")).getText(),"Please enter a valid email address.");	

		}else if(isvalid.equals("3")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='last_name-error']")).getText(),"Please enter your last name.");	

		}
		else if(isvalid.equals("4")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='passconf-error']")).getText(),"Your passwords do not match.");	

		}
		else if(isvalid.equals("5")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='first_name-error']")).getText(),"Please enter your first name.");	

		}
		else if(isvalid.equals("6")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"password-error\"]")).getText(),"Please enter at least 6 characters for your password.");	

		}
		

		

	}
	 
	@DataProvider(name="registerTestData")
	String [][] testData() throws IOException{
		return ReadExcel.readExcelData();
		
	}
}
