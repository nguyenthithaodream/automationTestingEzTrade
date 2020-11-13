package PanelOrder;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WriterOrrders {
  

	WebDriver driver;
	login LoginPg;
  @BeforeMethod
  public void setUp() {
	  PanelOrder.BaseTest.setUpBeforeTest(driver, "https://accounts.fpts.com.vn/Login");
	  PanelOrder.login.loginEzTrade(driver, "058C550880", "fpts12345");
  }
  
  @Test
  public void f() {
	  
  }
}
