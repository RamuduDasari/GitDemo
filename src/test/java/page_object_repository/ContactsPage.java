package page_object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//div[contains(text(),'Contacts')]") public WebElement lnkcontancts;
	@FindBy(xpath="//ul[@class='pagination']/li[@class='pagination-next page-item']") public WebElement arrnextpage;
	@FindBy(xpath="//format-field-value[contains(text(),'test33')]") public WebElement lnkselectuser;
	@FindBy(xpath="//div[contains(text(),'Make payment')]") public WebElement lnkpayment;
	//Elements of Pay user page
	@FindBy(xpath="//div[@class='d-flex label-value-value']/div[@class='input-group']/input[@type='tel']") public WebElement txtamount ;
	@FindBy(xpath="//span[contains(text(),'Next')]") public WebElement btnnext;
	@FindBy(xpath = "//button/span[text()='Confirm']") public WebElement btnconfirm;
	@FindBy(xpath = "//div[text()='The payment was successfully processed']") public WebElement textConfirmation ;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
