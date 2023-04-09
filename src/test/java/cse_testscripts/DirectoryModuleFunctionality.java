package cse_testscripts;

import org.testng.annotations.Test;

import configurations.Driver;
import page_object_repository.DirectoryPage;
import page_object_repository.LoginPage;

public class DirectoryModuleFunctionality extends Driver {

	@Test
	public void checkDirectryFunctionality() {

		LoginPage loginpage = new LoginPage(driver);
		DirectoryPage directorypage = new DirectoryPage(driver);

		// launch Webpage
		driver.get(url);
		// login to the application
		loginpage.fillLogin("demo", "1234");
		// click on Directory module link
		directorypage.lnkdirectory.click();
		// select list view of directroy results
		directorypage.btnlistview.click();
		// click on order by button
		directorypage.btnorderby.click();
		// select option order by name(a-z)
		directorypage.optorderbyname.click();
		// select table first row first element
		directorypage.tabfirrowseccolumn.click();
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
