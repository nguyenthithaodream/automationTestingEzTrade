package PanelOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class editOrderPage {
	WebDriver driver;
	String part1 = "//table[@id='gvwReport']/tbody[@id='tbdActivity']/tr[";
	String part2 = "]/td[";
	String part3 = "]";
	public editOrderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void editQuaPri(int tr, String quantity, String price) {
		driver.findElement(By.xpath(part1 + tr + part2 + "1" + part3 + "]/input")).click();
		driver.findElement(By.id("txtQtyActivity")).sendKeys(quantity);
		boolean disabledPrice = driver.findElement(By.xpath("//input[@sid='txtPriceActivity']")).isEnabled();
		if (disabledPrice == true) {
			driver.findElement(By.id("txtQtyActivity")).sendKeys(price);
		}
		driver.findElement(By.id("btnModifyActivity")).click();
	}
	
	public void editQuantity(int tr, String quantity) {
		driver.findElement(By.xpath(part1 + tr + part2 + "1" + part3 + "]/input")).click();
		driver.findElement(By.id("txtQtyActivity")).sendKeys(quantity);
		driver.findElement(By.id("btnModifyActivity")).click();
	}
	
	public void editPrice(int tr, String price) {
		driver.findElement(By.xpath(part1 + tr + part2 + "1" + part3 + "]/input")).click();
		boolean disabledPrice = driver.findElement(By.xpath("//input[@sid='txtPriceActivity']")).isEnabled();
		if (disabledPrice == true) {
			driver.findElement(By.id("txtQtyActivity")).sendKeys(price);
		}
		driver.findElement(By.id("btnModifyActivity")).click();
	}
}
