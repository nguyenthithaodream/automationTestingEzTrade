package moduleLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
  public String account = "000294";
  public String password = "fpts12345";
  
  WebDriver driver;
  
  public LoginPage(WebDriver driver) {
	  this.driver = driver;
  }
  
  public void login(String Account, String Password) {
	  driver.findElement(By.xpath("//input[@id='txtAccountNo']")).sendKeys(Account);
	  driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Password);
	  driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
  }
  
}
