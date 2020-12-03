package PanelOrder;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Library.BaseTest;

public class editOrderTest extends BaseTest{
	editOrderPage editOrderPg;
  /*
	SET UP DATA TO TEST
	1. HNX
	2. HNX
	3. HNX: odd lot
	4. HNX: even lot
	5. UpCom: odd lot
	6. UpCom: even lot
	
   */
  // Check edit securities order successful
  @Test
  public void editSucccessful() throws AWTException, InterruptedException {
	  editOrderPg = new editOrderPage(driver);
	  login("000294","fpts12345");
	  driver.findElement(By.id("rpPending")).click();
	  Thread.sleep(1000);
	  editOrderPg.editQuantity(2, "200");
	  compareDataOfAlert("Lệnh đặt thành công");
  }
  /*
  //Check reset button
  @Test
  public void editNoPassword() throws AWTException {
	  editOrderPg = new editOrderPage(driver);
	  login("000294","fpts12345");
	  driver.findElement(By.id("rpPending")).click();
	  WebElement KL = driver.findElement(By.xpath("//input[@sid='txtQtyActivity']"));
	  WebElement Gia = driver.findElement(By.xpath("//input[@sid='txtPriceActivity']"));
	  String orgKL = KL.getText();
	  String orgGia = Gia.getText();
	  //editOrderPg.editQuantity(2, "200");
	  driver.findElement(By.id("btnUpQtyActivity")).click();
	  driver.findElement(By.id("buttonUpPriceActivity()")).click();
	  //Function edit price
	  driver.findElement(By.id("btnResetModify")).click();
	  String newKL = KL.getText();
	  String newGia = Gia.getText();
	  Assert.assertEquals(newKL, orgKL);
	  Assert.assertEquals(newGia, orgGia);
	  
  }
  
  //Check edit the odd lot 
  @Test
  public void editOddLot() {
	  
  }
  
  //Check edit HSX securities bigger than 500000
  public void editHNXMaxQuantity() {
	  
  }
  */
  //Check edit quantity smaller than 100 of HNX/UpCom with Price which is not LO
}
