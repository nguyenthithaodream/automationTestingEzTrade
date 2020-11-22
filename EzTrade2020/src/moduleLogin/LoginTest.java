package moduleLogin;

import org.testng.annotations.Test;
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
			compareDataOfAlert("Vui lòng không để trống mật khẩu");
		}
		
		@Test
		public void loginSuccessful() {
			loginPg = new LoginPage(driver);
			loginPg.login(account,password);
			Assert.assertEquals(driver.getCurrentUrl(), Links.URL_dashBoard);
		}
		
		@Test
		public void loginWrongAccountPassword() {
			loginPg = new LoginPage(driver);
			loginPg.login("0000000", "hhhhhhhhh");
			compareDataOfAlert("Tài khoản không hợp lệ xin vui lòng nhập đúng tên đăng nhập");
		}
		
		@Test
		public void loginWrongAccount() {
			loginPg = new LoginPage(driver);
			loginPg.login("000000", "fpts12345");
			compareDataOfAlert("Tên đăng nhập không chính xác");
		}
		
		@Test
		public void loginWrongPassword() {
			loginPg = new LoginPage(driver);
			loginPg.login("000294", "abc");
			compareDataOfAlert("Sai mật khẩu, vui lòng đăng nhập lại");
		}
		
	}