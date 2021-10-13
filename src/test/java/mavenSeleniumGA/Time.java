package mavenSeleniumGA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Time {
	
	WebDriver driver;
	public Time(WebDriver driver) {
		this.driver = driver;
	}
	@BeforeTest
	public void setup () {
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    	
    }
	@Test
    public void seleniumT() throws InterruptedException {
   
      
//Time will execute
    	
  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[4]/a[1]/b[1]")).click();
  
  WebElement name = driver.findElement(By.className("ac_input"));
  name.clear();
  name.sendKeys("Cecil Bonaparte");
  
  driver.findElement(By.xpath("//input[@id='btnView']")).click();

}

}
