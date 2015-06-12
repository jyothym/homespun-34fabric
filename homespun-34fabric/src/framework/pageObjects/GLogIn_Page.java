package framework.pageObjects;

import org.openqa.selenium.*;
import framework.utilities.Browser;

public class GLogIn_Page extends Browser {
		static By txtusername = By.id("log");
	
       public static void set_UserName(String username){
    	    driver.findElement(txtusername).sendKeys(username);
        }

       public static void set_Password(String password){
    	   driver.findElement(By.id("pwd")).sendKeys(password);
       }

       public static void LogIn(){
    	   driver.findElement(By.id("login")).click();
       }
}
