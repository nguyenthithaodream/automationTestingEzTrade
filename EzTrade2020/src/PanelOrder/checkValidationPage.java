package PanelOrder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		Thread.sleep(1000);
		driver.findElement(By.xpath(xpath)).clear();
	}
	
	//Enter data for 3 fields
	
	public void insertAllField (String MaCK, String KL, String Gia) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='txtSymbol']")).click();
		driver.findElement(By.xpath("//input[@id='txtSymbol']")).sendKeys(MaCK);
		
		driver.findElement(By.xpath("//input[@sid='txtQty']")).click();
		driver.findElement(By.xpath("//input[@sid='txtQty']")).sendKeys(KL);
		
		driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
		driver.findElement(By.xpath("//input[@id='txtPrice']")).sendKeys(Gia);
		
		Thread.sleep(1000);
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
	
	//Get references price
	public String GetRefPri(String MaCK) {
		insertJustField(MaCK, "//input[@id='txtSymbol']");
		driver.findElement(By.xpath("//input[@sid='txtQty']")).click();
		return driver.findElement(By.id("spnRefPrice")).getText();
	}
	
	//Get ceiling price
	public String GetCeiPri(String MaCK) {
			insertJustField(MaCK, "//input[@id='txtSymbol']");
			driver.findElement(By.xpath("//input[@sid='txtQty']")).click();
			return driver.findElement(By.id("spnCeilPrice")).getText();
	}
	//Get floor price
	public String GetFloPri(String MaCK) {
		insertJustField(MaCK, "//input[@id='txtSymbol']");
		driver.findElement(By.xpath("//input[@sid='txtQty']")).click();
		return driver.findElement(By.id("spnFloorPrice")).getText();
	}	
}