package mavenSeleniumGA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myinfo {
	WebDriver driver;
	
	public Myinfo(WebDriver driver) {
		this.driver = driver;
	}
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	@Test
public void Myinfo1() throws InterruptedException {
	
	//Myinfo will execute
	
	driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
	driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	driver.findElement(By.cssSelector("#personal_txtEmpMiddleName")).sendKeys("san");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("#personal_txtLicenNo")).sendKeys("L435675PT");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("#personal_txtNICNo")).sendKeys("345677234sda");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("#personal_txtOtherID")).sendKeys("er3456");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("#personal_txtEmpNickName")).sendKeys("sandy");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	
	
	
	
}
}
