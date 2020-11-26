package PanelOrder;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Library.BaseTest;

public class Normal_BuyOrderTest extends BaseTest{
	
	BuyOrderPage BuyOrderPg = new BuyOrderPage(driver);
    checkValidationPage checkValidationPg = new checkValidationPage(driver);
    
	//Check placed a securities order successful by sending directly
	@Test
	public void TC_01_sendingOrderSuccessful() throws AWTException, InterruptedException {
	  login("000294","fpts12345");
	  checkValidationPg.insertJustField("ABC", "//input[@id='txtSymbol']");
	  String floPri = checkValidationPg.GetPri("ABC","spnFloorPrice");
	  checkValidationPg.insertAllField("ABC", "10", floPri);
	  checkValidationPg.confirmPassword("fpts123456");
	  checkValidationPg.successfulmessage("Lệnh đặt thành công");
	}
}
