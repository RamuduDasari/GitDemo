package cse_testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import configurations.Driver;
import configurations.ExcelUtils;
import page_object_repository.LoginPage;
import page_object_repository.PayUserPage;

public class PayUserFunctionality extends Driver {

	@Test
	public void checkPayUserFunctionality() throws Exception {
		try {
		LoginPage loginpage = new LoginPage(driver);
		PayUserPage payuserpage = new PayUserPage(driver);
		ExcelUtils excel = new ExcelUtils(excelpath,"Sheet1");
		
		// Load webpage
		driver.get(url);
		// login to the application
		loginpage.fillLogin(excel.getCellData(1, 0), excel.getCellData(1, 1));
		// Click on Pay user Modulue
		payuserpage.lnkpayuser.click();
		// click on user contacts list button
		payuserpage.btnlistofusers.click();
		// select user from contact list
		payuserpage.selectuser.click();
		// Enter amount
		payuserpage.txtamount.sendKeys("200");
		Thread.sleep(3000);
		// click on next button
		payuserpage.btnnext.click();
		// click on confirm button
		payuserpage.btnconfirm.click();
		// verify confirmation messsage
		assertTrue(payuserpage.textConfirmation.isDisplayed());
		}catch(Exception e) {
			String failedTestCase = "checkPayUserFunctionality";
			takeScreenshot(failedTestCase);
			
			Assert.fail();
		}
	}

	@BeforeMethod
	public void setup() {
		// launch browser
		launchBrowser(null);
	}

	@AfterMethod
	public void tearDown() {
		// kill browser
		closeBrowser();
	}

}
