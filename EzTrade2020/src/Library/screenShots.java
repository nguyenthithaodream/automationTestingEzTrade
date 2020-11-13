package Library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShots {
	public static void captureScreenShot (WebDriver driver, String screenshotName) {
		
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShots/"+screenshotName+".png"));
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		
		
	}
}
