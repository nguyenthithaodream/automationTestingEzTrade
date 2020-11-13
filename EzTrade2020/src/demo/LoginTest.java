package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Links;

	public class LoginTest extends BaseTest{
		LoginPage loginPg;
		String account = "550880";
		String password = "fpts12345";
	
		@Test
		public void loginSuccessful() {
			loginPg = new LoginPage(driver);
			loginPg.login(account,password);
			Assert.assertEquals(driver.getCurrentUrl(), Links.URL_dashBoard);
		}
		
	}