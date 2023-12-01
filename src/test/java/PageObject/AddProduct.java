package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {
	public WebDriver ldriver;
	
	public AddProduct(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-book']/following-sibling::p")
	WebElement catalog;
	
	@FindBy(xpath="//a[@href='/Admin/Product/List']/p")
	WebElement productLink;
	
	@FindBy(xpath="//a[@class='btn btn-primary']/i")
	WebElement addNewProductBtn;
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement productName;
	
	@FindBy(xpath="//textarea[@name='ShortDescription']")
	WebElement shortDescription;
	
	@FindBy(xpath="//select[@id='ParentCategoryId']")
	WebElement parentCategory;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//button[@type='button' and @class='close' and @data-dismiss='alert']/..")
	WebElement successProdAddMsg;
	
	public void clickOnCatalog()
	{
		catalog.click();
	}
	public void clickOnProductLink()
	{
		productLink.click();
	}
	public void clickOnaddNewProductBtn()
	{
		addNewProductBtn.click();
	}
	
	public void enterProductName(String prodName)
	{
		productName.sendKeys(prodName);
	}
	
	public void enterProductDesc(String prodDescrip)
	{
		shortDescription.sendKeys(prodDescrip);
	}
	
	public void clickOnSave()
	{
		saveBtn.click();
	}
	
	public String succProdAddMsg()
	{
		
		String msg= successProdAddMsg.getAttribute("textContent");
		return msg;
	}
	
	public WebElement getParentCategoryElement()
	{
		WebElement ele = parentCategory;
		return ele;
	}
}
