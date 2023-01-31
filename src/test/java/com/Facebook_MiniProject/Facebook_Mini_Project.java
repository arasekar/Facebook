package com.Facebook_MiniProject;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Facebook_Mini_Project 

{

	public static void main(String[] args) throws Throwable{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aravi\\eclipse-workspace\\java\\Selenium_Concepts\\Drive\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		String url="https://www.facebook.com/";
		
		String check="facebook";
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		String PageTitle = driver.getTitle();
		
		System.out.println("Page title is: "+PageTitle);
		
		if(url.contains(check)) {
			
			System.out.println("User launched correct web application");
		}
		else {
			driver.quit();
		}
		
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("aravind@gmail.com");
		
		driver.findElement(By.id("pass")).sendKeys("1234");
		
		driver.findElement(By.name("login")).click();
		
		TakesScreenshot shot=(TakesScreenshot)driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\aravi\\eclipse-workspace\\java\\Selenium_Mini_Project\\Screenshot\\screen.png");
		FileHandler.copy(src, dest);
		
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
		
		TakesScreenshot shot1=(TakesScreenshot)driver;
		File src1 = shot1.getScreenshotAs(OutputType.FILE);
		File dest1=new File("C:\\Users\\aravi\\eclipse-workspace\\java\\Selenium_Mini_Project\\Screenshot\\signin.png");
		FileHandler.copy(src1, dest1);
		
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
		driver.close();
	}
}
