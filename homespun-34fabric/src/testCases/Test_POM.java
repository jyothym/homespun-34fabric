package testCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import framework.pageObjects.Home_Page;
import framework.pageObjects.LogIn_Page;
import framework.utilities.Browser;
import framework.utilities.Constant;

public class Test_POM extends Browser{
  public static void main(String[] args) throws Exception{

    // Use page Object library now
    Home_Page.lnk_SignIn().click();
    LogIn_Page.txtbx_UserName().sendKeys(Constant.Username);
    LogIn_Page.txtbx_Password().sendKeys(Constant.Password);
    LogIn_Page.btn_LogIn().click();
    System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
    Home_Page.lnk_LogOut().click(); 
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    System.out.println(System.getProperty("user.dir") + "//data//CaptureScreenshot//google.jpg");
    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "//data//CaptureScreenshot//google.jpg"));
    driver.quit();
    }
}

