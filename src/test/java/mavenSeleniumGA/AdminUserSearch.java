package mavenSeleniumGA;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class AdminUserSearch {

	WebDriver driver;
	
	public AdminUserSearch(WebDriver driver) {
		this.driver = driver;
	}
	

	@Test
	public void users() throws Exception {
		
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/b[1]")).click();
		
		driver.findElement(By.id("btnAdd")).click();
		
		Select userRole = new Select(driver.findElement(By.id("systemUser_userType")));
		userRole.selectByVisibleText("Admin");
		
		driver.findElement(By.name("systemUser[employeeName][empName]")).sendKeys("Alice Duval");
		
		driver.findElement(By.name("systemUser[userName]")).sendKeys("Odis007");
		
		Select status = new Select(driver.findElement(By.name("systemUser[status]")));
		status.selectByVisibleText("Enabled");
		try {
		driver.findElement(By.name("systemUser[password]")).sendKeys("Odis@001");
		
		driver.findElement(By.name("systemUser[confirmPassword]")).sendKeys("Odis@001");
		
		driver.findElement(By.name("btnSave")).click();	
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/form[1]/fieldset[1]/ol[1]/li[1]/input[1]")).sendKeys("Odis007");
		
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		
		WebElement checkBox = driver.findElement(By.cssSelector("#ohrmList_chkSelectRecord_10"));
		checkBox.click();
		driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
		}catch(Exception e){
			System.out.print("No such Element");
		}
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
