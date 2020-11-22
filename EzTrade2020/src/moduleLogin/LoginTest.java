package moduleLogin;

import org.testng.annotations.Test;

//import org.openqa.selenium.Alert;

import org.testng.Assert;
import utilities.Links;

	public class LoginTest extends BaseTest{
		LoginPage loginPg;
		String account = "000294";
		String password = "fpts12345";
		
		@Test
		public void checkUI() {
			
		}
		
		@Test
		public void loginWithSpace () {
			loginPg = new LoginPage(driver);
			loginPg.login("", "");
			//Alert alert;
			Assert.assertEquals(driver.switchTo().alert().getText(),"Vui lòng không để trống mật khẩu");
		}
		
		@Test
		public void loginSuccessful() {
			loginPg = new LoginPage(driver);
			loginPg.login(account,password);
			Assert.assertEquals(driver.getCurrentUrl(), Links.URL_dashBoard);
		}
		
		@Test
		public void loginWrongAccountPassword() {
			
		}
		
		@Test
		public void loginWrongAccount() {
			
		}
		
		@Test
		public void loginWrongPassword() {
			
		}
		
	}