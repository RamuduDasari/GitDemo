package page_object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyVocchurPage {
	@FindBy(xpath = "//div[contains(text(),'My vouchers')]")
	public WebElement lnkmyvochure;
	@FindBy(xpath = "//div[contains(text(),'Search vouchers')]")
	public WebElement titsearchvochure;
	@FindBy(xpath = "//label[contains(text(),'Bought')]")
	public WebElement radbtnbought;
	@FindBy(xpath = "//div/table[@class='table table-hover cursor-pointer']/tbody/tr[1]/td[2]")
	public WebElement tabfirrowfirelement;
	@FindBy(xpath = "//div[starts-with(@class, 'qr-container image d-flex justify')]/img[@alt='QR-code']")
	public WebElement imgqrcode;

	public MyVocchurPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
