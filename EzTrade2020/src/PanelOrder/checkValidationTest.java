package PanelOrder;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Library.BaseTest;

public class checkValidationTest extends BaseTest{
  checkValidationPage checkValidationPg;
  String KhoiLuongMax;
  int ChangeKLMax;
 /*
  @Test
  public void checkValidation_MaCK() throws InterruptedException {
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
  public void checkValidation_KL() throws InterruptedException, AWTException {
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
	  //fix error java.lang.NumberFormatException.forInputString(Unknown Source)
	  
	  //try{
	 	//  ChangeKLMax = Integer.parseInt(KhoiLuongMax);
		  
		 
		//} catch(NumberFormatException ex){ // handle your exception
		//  ex.getStackTrace();
		//}
	  
	 // ChangeKLMax = ChangeKLMax + 100;
	 // KhoiLuongMax = String.valueOf(ChangeKLMax);
	  
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
  */
  @Test
  public void checkValidation_Gia() throws InterruptedException, AWTException {
	  login("000294","fpts12345");
	  checkValidationPg = new checkValidationPage(driver);
	  
	  //Check enter value is 0
	  //String RefPri = checkValidationPg.GetRefPri("ABC"); //get the reference price
	  checkValidationPg.insertAllField("ABC", "10","0");
	  compareDataOfAlert("Giá không hợp lệ.");
	  
	  //Check character input
	  checkValidationPg.insertAllField("ABC", "100","abc");
	  compareDataOfAlert("Giá không hợp lệ.");
	  
	  //Check enter the price is more than ceiling price
	  String ceiPri = checkValidationPg.GetCeiPri("ABC");
	  checkValidationPg.insertJustField(ceiPri + 0, "//input[@id='txtPrice']");
	  compareDataOfAlert("Giá không hợp lệ.");
	  
	  //Check enter the price is more than the floor price
	  
  }
}