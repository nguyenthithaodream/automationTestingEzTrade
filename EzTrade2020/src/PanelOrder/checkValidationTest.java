package PanelOrder;

import java.awt.AWTException;
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
	  checkValidationPg.insertField("                                                  ", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
	  
	  //Check for number input
	  checkValidationPg.insertField("123", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
	  
	  //Check for special character
	  checkValidationPg.insertField("!@#", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
  }
  
  @Test
  public void TC_002_checkValidation_KL() throws InterruptedException, AWTException {
	  login("000294","fpts12345");
	  checkValidationPg = new checkValidationPage(driver);
	  
	  //Check enter characters
	  checkValidationPg.insertField("abc", "//input[@sid='txtQty']");
	  compareDataOfAlert("Số lượng không hợp lệ (Số nguyên lớn hơn 0 )");
	  
	  //Check enter value is 0
	  checkValidationPg.insertField("0", "//input[@sid='txtQty']");
	  compareDataOfAlert("Số lượng không hợp lệ (Số nguyên lớn hơn 0 )");
	  
	  //Check the quantities input is greater than the maximum quantities 
	  KhoiLuongMax = checkValidationPg.getMaxNum("ABC");
	  
	  driver.findElement(By.xpath("//input[@sid='txtQty']")).sendKeys(KhoiLuongMax + 0);
	  driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
	  Thread.sleep(1000);
	  compareDataOfAlert("Số dư chứng khoán không đủ");
	  
	  //Check that the quantities of the stock HNX is not a multiple of 100
	  checkValidationPg.insertJustField("111","//input[@sid='txtQty']");
	  driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
	  compareDataOfAlert("Số lượng Báo giá là bội số của 100 với sàn HNX/UPCOM");
	  
	  //Check that the quantities of the stock HSX is not a multiple of 10
	  checkValidationPg.insertJustField("VNM","//input[@id='txtSymbol']");
	  checkValidationPg.insertJustField("11","//input[@sid='txtQty']");
	  driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
	  compareDataOfAlert("Số lượng Báo giá là bội số của 10 với sàn HOSE");
	    
	  //Check character input
	  checkValidationPg.insertField("!@#", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
  }
  
  @Test
  public void TC_003_checkValidation_Gia() throws InterruptedException, AWTException {
	  login("000294","fpts12345");
	  checkValidationPg = new checkValidationPage(driver);
	  
	  //Check enter value is 0

	  //TEST FAIL BECAUSE IT DOSEN'T TAKE VALUE OF 0 ===>>> Bật ra 1 popup chưa nhập giá nữa làm case fail
	  checkValidationPg.insertAllField("ABC", "10","0");
	  Thread.sleep(1000);
	  compareDataOfAlert("Giá không hợp lệ.");
	  Alert al = driver.switchTo().alert();
	  al.accept();

	  //Check character input
	  checkValidationPg.insertAllField("ABC", "100","abc");
	  Thread.sleep(1000);
	  compareDataOfAlert("Giá không hợp lệ.");
	  al.accept();
	  
	  //Check enter the price is more than ceiling price
	  String ceiPri = checkValidationPg.GetPri("ABC","spnCeilPrice");
	  checkValidationPg.insertAllField("ABC","10",ceiPri + 9);
	  Thread.sleep(1000);
	  compareDataOfAlert("Giá không được lớn hơn giá Trần.");
	  
	  
	  //Check enter the price is more than the floor price
	  String floPri = checkValidationPg.GetPri("ABC","spnFloorPrice");
	  Change = Float.parseFloat(floPri);
	  Change = Change - 1;
	  String con = String.valueOf(Change);
	  checkValidationPg.insertAllField("ABC","10",con);
	  Thread.sleep(1000);
	  compareDataOfAlert("Giá không được nhỏ hơn giá Sàn.");
	  
	  //Check for wrong entry of price step
	  
  }
}