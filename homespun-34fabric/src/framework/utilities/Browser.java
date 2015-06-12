package framework.utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browser {	
	public static WebDriver driver = Browser.getDriverInstance();
	
	public static WebDriver getDriverInstance() {
		String browser = Constant.Browser;
		
		if (browser.equals("firefox")) {
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			driver = new FirefoxDriver(capability);

		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			driver = new ChromeDriver(capability);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constant.BaseURL);
		return driver;
	}

}
