package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProduct {
	
	public WebDriver ldriver;
	
	public DeleteProduct(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//div[@class='search-text']")
	WebElement prodSearchIcon;
	
	@FindBy(xpath="//input[@name='SearchProductName']")
	WebElement productName;
	
	@FindBy(xpath="//button[@id='search-products']")
	WebElement prodSearchButton;
	
	@FindBy(xpath="//table[@id='products-grid']/tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath="//div[@class='dataTables_scrollHeadInner']//input[@type='checkbox']")
	WebElement selAllCheckBox;
	
	@FindBy(xpath="//button[@id=\"delete-selected\"]")
	WebElement deleteBtn;
	
	@FindBy(xpath="//button[@id='delete-selected-action-confirmation-submit-button']")
	WebElement deleteConfOkBtn;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement deleteConfirmMessage;
	
	public void clickOnSearchIcon()
	{
		if(prodSearchButton.isDisplayed()!=true)
		prodSearchIcon.click();
	}
	
	public void enterProductName(String prodName)
	{
		productName.sendKeys(prodName);
	}
	
	public void clickOnSearchButton()
	{
		prodSearchButton.click();
	}
	
	public boolean searchProductName(String name)
	{
		boolean found = false;

		//total no. of rows in a grid
		int ttlRows = tableRows.size();
		for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
		{
			WebElement webElementName = ldriver.findElement(By.xpath("//table[@id='products-grid']//tbody/tr[" + i  + "]/td[3]"));
			String actualName = webElementName.getText();
			  if(actualName.equalsIgnoreCase(name))
			{
				found=true;
				break;
			}

		}

		return found;

	}
	
	public void selectAllCheckBox()
	{
		selAllCheckBox.click();
	}
	
	public void clickOnDeleteButton()
	{
		deleteBtn.click();
	}
	
	public void clickDeleteConfirmOkButton()
	{
		deleteConfOkBtn.click();
	}
	public String deleteConfirmMsg()
	{
		String msg= deleteConfirmMessage.getText();
		return msg;
	}
	
}
