package framework.pageObjects;

import org.openqa.selenium.By;
import framework.utilities.Browser;

public class GHome_Page extends Browser{

	public static void SignIn(){
		driver.findElement(By.id("account")).sendKeys();;
	}

	public static void LogOut(){
		driver.findElement(By.id("account_logout")).click();
		
	}
}