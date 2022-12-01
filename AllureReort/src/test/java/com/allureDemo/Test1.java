package com.allureDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {

	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver_win32 (1)/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test(priority=1)
	public void logo()
	{
		boolean disstatus = driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
		Assert.assertEquals(disstatus,true);
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("amitpanika97@gmail.co");
		driver.findElement(By.id("password")).sendKeys("Amit@123");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).clear();
		
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
	}
	
	@Test(priority=3)
	public void registrationTest()
	{
		throw new SkipException("Skipping");
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
	
}
