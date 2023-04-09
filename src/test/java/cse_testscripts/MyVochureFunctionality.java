package cse_testscripts;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import configurations.Driver;
import configurations.ExcelUtils;
import page_object_repository.LoginPage;
import page_object_repository.MyVocchurPage;

public class MyVochureFunctionality extends Driver {
	// @Test(retryAnalyzer = MyRetry.class)
	@Test
	public void checkMyvocurefunctionality() throws Exception {
		try {
			LoginPage loginpage = new LoginPage(driver);
			MyVocchurPage vochurepage = new MyVocchurPage(driver);
			ExcelUtils excel = new ExcelUtils(excelpath, "Sheet1");
			// launch webPage
			driver.get(url);
			// login to the application
			loginpage.fillLogin(excel.getCellData(1, 0), excel.getCellData(1, 1));

			// click on my vochure link
			vochurepage.lnkmyvochure.click();

			// verify search vochure title
			assertTrue(vochurepage.titsearchvochure.isDisplayed());
			// Thread.sleep(3000);
			// click on bought radio button
			vochurepage.radbtnbought.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div/table[@class='table table-hover cursor-pointer']/tbody/tr[1]/td[2]")));

			// select first row first elements i.e Restaurant vochure
			vochurepage.tabfirrowfirelement.click();
			// Thread.sleep(3000);
			// verify Restaurant vocure title

			// verify qrcode dispalyed or not
			assertTrue(vochurepage.imgqrcode.isDisplayed());
		} catch (Exception e) {
			String failedTestCase = "checkMyvocurefunctionality";
			takeScreenshot(failedTestCase);
			Assert.fail();
		}
		

	}

//	@BeforeMethod
//	public void setup() {
//		launchBrowser();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//	}
//
//	@AfterMethod
//	public void tearDown() {
//		closeBrowser();
//	}

}
