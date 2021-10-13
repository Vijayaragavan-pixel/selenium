package mavenSeleniumGA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Directory {
	WebDriver driver;
	
	public Directory(WebDriver driver) {
		this.driver = driver;
	}
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	@Test
public void Directory1 () throws InterruptedException {
	
	// Directory will execute
	driver.findElement(By.xpath("//b[contains(text(),'Directory')]")).click();
	driver.findElement(By.cssSelector("#searchDirectory_emp_name_empName")).sendKeys("Odis Adalwin");
	Thread.sleep(1000);
	Select userRole = new Select(driver.findElement(By.id("searchDirectory_job_title")));
	userRole.selectByVisibleText("Chief Technical Officer");
	try {
	Select userRole1 = new Select(driver.findElement(By.id("searchDirectory_location")));
	userRole1.selectByVisibleText("Canada");
	}catch(Exception e) {
		System.out.print("No Such Element");
	}
	driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
	}

}
