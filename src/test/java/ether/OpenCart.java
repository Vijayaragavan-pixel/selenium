package ether;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
	//Check if parameter passed from TestNG is 'firefox'
	if(browser.equalsIgnoreCase("firefox")){
	//create firefox instance
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	}
	 
	//Check if parameter passed as 'chrome'
	else if (browser.equalsIgnoreCase("chrome")){
	//set path to chromedriver.exe
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	 
	}

	else{
	//If no browser passed throw exception
	throw new Exception("Browser is not correct");
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	 

	@Test(priority = 0)
	public void enter_invalid() throws InterruptedException {
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().window().maximize();
		WebElement user = driver.findElement(By.name("username"));
		user.clear();
		user.sendKeys("demo");
		Thread.sleep(2000);
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys("demo");
		Thread.sleep(2000);

		WebElement loginBt = driver.findElement(By.xpath(
				"//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/button[1]"));
		loginBt.click();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void view_the_total_orders() throws InterruptedException {
		driver.findElement(
				By.xpath("//body/div[@id='container']/div[@id='content']/div[2]/div[1]/div[1]/div[1]/div[3]/a[1]"))
				.click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void filter_and_view_the_order() throws InterruptedException {
		driver.findElement(By.className("form-control")).sendKeys("13831");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='button-filter']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//thead/tr[1]/td[1]/input[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody/tr[1]/td[8]/div[1]/div[1]/a[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void click_on_print_Invoice_and_dispatch_note() throws IOException, InterruptedException {

		driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[1]/a[1]/i[1]"))
				.click();
		
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
	                    File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	            		File DesFile = new File("C:\\Users\\vijayaraghavanj\\Desktop\\ScreenShots\\Output1.png");

	            		FileUtils.copyFile(SrcFile, DesFile);		
	                                 
				// Closing the Child Window.
	                        driver.close();		
	            }		
	        }		
	        // Switching to Parent window i.e Main Window.
	            driver.switchTo().window(MainWindow);				
	   
//		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//		File DesFile = new File("C:\\Users\\vijayaraghavanj\\Desktop\\ScreenShots\\Output1.png");
//
//		FileUtils.copyFile(SrcFile, DesFile);

		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void user_providing_category_details() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.partialLinkText("Catal")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Categories')]")).click();
		driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[1]/a[1]"))
				.click();

		driver.findElement(By.id("input-name1")).sendKeys("IOS");
		driver.findElement(By.xpath(
				"//body/div[@id='container']/div[@id='content']/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]"))
				.sendKeys("IPhone12");

		driver.findElement(By.id("input-meta-title1")).sendKeys("Apple");

		driver.findElement(By.id("input-meta-description1")).sendKeys("Apple12");
		driver.findElement(By.id("input-meta-keyword1")).sendKeys("APP");
		Thread.sleep(3000);

	}

	@Test(priority = 5)
	public void click_on_saving_the_category() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy (0,-500)", "");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"div.page-header:nth-child(1) div.container-fluid div.pull-right:nth-child(1) button.btn.btn-primary:nth-child(1) > i.fa.fa-save"))
				.click();
		Thread.sleep(3000);

	}

	@Test(priority = 6)
	public void user_unable_to_add_the_category() throws Throwable {

		String text = driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[2]/div[1]"))
				.getText();
		System.out.println("" + text);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\\\Users\\\\vijayaraghavanj\\\\Desktop\\\\ScreenShots\\\\Output2.png"));
		Thread.sleep(3000);

	}

	@Test(priority = 7)
	public void user_selects_information_option() throws Throwable {

		driver.findElement(By.xpath("//a[contains(text(),'Information')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[1]/button[1]"))
				.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

	}

	@Test(priority = 8)
	public void user_unable_to_delete_the_information() throws IOException, InterruptedException {
		String str = driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[2]/div[1]"))
				.getText();
		System.out.println("" + str);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\vijayaraghavanj\\Desktop\\ScreenShots\\Output3.png"));
		Thread.sleep(3000);
	}

	@Test(priority = 9)
	public void click_on_extension() throws InterruptedException {
		driver.findElement(By.xpath(
				"//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-extension']/a[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-extension']/ul[@id='collapse14']/li[2]/a[1]"))
				.click();

	}

	@Test(priority = 10)
	public void use_the_Upload_button_to_upload_the_file_to_OpenCart_online_shop()
			throws InterruptedException, IOException {
		driver.findElement(By.id("button-upload")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\vijayaraghavanj\\Desktop\\uplodeFile.exe");
		Thread.sleep(4000);
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File DesFile = new File("C:\\Users\\vijayaraghavanj\\Desktop\\ScreenShots\\Output6.png");

		FileUtils.copyFile(SrcFile, DesFile);
	}

	@Test(priority = 11)
	public void Go_to_layout_option() throws Throwable {
		driver.findElement(By
				.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-design']/a[1]"))
				.click();
		driver.findElement(By.xpath(
				"//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-design']/ul[@id='collapse20']/li[1]/a[1]"))
				.click();
	}

	@Test(priority = 12)
	public void adding_layout() throws Throwable {
		driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[1]/a[1]"))
				.click();
		driver.findElement(By.name("name")).sendKeys("Functional");
		WebElement dropdown1 = driver.findElement(By.xpath(
				"//body/div[@id='container']/div[@id='content']/div[2]/div[1]/div[2]/form[1]/fieldset[2]/div[1]/div[1]/table[1]/tfoot[1]/tr[1]/td[1]/div[1]/select[1]"));
		Select select = new Select(dropdown1);
		select.selectByVisibleText("Account");
		WebElement dropdown2 = driver.findElement(By.xpath(
				"//body/div[@id='container']/div[@id='content']/div[2]/div[1]/div[2]/form[1]/fieldset[2]/div[1]/div[2]/table[1]/tfoot[1]/tr[1]/td[1]/div[1]/select[1]"));
		Select select2 = new Select(dropdown2);
		select2.selectByVisibleText("Category");
		WebElement dropdown3 = driver.findElement(By.xpath(
				"//body/div[@id='container']/div[@id='content']/div[2]/div[1]/div[2]/form[1]/fieldset[2]/div[1]/div[2]/table[2]/tfoot[1]/tr[1]/td[1]/div[1]/select[1]"));
		Select select3 = new Select(dropdown3);
		select3.selectByVisibleText("Home Page");
		WebElement dropdown4 = driver.findElement(By.xpath(
				"//body/div[@id='container']/div[@id='content']/div[2]/div[1]/div[2]/form[1]/fieldset[2]/div[1]/div[3]/table[1]/tfoot[1]/tr[1]/td[1]/div[1]/select[1]"));
		Select select4 = new Select(dropdown4);
		select4.selectByVisibleText("Banner 1");
		driver.findElement(
				By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[1]/button[1]/i[1]")).click();

	}

	@Test(priority = 13)
	public void layout_added_successfully() throws Throwable {
		String actualResult = driver.getTitle();
		String expectedResult = "layout added successfully";

		if (actualResult == expectedResult) {

			System.out.println("Success");

		} else {
			File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File DesFile = new File("C:\\Users\\vijayaraghavanj\\Desktop\\ScreenShots\\Output4.png");

			FileUtils.copyFile(SrcFile, DesFile);
		}
	}

	@Test(priority = 14)
	public void user_click_on_the_customer_field() throws InterruptedException {
		driver.findElement(By.xpath(
				"//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-customer']/a[1]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-customer']/ul[@id='collapse33']/li[1]/a[1]"))
				.click();
		Thread.sleep(3000);
	}

	@Test(priority = 15)
	public void enter_customerdetails_fields() throws InterruptedException {
		driver.findElement(By.name("filter_name")).sendKeys("qwerty");
		driver.findElement(By.id("button-filter")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("filter_name")).clear();
		driver.findElement(By.name("filter_email")).sendKeys("qwertyeee@hotmail.fr");
		driver.findElement(By.id("button-filter")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("filter_email")).clear();
	}

	@Test(priority = 16)
	public void click_on_edit_button() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//tbody/tr[1]/td[8]/div[1]/a[1]/i[1]")).click();
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Rani");
		driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[1]/button[1]"))
				.click();
		Thread.sleep(3000);
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File DesFile = new File("C:\\Users\\vijayaraghavanj\\Desktop\\ScreenShots\\Output8.png");

		FileUtils.copyFile(SrcFile, DesFile);
	}

	@Test(priority = 17)
		public void user_click_on_the_report_field() {
	    	driver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-report']/a[1]")).click();
	    	driver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-report']/ul[@id='collapse61']/li[1]/a[1]")).click();
			
			
		}
	@Test(priority = 18)
		public void choose_the_report_type() {
	    	driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[2]/div[1]/div[2]/div[1]/div[1]/select[1]")).click();
			Select drpreport1 = new Select(driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[2]/div[1]/div[2]/div[1]/div[1]/select[1]")));
			drpreport1.selectByVisibleText("Customer Orders Report");

		    
		}

	@Test(priority = 19)
		public void user_click_on_Customer_name() throws InterruptedException {
	           
			driver.findElement(By.name("filter_customer")).sendKeys("Sanjana Sanju");
			Thread.sleep(3000);
			driver.findElement(By.id("button-filter")).click();
			Thread.sleep(3000);
			
		   
		}
	@Test(priority = 20)
		  public void view_the_customer_reports() throws IOException {
			
			File SrcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File DesFile = new File("C:\\Users\\vijayaraghavanj\\Desktop\\ScreenShots\\Output7.png");
			FileUtils.copyFile(SrcFile, DesFile);
		}
	@AfterTest
	public void closeweb() {
		driver.quit();
	}

}
