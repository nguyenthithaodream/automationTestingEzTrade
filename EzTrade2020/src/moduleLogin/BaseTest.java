package moduleLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.Links;

public class BaseTest {
	
		WebDriver driver;
		
		/*public void login(String Account, String Password) {
			WebDriverWait wait = new WebDriverWait(driver,30);
			//driver.findElement(By.xpath("//input[@id='btnContineLogin']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtAccountNo']")));
			driver.findElement(By.xpath("//input[@id='txtAccountNo']")).sendKeys(Account);
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Password);
			driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		}
		*/
		@BeforeMethod
		public void setUp() {
			//System.setProperty("webdriver.chrome.driver","E:\\downsload\\selenium\\chromedriver_win32_85\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver","D:\\dowload\\Programs\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			// Get link EzTrade
			driver.get(Links.URL_login);
			driver.manage().window().maximize();
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		public void compareDataOfAlert(String content) { //content is expected content of alert
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Alert alert = driver.switchTo().alert();
				Assert.assertEquals(alert.getText(),content);
				alert.accept();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
}
