package EzTransfer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PanelOrder.login;
import PanelOrder.BaseTest;

public class transfer {
  WebDriver driver;
  login lg;
  BaseTest su;
  
  @BeforeMethod
  public void setUp() {
	  //su = new setUp(driver);
	  //lg = new login(driver);
	  BaseTest.setUpBeforeTest(driver, "https://accounts.fpts.com.vn/Login");	  
	  login.loginEzTrade(driver, "058C550880", "fpts12345");
  }
  
  @Test
  public void f() {
	  
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.close();
  }
  
}
