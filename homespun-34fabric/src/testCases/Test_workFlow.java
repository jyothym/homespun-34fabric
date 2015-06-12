package testCases;

import framework.pageObjects.Home_Page;
import framework.utilities.*;
import framework.workFlows.SignIn;

public class Test_workFlow extends Browser{
	public static void main(String[] args) {

		// Use work flows library now
        SignIn.Execute(Constant.Username, Constant.Password); 
        System.out.println("Login Successfully, now it is the time to Log Off buddy."); 
        Home_Page.lnk_LogOut().click();
       driver.quit();
     }
}