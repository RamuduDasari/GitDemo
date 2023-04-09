package configurations;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Driver {

	public static WebDriver driver;
	//public static String browser = "GC";
	public static String url = "https://demo.cyclos.org/ui/home";
	public static String excelpath="H:\\Selenium_Scripts_Mar2023\\CseProject\\src\\test\\resources\\testdata\\cse_proj_testdata.xlsx";

    @BeforeMethod
	@Parameters("browser")
	public static void launchBrowser(String browser) {
		// launch Firefox browser
		if (browser.equalsIgnoreCase("FF"))
		{
			driver = new FirefoxDriver();
		}
		// launch Chrome browser
		else if (browser.equalsIgnoreCase("GC"))
		{
			driver = new ChromeDriver();
		}
		// launch Internet Explorer browser
		else if (browser.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		// launch Edge browser
		else if (browser.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	
    @AfterMethod
	public void closeBrowser() {
		// close browser and its associated windows
		driver.quit();
	}
	
	public static void takeScreenshot(String failedTestCase) throws IOException {
		DateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy HH-mm-ss");
    	Date dt = new Date();
    	File scf = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scf, new File("H:\\Selenium_Scripts_Mar2023\\CseProject\\TakeScreenshot\\"+sdf.format(dt)+ " " + failedTestCase+".png"));
    	
	}
}
