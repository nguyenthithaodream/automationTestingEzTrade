package PanelOrder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Normal_SellOrderPage {
	
	WebDriver driver;
	String part1 = "//div[@class='bottom__sdCKhoan__content']/table/tbody/tr[";
	String part2 = "]/td[";
	String part3 = "]";
	
	public Normal_SellOrderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void placingSellOrder(int row) {
		driver.findElement(By.xpath("//div[@id='tabSell']")).click();
		driver.findElement(By.xpath(part1 + row + part2 + "3" + part3 +"/input[1]")).click();
		driver.findElement(By.id("btnUpPrice")).click();
		driver.findElement(By.id("btnSellSend")).click();
	}
	
	
	public void getCellTable() {
		//Locate the table, get total of columns and rows
		WebElement tbody = driver.findElement(By.xpath("//div[@class='bottom__sdCKhoan__content']/table/tbody"));
		List<WebElement> rows_table = tbody.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
				  
		WebElement thead = driver.findElement(By.xpath("//div[@class='bottom__sdCKhoan__content']/table/thead"));
		List<WebElement> columns_table = thead.findElements(By.tagName("th"));
		int columns_count = columns_table.size();
		/*
		for(int row = 0; row < rows_count; row++) {
			List<WebElement> cell = rows_table.get(row).findElements(By.tagName("td"));
		}
		*/
		// //div[@class='bottom__sdCKhoan__content']/table/tbody/tr[1]/td[3]/input[1]
	}
}
