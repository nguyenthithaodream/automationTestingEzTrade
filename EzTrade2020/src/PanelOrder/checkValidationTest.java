package PanelOrder;

import org.testng.annotations.Test;
import login.BaseTest;
public class checkValidationTest extends BaseTest{
  checkValidationPage checkValidationPg;
  
  @Test
  public void checkValidation_MaCK() {
	  checkValidationPg = new checkValidationPage(driver);
	  checkValidationPg.insertInformation("                                            ", "//input[@id='txtSymbol']");
	  compareDataOfAlert("Không tồn tại mã CK này");
  }
}
