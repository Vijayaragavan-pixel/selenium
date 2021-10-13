package mavenSeleniumGA;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;





public class LogInPage {
	WebDriver driver;
	
	
		public LogInPage(WebDriver driver) {
			this.driver = driver;
		}
	
/*	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
	
	if(browser.equalsIgnoreCase("firefox")){
	WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	 
	else if (browser.equalsIgnoreCase("chrome")){
	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	 
	}else{
	throw new Exception("Browser is not correct");
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

	@BeforeTest
	public void setup() {
		WebDriverManager.chromiumdriver().setup();
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\vijayaraghavanj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
*/	
	
	public void run() throws InterruptedException {
		logIn();
		logOut();
	}
	
	public void logIn() throws InterruptedException {
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		Thread.sleep(1000);
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/form[1]/div[5]/input[1]")).click();
		Thread.sleep(2000);
	}
	
	public void logOut() throws InterruptedException {
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}