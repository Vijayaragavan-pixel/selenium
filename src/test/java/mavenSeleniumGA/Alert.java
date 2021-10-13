package mavenSeleniumGA;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
WebDriver driver;

	@BeforeTest
	
	public void setup() throws Exception{

	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test	
	public void meth() throws InterruptedException {
	
	/*driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	Thread.sleep(3000);
	
	driver.manage().window().maximize();
	
	driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
	Thread.sleep(1000);
	
	driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/form[1]/div[5]/input[1]")).click();
	Thread.sleep(2000);

	driver.findElement(By.id("MP_link")).click();
		
	driver.findElement(By.xpath("//input[@id='installButton2']")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("modal_confirm_install ")).click();
	*/
		driver.get("https://ksrtc.in/oprs-web/ticket/waitlist.do");
		Thread.sleep(3000);
		
		driver.findElement(By.id("searchBtn")).click();
		
		 org.openqa.selenium.Alert alert = driver.switchTo().alert();		
 		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        Thread.sleep(2000);
	        		
	        // Accepting alert		
	        alert.accept();		
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]/img[1]")).click();
	        
	        String MainWindow=driver.getWindowHandle();		
 			
	        // To handle all new opened window.				
	            Set<String> s1=driver.getWindowHandles();		
	            Iterator<String> i1=s1.iterator();		
	        		
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                    Thread.sleep(3000);
	                    // Switching to Child window
	                  driver.switchTo().window(ChildWindow);	                                                                                                           
	                  
	                    driver.findElement(By.name("btnLogin")).click();			
	                                 
	       		// Closing the Child Window.
	                        driver.close();		
	            }		
	        }		
	        // Switching to Parent window i.e Main Window.
	            driver.switchTo().window(MainWindow);				
	            Thread.sleep(3000);
	        
	        driver.quit();
	}

}
