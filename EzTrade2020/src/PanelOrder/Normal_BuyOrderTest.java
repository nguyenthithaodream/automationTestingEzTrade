package PanelOrder;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Library.BaseTest;

public class Normal_BuyOrderTest extends BaseTest{
	
	
    //checkValidationPage checkValidationPg;
    Normal_BuyOrderPage Normal_BuyOrderPg;
    
    //==========================================SENDING DIRECTLY==================================================
	//Check placed a order to buy securities successful by sending directly
    
	@Test
	public void TC_01_sendingOrderSuccessful() throws AWTException, InterruptedException {
	  Normal_BuyOrderPg = new Normal_BuyOrderPage(driver);
	  
	  login("000294","fpts12345");
	  insertJustField("ABC", "//input[@id='txtSymbol']");
	  String floPri = GetPri("ABC","spnFloorPrice");
	  insertAllField("ABC", "10", floPri);
	  confirmPassword("fpts123456");
	  successfulmessage("Lệnh đặt thành công!"); //======================== KIÊM TRA LẠI MESSAGE CÓ THỂ LỖI ===========
	}
	
	
    //Check placed a securities order with the wrong symbol (MaCK)
	@Test
	public void TC_02_sendingOderWrongMaCK() throws AWTException {
		Normal_BuyOrderPg = new Normal_BuyOrderPage(driver);
		login("000294","fpts12345");
		driver.findElement(By.xpath("//input[@id='txtSymbol']")).sendKeys("aaaa");
		driver.findElement(By.xpath("//input[@sid='txtQty']")).click();
		compareDataOfAlert("Không tồn tại mã CK này");
	}
	
	
	//Check button reset 
	@Test
	public void TC_03_buttonReset() throws InterruptedException {
		Normal_BuyOrderPg = new Normal_BuyOrderPage(driver);
		login("000294","fpts12345");
		WebElement maCK = driver.findElement(By.xpath("//input[@id='txtSymbol']"));
		WebElement SL = driver.findElement(By.xpath("//input[@sid='txtQty']"));
		WebElement Gia = driver.findElement(By.xpath("//input[@id='txtPrice']"));
		maCK.sendKeys("ABC");
		SL.click();
		Thread.sleep(1000);
		SL.sendKeys("10");
		try {
			String pr = GetPri("ABC","spnRefPrice");
			Gia.sendKeys(pr);
		}catch(NullPointerException e) {
			e.getStackTrace();
		}
		
		driver.findElement(By.id("btnReset")).click();
		Assert.assertEquals(maCK.getText(),""); 
		Assert.assertEquals(SL.getText(),""); 
		Assert.assertEquals(Gia.getText(),""); 
	}
	
	//Check buy order with wrong password
	@Test
	public void TC04_buyOderWrongPassword() throws InterruptedException {
	 
		Normal_BuyOrderPg = new Normal_BuyOrderPage(driver);
		login("000294","fpts12345");
		String floPri = GetPri("ABC","spnFloorPrice");
		insertAllField("ABC", "10", floPri);
		confirmPassword("fpts12");
		String err = driver.findElement(By.id("spnErrorMess")).getText();
		Assert.assertEquals(err,"Sai mật khẩu giao dịch");
	}
	
	//Check buy order no enter password
	@Test
	public void TC05_buyOderWrongPassword() throws InterruptedException, AWTException {
	 
		Normal_BuyOrderPg = new Normal_BuyOrderPage(driver);
		login("000294","fpts12345");
		String floPri = GetPri("ABC","spnFloorPrice");
		insertAllField("ABC", "10", floPri);
		driver.findElement(By.id("btnSendOF")).click();
		compareDataOfAlert("Qúy khách chưa nhập mật khẩu giao dịch");
	}
}
