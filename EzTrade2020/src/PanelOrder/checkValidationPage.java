package PanelOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkValidationPage {
	WebDriver driver;
	
	public checkValidationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void insertInformation (String content, String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(content);
		driver.findElement(By.id("btnBuySend")).click();
		//driver.findElement(By.xpath(xpath)).clear();
	}
	
	
}