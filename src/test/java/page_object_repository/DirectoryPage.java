package page_object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DirectoryPage {
	
	
	@FindBy(xpath="//div[contains(text(),'Directory')]") public WebElement lnkdirectory;
	@FindBy(xpath="//div[@role='radiogroup']/label[@class='btn btn-icon focusable resultType-list']") public WebElement btnlistview;
	@FindBy(xpath="//div/button[@title='Order by']") public WebElement btnorderby;
	@FindBy(xpath="//div[@role='listbox']/a[text()=' Name (A-Z) ']") public WebElement optorderbyname;
	@FindBy(xpath="//table[@class='table table-hover cursor-pointer']/tbody/tr[1]/td[2]") public WebElement tabfirrowseccolumn;
	
	
	
  public DirectoryPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

}
