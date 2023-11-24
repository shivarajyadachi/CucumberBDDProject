package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="SearchEmail")
	WebElement emailAddress;
	
	@FindBy(id="search-customers")
	WebElement searchCustBtn;
	
	@FindBy(xpath="//table[@role='grid']")
	WebElement searchResult;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(id="SearchFirstName")
	WebElement firstName;

	@FindBy(id="SearchLastName")
	WebElement lastName;
	
	
	
	//action method to perform click action on search button
	public void clickOnCustSearchBtn() 
	{
		searchCustBtn.click();
		
	}
	
	
//////// search customer by name //////////////
	//action method to enter first name
		public void enterFirstName(String firstNameText)
		{
			firstName.sendKeys(firstNameText);
		}

		//action method to enter last name
		public void enterLastName(String LastNameText)
		{
			lastName.sendKeys(LastNameText);
		}
	
		public boolean searchCustomerName(String name)
		{
			boolean found = false;

			//total no. of rows in a grid
			int ttlRows = tableRows.size();
			for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
			{
				WebElement webElementName = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[3]"));
				String actualName = webElementName.getText();
				
				if(actualName.equals(name))
				{
					found=true;
					break;
				}

			}

			return found;

		}

		
		
		
		
		
////////// Search customer by email////////////////
		//action method to enter email address
		public void enterEmailAddress(String email)
		{
			emailAddress.sendKeys(email);
		}
		
	public boolean searchCustomerByEmail(String email)
	{
		boolean found = false;

		//total no. of rows in a grid
		int ttlRows = tableRows.size();


		//total no. of columns
		//int ttlColumns = tableColumns.size();

		for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
		{
			

			WebElement webElementEmail = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[2]"));
			String actualEmailAdd = webElementEmail.getText();
			
			if(actualEmailAdd.equals(email))
			{
				found=true;
				break;
			}

		}

		return found;

	}

}
