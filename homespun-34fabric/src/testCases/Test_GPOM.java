package testCases;

import framework.pageObjects.GHome_Page;
import framework.pageObjects.GLogIn_Page;
import framework.utilities.Browser;
import framework.utilities.Constant;

public class Test_GPOM extends Browser{
  public static void main(String[] args) {

    // Use page Object library now
    GHome_Page.SignIn();
    GLogIn_Page.set_UserName(Constant.Username);
    GLogIn_Page.set_Password(Constant.Password);
    GLogIn_Page.LogIn();
    System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
    GHome_Page.LogOut();
    driver.quit();
    }
}


