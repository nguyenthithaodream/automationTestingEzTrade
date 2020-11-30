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
import org.openqa.selenium.WebElement;
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
		
		//Enter data for a field
		public void insertJustField(String content, String xpath) {
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).click();
			driver.findElement(By.xpath(xpath)).sendKeys(content);
		}
		
		public void insertField (String content, String xpath) throws InterruptedException {
			driver.findElement(By.xpath(xpath)).click();
			driver.findElement(By.xpath(xpath)).sendKeys(content);
			driver.findElement(By.id("btnBuySend")).click();
			//Thread.sleep(1000);
			//driver.findElement(By.xpath(xpath)).clear();
		}
		
		//Confirm password sending directly
		public void confirmPassword(String password) throws InterruptedException {
			driver.findElement(By.id("txtPass2OF")).sendKeys(password);
			driver.findElement(By.id("btnSendOF")).click();
			//Thread.sleep(2000);
		}
		
		//Get the maximum number
		public String getMaxNum (String maCK) throws InterruptedException {
			insertJustField(maCK,"//input[@id='txtSymbol']");
			driver.findElement(By.xpath("//input[@sid='txtQty']")).click();
			Thread.sleep(1000);
			WebElement KLMax = driver.findElement(By.id("spnMaxOrder"));
			return KLMax.getText();

		}
		
		//Get price
		public String GetPri(String MaCK, String id) throws InterruptedException {
			insertJustField(MaCK, "//input[@id='txtSymbol']");
			driver.findElement(By.xpath("//input[@sid='txtQty']")).click();
			Thread.sleep(1000);
			return driver.findElement(By.id(id)).getText();
		}
		public void insertAllField (String MaCK, String KL, String Gia) throws InterruptedException {
			driver.findElement(By.xpath("//input[@id='txtSymbol']")).clear();
			driver.findElement(By.xpath("//input[@id='txtSymbol']")).click();
			driver.findElement(By.xpath("//input[@id='txtSymbol']")).sendKeys(MaCK);
			
			driver.findElement(By.xpath("//input[@sid='txtQty']")).clear();
			driver.findElement(By.xpath("//input[@sid='txtQty']")).click();
			driver.findElement(By.xpath("//input[@sid='txtQty']")).sendKeys(KL);
			
			driver.findElement(By.xpath("//input[@id='txtPrice']")).clear();
			driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
			driver.findElement(By.xpath("//input[@id='txtPrice']")).sendKeys(Gia);
			
			
			driver.findElement(By.id("btnBuySend")).click();
		}
		public void successfulmessage(String message) {
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content xacNhanDatLenh")));
			WebElement ele = driver.findElement(By.id("tdConfirmOrderFormMess"));
			ele.getText();
			Assert.assertEquals(ele.getText(),message);
		}
}