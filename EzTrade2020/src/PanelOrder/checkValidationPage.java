package PanelOrder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javafx.scene.control.Alert;

public class checkValidationPage {
	WebDriver driver;
	
	public checkValidationPage(WebDriver driver) {
		this.driver = driver;
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
	
	//Enter data for 3 fields
	
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
	
	//Enter data for MaCK field and KL field
	
	public void insertFields_MaCK_KL (String MaCK, String KL) {
		driver.findElement(By.xpath("//input[@id='txtSymbol']")).click();
		driver.findElement(By.xpath("//input[@id='txtSymbol']")).sendKeys(MaCK);
		
		driver.findElement(By.xpath("//input[@sid='txtQty']")).click();
		driver.findElement(By.xpath("//input[@sid='txtQty']")).sendKeys(KL);
		
		driver.findElement(By.id("btnBuySend")).click();
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
	
	//Confirm password
	public void confirmPassword(String password) throws InterruptedException {
		driver.findElement(By.id("txtPass2OF")).sendKeys(password);
		driver.findElement(By.id("btnSendOF")).click();
		Thread.sleep(2000);
	}
	
	//Check confirm password successful
	public void successfulmessage(String message) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content xacNhanDatLenh")));
		WebElement ele = driver.findElement(By.id("tdConfirmOrderFormMess"));
		ele.getText();
		Assert.assertEquals(ele.getText(),message);
	}
}