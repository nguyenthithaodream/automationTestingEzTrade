package PanelOrder;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Library.BaseTest;

public class checkValidationTest extends BaseTest{
  checkValidationPage checkValidationPg;
  String KhoiLuongMax;
  float Change;
 
  @Test
  public void TC_001_checkValidation_MaCK() throws InterruptedException, AWTException {
	  login("000294","fpts12345");
	  checkValidationPg = new checkValidationPage(driver);
	  
	  //Check for over-allowed characters 
	  insertField("                                                  ", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
	  
	  //Check for number input
	  insertField("123", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
	  
	  //Check for special character
	  insertField("!@#", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
  }
  
 
  @Test
  public void TC_002_checkValidation_KL() throws InterruptedException, AWTException {
	  login("000294","fpts12345");
	  checkValidationPg = new checkValidationPage(driver);
	  
	  //Check enter characters
	  //checkValidationPg.insertField("abc", "//input[@sid='txtQty']");
	  driver.findElement(By.xpath("//input[@sid='txtQty']")).sendKeys("abc");
	  driver.findElement(By.xpath("//input[@id='txtSymbol']")).click();
	  Thread.sleep(1000);
	  compareDataOfAlert("Số lượng không hợp lệ (Số nguyên lớn hơn 0 )");
	  
	  //Check enter value is 0
	  //checkValidationPg.insertField("0", "//input[@sid='txtQty']");
	  driver.findElement(By.xpath("//input[@sid='txtQty']")).sendKeys("0");
	  driver.findElement(By.xpath("//input[@id='txtSymbol']")).click();
	  Thread.sleep(1000);
	  compareDataOfAlert("Số lượng không hợp lệ (Số nguyên lớn hơn 0 )");
	  
	  //Check the quantities input is greater than the maximum quantities 
	  KhoiLuongMax = getMaxNum("ABC");
	  
	  driver.findElement(By.xpath("//input[@sid='txtQty']")).sendKeys(KhoiLuongMax + 0);
	  driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
	  Thread.sleep(1000);
	  compareDataOfAlert("Số dư chứng khoán không đủ");
	  
	  //Check that the quantities of the stock HNX is not a multiple of 100
	  insertJustField("111","//input[@sid='txtQty']");
	  driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
	  compareDataOfAlert("Số lượng Báo giá là bội số của 100 với sàn HNX/UPCOM");
	  
	  //Check that the quantities of the stock HSX is not a multiple of 10
	  insertJustField("VNM","//input[@id='txtSymbol']");
	  insertJustField("11","//input[@sid='txtQty']");
	  driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
	  compareDataOfAlert("Số lượng Báo giá là bội số của 10 với sàn HOSE");
	    
	  //Check character input
	  insertJustField("!@#","//input[@id='txtSymbol']");
	  driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
	  compareDataOfAlert("Không tồn tại mã CK này");
  }
  
  @Test
  public void TC_003_checkValidation_Gia() throws InterruptedException, AWTException {
	  login("000294","fpts12345");
	  checkValidationPg = new checkValidationPage(driver);
	  
	  //Check enter value is 0

	  //TEST FAIL BECAUSE IT DOSEN'T TAKE VALUE OF 0 ===>>> Bật ra 1 popup chưa nhập giá nữa làm case fail
	  insertAllField("ABC", "10","0");
	  Thread.sleep(1000);
	  compareDataOfAlert("Giá không hợp lệ.");
	  Thread.sleep(1000);
	  Robot rb = new Robot();
	  rb.keyPress(KeyEvent.VK_ESCAPE);
	  rb.keyRelease(KeyEvent.VK_ESCAPE);
	  rb.keyPress(KeyEvent.VK_ESCAPE);
	  rb.keyRelease(KeyEvent.VK_ESCAPE);
	 
	  //Check character input
	  insertAllField("ABC", "100","abc");
	  Thread.sleep(1000);
	  compareDataOfAlert("Giá không hợp lệ.");
	  //Robot rb = new Robot();
	  Thread.sleep(1000);
	  rb.keyPress(KeyEvent.VK_ESCAPE);
	  rb.keyRelease(KeyEvent.VK_ESCAPE);
	  rb.keyPress(KeyEvent.VK_ESCAPE);
	  rb.keyRelease(KeyEvent.VK_ESCAPE);
	  
	  
	  //Check enter the price is more than ceiling price
	  String ceiPri = GetPri("ABC","spnCeilPrice");
	  insertAllField("ABC","10",ceiPri + 9);
	  Thread.sleep(1000);
	  compareDataOfAlert("Giá không được lớn hơn giá Trần.");
	  Thread.sleep(1000);
	  rb.keyPress(KeyEvent.VK_ESCAPE);
	  rb.keyRelease(KeyEvent.VK_ESCAPE);
	  rb.keyPress(KeyEvent.VK_ESCAPE);
	  rb.keyRelease(KeyEvent.VK_ESCAPE);
	  
	  //Check enter the price is more than the floor price
	  String floPri = GetPri("ABC","spnFloorPrice");
	  Change = Float.parseFloat(floPri);
	  Change = Change - 1;
	  String con = String.valueOf(Change);
	  insertAllField("ABC","10",con);
	  Thread.sleep(1000);
	  compareDataOfAlert("Giá không được nhỏ hơn giá Sàn.");
	  
	  //Check for wrong entry of price step
	  
  }
  
}