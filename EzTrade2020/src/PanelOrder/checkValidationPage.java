package PanelOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkValidationPage {
	WebDriver driver;
	
	public checkValidationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Enter data for 3 fields
	
	
	//Enter data for MaCK field and KL field
	
	public void insertFields_MaCK_KL (String MaCK, String KL) {
		driver.findElement(By.xpath("//input[@id='txtSymbol']")).click();
		driver.findElement(By.xpath("//input[@id='txtSymbol']")).sendKeys(MaCK);
		
		driver.findElement(By.xpath("//input[@sid='txtQty']")).click();
		driver.findElement(By.xpath("//input[@sid='txtQty']")).sendKeys(KL);
		
		driver.findElement(By.id("btnBuySend")).click();
	}
}