package PanelOrder;

import org.testng.annotations.Test;

import Library.BaseTest;

public class Normal_SellOrderTest extends BaseTest{
 
	Normal_SellOrderPage Normal_SellOrderPg;
	//Check placed a order to sell securities successful by sending directly
	@Test
	public void TC01_sendingOrderSuccessful() throws InterruptedException {
	 
	  Normal_SellOrderPg = new Normal_SellOrderPage(driver);
	  login("000294","fpts12345");
	  Normal_SellOrderPg.placingSellOrder(1);
	  confirmPassword("fpts123456");
	  successfulmessage("Đặt lệnh thành công!");
	}
}
