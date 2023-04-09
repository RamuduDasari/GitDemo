package page_object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configurations.Driver;

public class LoginPage extends Driver {

	@FindBy(xpath = "//a[@id='login-link']")
	public WebElement lnkLogin;
	@FindBy(xpath = "//input[@type='text']")
	public WebElement txtusername;
	@FindBy(xpath = "//input[@type='password']")
	public WebElement txtpassword;
	@FindBy(xpath = "//span[text()='Submit']")
	public WebElement btnsubmmit;
	@FindBy(xpath = "//a[@id='logout-trigger']")
	public WebElement btnlogout;
	@FindBy(xpath = "//div[contains(text(),'The given name / password are incorrect. Please, t')]")
	public WebElement txtnotifmsg;
	public String locator = "//div[contains(text(),'The given name / password are incorrect. Please, t')]";
	@FindBy(xpath = "//span[contains(text(),'×')]")
	public WebElement alrtclosebutton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void fillLogin(String username, String password) {
		lnkLogin.click();
		txtusername.sendKeys(username);
		txtpassword.sendKeys(password);
		btnsubmmit.click();

	}
}
