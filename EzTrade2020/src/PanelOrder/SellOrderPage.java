package PanelOrder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SellOrderPage {
	WebDriver driver;
	public  SellOrderPage(WebDriver driver) {
		this.driver =driver;
	}
	public static void loginEzTrade(WebDriver driver, String account, String password) {
		//this.driver = driver;
		driver.findElement(By.xpath("//input[@id='txtAccountNo']")).sendKeys(account);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnSubmit")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
}
