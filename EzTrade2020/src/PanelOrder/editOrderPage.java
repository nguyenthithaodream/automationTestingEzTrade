package PanelOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class editOrderPage {
	WebDriver driver;
	String part1 = "//table[@id='gvwReport']/tbody/tr[";
	String part2 = "]/td[";
	String part3 = "]";
	public editOrderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void editQuantity(int tr, String quantity) {
		driver.findElement(By.xpath(part1 + tr + part2 + "1" + part3 + "]/input")).click();
		driver.findElement(By.id("txtQtyActivity")).sendKeys(quantity);
		driver.findElement(By.id("btnModifyActivity")).click();
		String element = "//input[@sid='txtPriceActivity']";
		if (isElementEnabled(driver, element)) {
			
		}
	}
}
