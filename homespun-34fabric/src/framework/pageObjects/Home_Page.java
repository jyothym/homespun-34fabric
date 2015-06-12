package framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import framework.utilities.Browser;

public class Home_Page extends Browser {

	public static WebElement lnk_SignIn(){
		return driver.findElement(By.id("account"));
	}
	public static WebElement lnk_LogOut(){
		return driver.findElement(By.id("account_logout"));
	}
}