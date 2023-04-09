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
import page_object_repository.DatabasePage;
import page_object_repository.LoginPage;

public class LoginFunctionality extends Driver {

	@Test

	public void checkLoginFucntionality() throws Exception {
		try {
			LoginPage loginpage = new LoginPage(driver);
			ExcelUtils excel = new ExcelUtils(excelpath, "Sheet1");
			DatabasePage dbconfig = new DatabasePage(driver);

			// Load Web page
			driver.get(url);

			// login with positive data
			// loginpage.fillLogin(excel.getCellData(1, 0), excel.getCellData(1, 1));

			dbconfig.loginData();
			// check logout button present or not
			assertTrue(loginpage.btnlogout.isDisplayed());
			// click on logout button
			loginpage.btnlogout.click();

			// check login button present or not
			assertTrue(loginpage.lnkLogin.isDisplayed());

			// login with negative data
			loginpage.fillLogin(excel.getCellData(2, 0), excel.getCellData(2, 1));

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginpage.locator)));

			// verify alert message
			assertTrue(loginpage.txtnotifmsg.isDisplayed());
			// close alert message
			loginpage.alrtclosebutton.click();
		} catch (Exception e) {
			String failedTestCase = "LoginFunctionality";
			takeScreenshot(failedTestCase);
			Assert.fail();
		}
	}

//	@BeforeMethod
//	public void setup() {
//		launchBrowser();
//
//	}
//
//	@AfterMethod
//	public void tearDown() {
//		closeBrowser();
//	}

}
