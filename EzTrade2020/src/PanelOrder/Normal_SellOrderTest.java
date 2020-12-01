package PanelOrder;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Library.BaseTest;

public class Normal_SellOrderTest extends BaseTest{
 
	Normal_SellOrderPage Normal_SellOrderPg;

	//Check placed a order to sell securities successful by sending directly
	@Test
	public void TC01_sendingOrderSuccessful() throws InterruptedException {
	 
	  Normal_SellOrderPg = new Normal_SellOrderPage(driver);
	  login("000294","fpts12345");
	  Normal_SellOrderPg.placingSellOrder(1);
	  confirmPassword("fpts123456");
	  successfulmessage("Đặt lệnh thành công!");
	}
	
	//Check sell order with wrong password
	@Test
	public void TC02_sellOderWrongPassword() throws InterruptedException {
	 
	  Normal_SellOrderPg = new Normal_SellOrderPage(driver);
	  login("000294","fpts12345");
	  Normal_SellOrderPg.placingSellOrder(1);
	  confirmPassword("fpts12");
	  String err = driver.findElement(By.id("spnErrorMess")).getText();
	  Assert.assertEquals(err,"Sai mật khẩu giao dịch");
	}
	
	
	//Check sell order no enter password
	@Test
	public void TC03_sellOderNoPassword() throws AWTException {
	 
	  Normal_SellOrderPg = new Normal_SellOrderPage(driver);
	  login("000294","fpts12345");
	  Normal_SellOrderPg.placingSellOrder(1);
	  driver.findElement(By.id("btnSendOF")).click();
	  compareDataOfAlert("Qúy khách chưa nhập mật khẩu giao dịch");
	}
	
	//Check reset
	@Test
	public void TC04_reset(){
	 
	  Normal_SellOrderPg = new Normal_SellOrderPage(driver);
	  login("000294","fpts12345");
	  Normal_SellOrderPg.placingSellOrder(1);
	  driver.findElement(By.id("btnBackHome")).click();
	  driver.findElement(By.id("btnReset")).click();
	  Assert.assertEquals(driver.findElement(By.id("txtSymbol")).getText(),"");
	  Assert.assertEquals(driver.findElement(By.xpath("//input[@sid='txtQty']")).getText(),"");
	  Assert.assertEquals(driver.findElement(By.id("txtPrice")).getText(),"");
	}
	
}
