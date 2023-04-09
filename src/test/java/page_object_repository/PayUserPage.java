package page_object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayUserPage {
	
	@FindBy(xpath="//div[text()=' Pay user ']") public WebElement  lnkpayuser;
	@FindBy(xpath="//div[@class='d-flex']/button") public WebElement btnlistofusers;
	@FindBy(xpath ="//div/a[text()=' Badar Mohamed Moumin ']") public WebElement selectuser;
	@FindBy(xpath="//div[@class='d-flex label-value-value']/div[@class='input-group']/input[@type='tel']") public WebElement txtamount ;
	@FindBy(xpath="//span[contains(text(),'Next')]") public WebElement btnnext;
	@FindBy(xpath = "//button/span[text()='Confirm']") public WebElement btnconfirm;
	@FindBy(xpath = "//div[text()='The payment was successfully processed']") public WebElement textConfirmation ;
	
	
	public PayUserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
