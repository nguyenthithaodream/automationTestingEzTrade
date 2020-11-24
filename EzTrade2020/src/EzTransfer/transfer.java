package EzTransfer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PanelOrder.SellOrderPage;
import PanelOrder.BuyOrderPage;

public class transfer {
  WebDriver driver;
  SellOrderPage lg;
  BuyOrderPage su;
  
  @BeforeMethod
  public void setUp() {
	  //su = new setUp(driver);
	  //lg = new login(driver);
	  BuyOrderPage.setUpBeforeTest(driver, "https://accounts.fpts.com.vn/Login");	  
	  SellOrderPage.loginEzTrade(driver, "058C550880", "fpts12345");
  }
  
  @Test
  public void f() {
	  
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.close();
  }
  
}
