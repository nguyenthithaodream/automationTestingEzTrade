package PanelOrder;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Library.BaseTest;

public class checkValidationTest extends BaseTest{
  checkValidationPage checkValidationPg;
 
  @Test
  public void checkValidation_MaCK() {
	  login("000294","fpts12345");
	  checkValidationPg = new checkValidationPage(driver);
	  
	  //Check for over-allowed characters 
	  checkValidationPg.insertInformation("                                                  ", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
	  driver.findElement(By.id("txtSymbol")).clear();
	  
	  //Check for number input
	  checkValidationPg.insertInformation("123", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
	  driver.findElement(By.id("txtSymbol")).clear();
	  
	  //Check for special character
	  checkValidationPg.insertInformation("!@#", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
	  driver.findElement(By.id("txtSymbol")).clear();
  }
  
  @Test
  public void checkValidation_KL() {
	  login("000294","fpts12345");
	  checkValidationPg = new checkValidationPage(driver);
	  
	  //Check enter characters
	  checkValidationPg.insertInformation("abc", "//input[@sid='txtQty']");
	  compareDataOfAlert("Số lượng không hợp lệ (Số nguyên lớn hơn 0 )");
	  
	  //Check enter value is 0
	  checkValidationPg.insertInformation("0", "//input[@sid='txtQty']");
	  compareDataOfAlert("Số lượng không hợp lệ (Số nguyên lớn hơn 0 )");
	  
  }
}