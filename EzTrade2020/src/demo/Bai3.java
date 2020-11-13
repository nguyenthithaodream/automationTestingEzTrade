package demo;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bai3 {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","E:\\downsload\\selenium\\chromedriver_win32_85\\chromedriver.exe");
		driver = new ChromeDriver();
		// Get link EzTrade
		driver.get("https://accounts.fpts.com.vn/Login?href=eztrade&s=14");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void loginFailed() throws InterruptedException, AWTException {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtAccountNo']")));
		driver.findElement(By.xpath("//input[@id='txtAccountNo']")).sendKeys("550880");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("fpts12345");
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		
		//Verify Login
		wait.until(ExpectedConditions.alertIsPresent());
		}
	@Test
	public void linkText() {
		//Navigate "Forgot Password"
		driver.findElement(By.xpath("//*[@id=\"logindivBox\"]/div[1]/div[3]/a[1]")).click();
		//Verify navigate title of "Forgot Password"
		//assertEquals("Câu hỏi thường gặp", driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, 30);
		assertEquals("https://accounts.fpts.com.vn/forgotpassword", driver.getTitle());

		//Navigate "Help"
		driver.findElement(By.xpath("//a[@href='/help']"));
		//Verify navigate title of "Forgot Password"
		assertEquals("Câu hỏi thường gặp", driver.getTitle());
	

		//Navigate "Mo tai khoan"
		driver.findElement(By.xpath("//a[@href='http://ezopen.fpts.com.vn']"));
		//Verify navigate title of "Forgot Password"
		assertEquals("ezopen.fpts.com.vn/Pages/Default.aspx", driver.getTitle());
		
		//Click link "EzTrade - giao dịch chứng khoán cơ sở"
		driver.findElement(By.xpath("//a[@class='fpts-menu-item fpts-eztrade']"));
		//Verify navigate title of "Forgot Password"
		assertEquals("FPTS Accounts :: Đăng nhập", driver.getTitle());
		
		//Click link "EzFutures - giao dịch chứng khoán phái sinh "
		driver.findElement(By.xpath("//a[@class='fpts-menu-item fpts-ezfutures']"));
		//Verify navigate title of "Forgot Password"
		assertEquals("FPTS Accounts :: Đăng nhập", driver.getTitle());
		
		//Click link "LivePrice - Bảng giá chứng khoán "
		driver.findElement(By.xpath("//a[@class='fpts-menu-item fpts-liveprice']"));
		//Verify navigate title of "Forgot Password"
		assertEquals("FPTS Accounts :: Đăng nhập", driver.getTitle());
		
		//Click link "EzTransfer - Chuyển tiền trực tuyến "
		driver.findElement(By.xpath("//a[@class='fpts-menu-item fpts-eztransfer active']"));
		//Verify navigate title of "Forgot Password"
		assertEquals("FPTS Accounts :: Đăng nhập", driver.getTitle());
	}
	@Test
	public void icon() {
		//Navigate "appStore"
		driver.findElement(By.xpath("//img[@src='/images/icon/logo-appstore.png']")).click();
		//Verify navigate title of "Forgot Password"
		assertEquals("FPTS EzMobileTrading trên AppStore", driver.getTitle());
	

		//Navigate "appStore"
		driver.findElement(By.xpath("//img[@src='/images/icon/logo-appstore.png']")).click();
		//Verify navigate title of "Forgot Password"
		assertEquals("FPTS EzMobileTrading trên AppStore", driver.getTitle());
		
		//Change language
		driver.findElement(By.xpath("//img[@src='/images/icon/icon-EN.png']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//a[@href='http://ezopen.fpts.com.vn']")), "Register"));
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.close();
	}
		
	}
	
	