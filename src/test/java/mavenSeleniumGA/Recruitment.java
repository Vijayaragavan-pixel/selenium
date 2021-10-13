package mavenSeleniumGA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Recruitment {
	WebDriver driver;
	
	public Recruitment(WebDriver driver) {
		this.driver = driver;
	}
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	@Test
public void recruitment1() throws InterruptedException {
		
	//recruitment will execute 
		
		driver.findElement(By.xpath("//b[contains(text(),'Recruitment')]")).click();
		
		try {
			Select vacancy = new Select(driver.findElement(By.id("candidateSearch_jobVacancy")));
			vacancy.selectByVisibleText("Associate IT Manager");	
			Thread.sleep(1000);		
		}catch(Exception e) {
			System.out.print("NoSuchException");
		}
		try {
		Select hringManager = new Select(driver.findElement(By.id("candidateSearch_hiringManager")));
		hringManager.selectByVisibleText("Linda Jane Anderson");
		Thread.sleep(1000);
		}catch(Exception e) {
			System.out.print("NoSuchException");
		}
		try {
		Select status = new Select(driver.findElement(By.id("candidateSearch_status")));
		status.selectByVisibleText("Shortlisted");
		Thread.sleep(1000);
	}catch(Exception e) {
		System.out.print("NoSuchException");
	}	
		driver.findElement(By.xpath("//input[@id='btnSrch']")).click();
		driver.findElement(By.linkText("Download")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Augustine')]")).click();
		
		Select action = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/form[1]/fieldset[1]/ol[2]/li[1]/div[1]/div[1]/select[1]")));
		action.selectByVisibleText("Schedule Interview");
		
		driver.findElement(By.xpath("//input[@id='jobInterview_name']")).sendKeys("Test Engineer");
		driver.findElement(By.cssSelector("#jobInterview_interviewer_1")).sendKeys("Ramesh");
		driver.findElement(By.linkText("Add Another")).click();
		WebElement e = driver.findElement(By.cssSelector("#jobInterview_interviewer_2"));
		e.clear();
		e.sendKeys("Kathir");
		
		WebElement date = driver.findElement(By.xpath("//input[@id='jobInterview_date']"));
		date.clear();
		date.sendKeys("2021-11-15");
		
		WebElement time = driver.findElement(By.xpath("//input[@id='jobInterview_time']"));
		time.clear();
		time.sendKeys("09:00");
		
		driver.findElement(By.xpath("//textarea[@id='jobInterview_note']")).sendKeys("Interview Call letter");
		driver.findElement(By.xpath("//input[@id='saveBtn']")).click();
	}
}
