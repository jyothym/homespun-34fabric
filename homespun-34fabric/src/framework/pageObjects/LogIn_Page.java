package framework.pageObjects;

import org.openqa.selenium.*;
import framework.utilities.Browser;

public class LogIn_Page extends Browser {
	
       public static WebElement txtbx_UserName(){
    	   return driver.findElement(By.id("log"));
        }
       public static WebElement txtbx_Password(){
    	   return driver.findElement(By.id("pwd"));
       }
       public static WebElement btn_LogIn(){
    	   return driver.findElement(By.id("login"));
       }
}
