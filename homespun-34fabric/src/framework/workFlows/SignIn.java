package framework.workFlows;

import framework.pageObjects.Home_Page;
import framework.pageObjects.LogIn_Page;
import framework.utilities.Browser;

public class SignIn extends Browser {
	public static void Execute(String sUsername, String sPassword) {
		Home_Page.lnk_SignIn().click();
		LogIn_Page.txtbx_UserName().sendKeys(sUsername);
		LogIn_Page.txtbx_Password().sendKeys(sPassword);
		LogIn_Page.btn_LogIn().click();
	}
}
