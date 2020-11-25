package PanelOrder;

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
  */
  @Test
  public void checkValidation_KL() throws InterruptedException {
	  login("000294","fpts12345");
	  checkValidationPg = new checkValidationPage(driver);
	  /*
	  //Check enter characters
	  checkValidationPg.insertField("abc", "//input[@sid='txtQty']");
	  compareDataOfAlert("Số lượng không hợp lệ (Số nguyên lớn hơn 0 )");
	  
	  //Check enter value is 0
	  checkValidationPg.insertField("0", "//input[@sid='txtQty']");
	  compareDataOfAlert("Số lượng không hợp lệ (Số nguyên lớn hơn 0 )");
	  */
	  //Check volumn entry is greater than maximum volumn 
	  checkValidationPg.insertJustField("ABC","//input[@id='txtSymbol']");
		
	  driver.findElement(By.xpath("//input[@sid='txtQty']")).click();
	  Thread.sleep(1000);
	  WebElement KLMax = driver.findElement(By.id("spnMaxOrder"));
	  KhoiLuongMax = KLMax.getText();
	  
	  //fix error java.lang.NumberFormatException.forInputString(Unknown Source)
	  /*
	  try{
		  ChangeKLMax = Integer.parseInt(KhoiLuongMax);
		  
		 
		} catch(NumberFormatException ex){ // handle your exception
		  ex.getStackTrace();
		}
	  
	  ChangeKLMax = ChangeKLMax + 100;
	  KhoiLuongMax = String.valueOf(ChangeKLMax);
	  */
	  driver.findElement(By.xpath("//input[@sid='txtQty']")).sendKeys(KhoiLuongMax + 0);
	  driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
	  Thread.sleep(1000);
	  compareDataOfAlert("Số dư chứng khoán không đủ");
	  
	  //Check that the volume of the stock HNX is not a multiple of 100
	  checkValidationPg.insertJustField("111","//input[@sid='txtQty']");
	  driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
	  compareDataOfAlert("Số lượng Báo giá là bội số của 100 với sàn HNX/UPCOM");
	  
	  //Check that the volume of the stock HSX is not a multiple of 10
	  checkValidationPg.insertJustField("VNM","//input[@id='txtSymbol']");
	  checkValidationPg.insertJustField("11","//input[@sid='txtQty']");
	  driver.findElement(By.xpath("//input[@id='txtPrice']")).click();
	  compareDataOfAlert("Số lượng Báo giá là bội số của 10 với sàn HOSE");
  }
}