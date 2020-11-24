package PanelOrder;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;

import Library.BaseTest;

public class checkValidationTest extends BaseTest{
  checkValidationPage checkValidationPg;
 
  @Test
  public void checkValidation_MaCK() throws InterruptedException, AWTException {
	  login("000294","fpts12345");
	  checkValidationPg = new checkValidationPage(driver);
	  
	  //Check for over-allowed characters 
	  checkValidationPg.insertInformation("                                                  ", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
	  
	  /*
	   *
	  //Check for number input
	  checkValidationPg.insertInformation("123", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
	   
	  //Check for special character
	  checkValidationPg.insertInformation("!@#", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
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
	  */
  }
}
