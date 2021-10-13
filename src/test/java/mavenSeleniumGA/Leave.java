package mavenSeleniumGA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class Leave {
	
	WebDriver driver;
	
	
	
	@Test
	public void leavemethod() throws Exception {
		
	//leave will execute with 
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[3]/a[1]/b[1]")).click();
	Thread.sleep(2000);
	
	WebElement fromDate = driver.findElement(By.xpath("//input[@id='calFromDate']"));
	fromDate.clear();
	fromDate.sendKeys("2020-10-20");
	
	WebElement toDate = driver.findElement(By.xpath("//input[@id='calToDate']"));
	toDate.clear();
	toDate.sendKeys("2020-12-22");
	
	driver.findElement(By.xpath("//input[@id='leaveList_txtEmployee_empName']")).sendKeys("Rebecca Harmony");
	
	driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
	
	Select action = new Select(driver.findElement(By.id("select_leave_action_23")));
	action.selectByVisibleText("Approve");
	
	driver.findElement(By.id("btnSave")).click();
	
}
	
}
