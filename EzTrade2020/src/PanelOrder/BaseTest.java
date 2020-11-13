package PanelOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	public static void setUpBeforeTest(WebDriver driver, String URL) {
		System.setProperty("webdriver.chrome.driver", "E:\\downsload\\selenium\\chromedriver_win32_85\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
	}
}
