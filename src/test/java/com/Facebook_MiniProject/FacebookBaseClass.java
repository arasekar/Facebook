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

public class FacebookBaseClass extends BaseClass

{

	public static void main(String[] args) throws Throwable{
		
		browserLaunch("chrome");
		
		String url="https://www.facebook.com/";
		
		String check="facebook";
		
		launchUrl("https://www.facebook.com/");
		
		maximize();
		
		String PageTitle = getTitle();
		
		System.out.println("Page title is: "+PageTitle);
		
		if(url.contains(check)) {
			
			System.out.println("User launched correct web application");
		}
		else {
			quit();
			
		}
		
		WebElement userName = driver.findElement(By.id("email"));
		userInput(userName, "aravind@gmail.com");
		
		WebElement password = driver.findElement(By.id("pass"));
		userInput(password, "1234");
		
		WebElement login = driver.findElement(By.name("login"));
		cickOnElement(login);
		
		capture(driver);
		
		navigateBack();
		
		WebElement regi = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		cickOnElement(regi);
		
		sleep();
		
		WebElement fName = driver.findElement(By.name("firstname"));
		userInput(fName, "Aravind");
		
		WebElement lName = driver.findElement(By.name("lastname"));
		userInput(lName, "Sekar");
		
		WebElement mail = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		userInput(mail, "Aravind.sk@live.com");
		
		WebElement pass = driver.findElement(By.id("password_step_input"));
		userInput(pass, "56789");
		
		WebElement day = driver.findElement(By.id("day"));
		dropDownValue(day, "4");
		
		WebElement mnth = driver.findElement(By.id("month"));
		dropDownText(mnth, "Aug");
		
		WebElement yr = driver.findElement(By.id("year"));
		dropDownValue(yr, "1991");
		
		WebElement gender = driver.findElement(By.xpath("(//input[@type=\"radio\"])[2]"));
		cickOnElement(gender);
		
		WebElement submit = driver.findElement(By.name("websubmit"));
		submit.click();
		cickOnElement(submit);
		
		capture(driver);
		
		WebElement home = driver.findElement(By.xpath("//img[@class='_8idr img']"));
		cickOnElement(home);
		
		String PageTitle1 = getTitle();
		System.out.println("Current page title is: "+PageTitle1);
		
		if(PageTitle.equals(PageTitle1)) {
			System.out.println("Current page and user initial browser launch page are same");
		}
		else {
			quit();
		}
		sleep();
		close();
	}
}

