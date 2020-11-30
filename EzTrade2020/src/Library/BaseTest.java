package Library;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import utilities.Links;

public class BaseTest {
	
		public WebDriver driver;
		
		
	
		@BeforeMethod
		public void setUp() {
			System.setProperty("webdriver.chrome.driver","E:\\downloads\\selenium\\chromedriver_win32_85\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver","D:\\dowload\\Programs\\selenium\\chromedriver.exe");
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			driver = new ChromeDriver(dc);
			// Get link EzTrade
			driver.get(Links.URL_login);
			driver.manage().window().maximize();
		}
		/*
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		*/
		public void compareDataOfAlert(String content) throws AWTException { //content is expected content of alert
			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Alert alert = driver.switchTo().alert();
				Assert.assertEquals(alert.getText(),content);
				alert.accept();
				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Robot rb = new Robot();
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
			}
			catch(UnhandledAlertException e){
				e.printStackTrace();
			}
			/*
			try {
			    //click(myButton);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (UnhandledAlertException f) {
			    try {
			        Alert alert = driver.switchTo().alert();
			        String alertText = alert.getText();
			        Assert.assertEquals(alertText,content);
			        alert.accept();
			    } catch (NoAlertPresentException e) {
			        e.printStackTrace();
			    }
			}*/
			
		}
		
		public void login(String Account, String Password) {
			  driver.findElement(By.xpath("//input[@id='txtAccountNo']")).sendKeys(Account);
			  driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Password);
			  driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  driver.findElement(By.id("onesignal-slidedown-allow-button")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
			 
		  }
		public void verifyLinkActive(String linkURL) throws MalformedURLException {
			try {
				URL url =  new URL(linkURL);
				HttpURLConnection URLCon = (HttpURLConnection) url.openConnection();
				URLCon.setConnectTimeout(300);
				URLCon.connect();
				if(URLCon.getResponseCode() == 200) {
					System.out.println(url + "-" + URLCon.getResponseCode());
				}
				else {
					System.out.println(url + "-" + URLCon.getResponseCode());
				}
			}
			catch (Exception e) {}
		}
}