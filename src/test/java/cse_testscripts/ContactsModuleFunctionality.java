package cse_testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import configurations.Driver;
import page_object_repository.ContactsPage;
import page_object_repository.LoginPage;

public class ContactsModuleFunctionality extends Driver {

	@Test
	public void checkContanctsFunctionality() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		ContactsPage contactspage = new ContactsPage(driver);

		// Load webpage
		driver.get(url);
		// login to the application
		loginpage.fillLogin("demo", "1234");
		// verify login page title
		assertEquals(driver.getTitle(), "Login - Cyclos");
		// Click on contacts link
		contactspage.lnkcontancts.click();
		// go to next page by clicking arrow next page at the downside of page
		contactspage.arrnextpage.click();
		// Select any user
		contactspage.lnkselectuser.click();
		// click on make payments
		contactspage.lnkpayment.click();
		// Enter amount
		contactspage.txtamount.sendKeys("200");
		// click on next button
		contactspage.btnnext.click();
		// click on confirm button
		contactspage.btnconfirm.click();
		// click on success message
		// assertTrue(contactspage.textConfirmation.isDisplayed());

	}

//	@BeforeMethod
//	public void setUP() {
//		// launch browser
//		launchBrowser();
//	}
//
//	@AfterMethod
//	public void tearDown() {
//		// close browser
//		closeBrowser();
//	}
}
