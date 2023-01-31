package com.Facebook_MiniProject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_TestNG {
	WebDriver driver=null;
	String url="https://www.facebook.com/";
	String check="facebook";
	String PageTitle=null;

@BeforeSuite	
private void browserLaunch() 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(options);
	}

@BeforeClass	
private void urlLaunch() 
	{
		driver.get(url);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

@Test (priority = -1)
private void checkPageTitle() 
	{
		PageTitle = driver.getTitle();
		System.out.println("Page title is: "+PageTitle);
		if(url.contains(check)) {
		System.out.println("User launched correct web application");
	    }
	    else {
		driver.quit();
	    }
	}

@Test(priority = 0)
private void inputUserNamePassword() 
	{
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("aravind@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("1234");
	}

@Test(priority = 1)
private void login() 
	{
		driver.findElement(By.name("login")).click();
	}

@Test(priority = 2)
private void screenShot() throws IOException 
	{
		TakesScreenshot shot=(TakesScreenshot)driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\aravi\\eclipse-workspace\\java\\Selenium_Mini_Project\\Screenshot\\screen.png");
		FileHandler.copy(src, dest);
	}

@Test (priority = 3)
private void registration() throws InterruptedException 
	{
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("firstname")).sendKeys("Aravind");
		driver.findElement(By.name("lastname")).sendKeys("Sekar");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Aravind@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("54321");
		WebElement day = driver.findElement(By.id("day"));
		Select DOB = new Select(day);
		DOB.selectByValue("4");
		WebElement mnth = driver.findElement(By.id("month"));
		Select DOB1=new Select(mnth);
		DOB1.selectByVisibleText("Aug");
		WebElement yr = driver.findElement(By.id("year"));
		Select DOB2 = new Select(yr);
		DOB2.selectByValue("1991");
		driver.findElement(By.xpath("(//input[@type=\"radio\"])[2]")).click();
		driver.findElement(By.name("websubmit")).click();
	}

@Test (priority = 4)
private void screenShot1() throws IOException 
	{
		TakesScreenshot shot1=(TakesScreenshot)driver;
		File src1 = shot1.getScreenshotAs(OutputType.FILE);
		File dest1=new File("C:\\Users\\aravi\\eclipse-workspace\\java\\Selenium_Mini_Project\\Screenshot\\signin.png");
		FileHandler.copy(src1, dest1);
	}

@Test(priority = 5)
private void compareWebPage() throws InterruptedException 
	{
		driver.findElement(By.xpath("//img[@class='_8idr img']")).click();
		String PageTitle1 = driver.getTitle();
		System.out.println("Current page title is: "+PageTitle1);
		if(PageTitle.equals(PageTitle1)) {
		System.out.println("Current page and user initial browser launch page are same");
		}
		else {
		driver.quit();
		}
		Thread.sleep(3000);
	}

@AfterClass
private void browserClose() 
	{
	driver.close();
	}
}
