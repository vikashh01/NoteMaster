package AllCover;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NoteMaster {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Give url
		driver.get("https://notes-makers.vercel.app/pages/login");
		
		//Using implicitlyWait for find and wait all the element for 10 seconds
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	// Use priority for run first of this script
	@Test(priority = 0)
	public void signUp() {
		// Click on signup btn using webElement for understanding 
		WebElement clickSignUp = driver.findElement(By.xpath("(//*[@class=\'flex items-center justify-center\'])[2]"));
		clickSignUp.click();
		
		// Enter the name in the input 
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("vikash");
		
		// Enter the Email in the input
		WebElement Email = driver.findElement(By.id("email"));
		Email.sendKeys("vikash123@gmail.com");
		
		// Enter the password in the password input
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("vikash123");
		
		// Enter the Confirm Password in the confirm password input
		WebElement ConfirmPassword = driver.findElement(By.id("confirmPassword"));
		ConfirmPassword.sendKeys("vikash123");
		
		WebElement signupBtn = driver.findElement(By.xpath("(//*[@class='flex items-center justify-center'])[3]"));
		signupBtn.click();
	}
	@Test(priority = 1)
	public void logIn() throws InterruptedException {
		
		// Click on login button
		WebElement loginurl = driver.findElement(By.cssSelector("[class='text-primary-950 font-semibold']"));
		loginurl.click();
		
		// using wait for 7 seconds
		Thread.sleep(7000);
		
		// Enter the Email in the input
		WebElement emailInput = driver.findElement(By.id("email"));
		emailInput.sendKeys("vikash123@gmail.com");
		
		// Enter the password
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("vikash123");
		
		// Click on login
		WebElement loginbtn = driver.findElement(By.xpath("(//*[@class=\'flex items-center justify-center\'])[3]"));
		loginbtn.click();
	}
	@Test(priority = 2)
	public void WriteNotes() throws InterruptedException {
		
		Thread.sleep(6000);
		// Click on Write Notes button
		WebElement writeNotes = driver.findElement(By.xpath("(//*[@class='flex items-center justify-center'])[1]"));
		writeNotes.click();
		
		// Write the title of the note
		WebElement noteTitle = driver.findElement(By.cssSelector("[placeholder=\'Notes Title\']"));
		noteTitle.sendKeys("This is the Demo");
		
		// Write somthing in the document part
		WebElement paragraph = driver.findElement(By.cssSelector("[class='ql-editor ql-blank']"));
		paragraph.sendKeys("Hey There!");
		
		//Wait for 4 seconds
		Thread.sleep(4000);
		
		// for the scroll using javascript Excuter
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500);");
		
		Thread.sleep(4000);
		WebElement save = driver.findElement(By.xpath("(//*[@class='flex items-center justify-center'])[2]"));
		save.click();
		
		// Navigate Back for see the result is showing inside man display
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().back();
		
		
		
	}
	
	@Test(priority = 3)
	public void profile() throws InterruptedException {
		
		Thread.sleep(3000);
		
		// Click on profile for  choose different options
		WebElement ClickProfile = driver.findElement(By.cssSelector("[class='flex items-center space-x-2 z-20 relative bg-primary-50 rounded-md p-2']"));
		ClickProfile.click();
		
		// Wait for 3 seconds
		Thread.sleep(3000);
		
		// Click on todo option
		WebElement Todo = driver.findElement(By.xpath("(//*[@class='p-2 transition-transform duration-300 ease-in-out hover:bg-primary-600 hover:text-primary-100 cursor-pointer'])[2]"));
		Todo.click();
		
		
		
	}
	
	@Test(priority = 4)
	public void Logout() throws InterruptedException {
		
		Thread.sleep(2000);
		
		// Clicking on Lgout
		WebElement logout = driver.findElement(By.xpath("(//*[@class=\"p-2 transition-transform duration-300 ease-in-out hover:bg-primary-600 hover:text-primary-100 cursor-pointer\"])[6]"));
		logout.click();
	}


	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		
	}

}