package mavenSeleniumGA;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Run {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void execution() throws Exception {
		
		
		

		LogInPage login = new LogInPage(driver);
		login.logIn();
		
	/*	driver.findElement(By.xpath("//input[@id='MP_link']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='installButton2']")).click();
		Thread.sleep(3000);
	*/	
		//WebElement s = driver.switchTo().activeElement();	
		//System.out.println(s);
		//s.findElement(By.className("btn")).click();
		
		/*AdminUserSearch admin = new AdminUserSearch(driver);
		admin.users();
		*/
/*		Leave leave = new Leave(driver);
		leave.leavemethod();
		Thread.sleep(3000);
		
		Myinfo m = new Myinfo(driver);
		m.Myinfo1();
		Thread.sleep(3000);
		
		Recruitment r = new Recruitment(driver);
		r.recruitment1();
		Thread.sleep(3000);
		
		Time t = new Time(driver);
		t.seleniumT();
		Thread.sleep(3000);
		
		Directory d = new Directory(driver);
		d.Directory1();
		Thread.sleep(3000);
*/
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
