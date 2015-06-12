package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import framework.utilities.ReadExcel;

public class Test_DataProviderExcel {
	WebDriver driver;
	
	@DataProvider(name = "DP2")
	public Object[][] readXLSData() throws Exception {
		ReadExcel ex = new ReadExcel();
		Object[][] retObjArr = ex.getTableArray("/src/testdata/data1.xls", "DataPool", "imdbTestData1");
		return(retObjArr);
	}	

	@BeforeClass
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		driver = new ChromeDriver(capability);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.imdb.com/");
	}
	
	@Test (dataProvider = "DP2")
	public void testDataProviderExample(String movieTitle,String directorName, String moviePlot, String actorName) throws Exception {

	    //enter the movie title
	    driver.wait(30000);
		driver.findElement(By.id("navbar-query")).clear();
		driver.findElement(By.id("navbar-query")).sendKeys(movieTitle);
	    driver.findElement(By.id("navbar-submit-button")).click();
	    driver.wait(30000);
	    
	    //click on the movie title in the search result page
	    driver.findElement(By.linkText(movieTitle)).click();
	    driver.wait(30000);
	
	    //verify director name is present in the movie details page
	    String name = driver.findElement(By.name(directorName)).getText();
	    Assert.assertEquals(name, directorName);
	        
	    //verify movie plot is present in the movie details page
	    String plot = driver.findElement(By.name(moviePlot)).getText();
	    Assert.assertEquals(plot, moviePlot);
	    
	    //verify movie actor name is present in the movie details page
	    String actor = driver.findElement(By.name(actorName)).getText();
	    Assert.assertEquals(actor, actorName);
	}

	@AfterClass
    public void tearDown(){
        driver.quit();
    } 
}