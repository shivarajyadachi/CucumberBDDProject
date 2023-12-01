package PageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefenition.BaseClass;
import junit.framework.Assert;


public class Category extends BaseClass {
	
	public WebDriver ldriver;
	
	public  Category(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(xpath="//a[@href='/Admin/Category/List']//p")
	WebElement categoryLink;
	
	public void clickOnCategoryLink()
	{
		categoryLink.click();
	}
	
	@FindBy(xpath="//a[@href='/Admin/Category/Create']//i")
	WebElement addNewCategoryBtn;
	
	public void clickOnAddCategoryBtn()
	{
		addNewCategoryBtn.click();
	}
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement categoryName;
	
	public void enterCatergoryName(String catName)
	{
		categoryName.sendKeys(catName);
	}
	
	@FindBy(xpath="//select[@id='ParentCategoryId']")
	WebElement parentcategory;
	
	public WebElement parentCategory()
	{
		WebElement ele = parentcategory;
		return ele;
	}
	
	@FindBy(xpath="//button[@name='save']//i[@class='far fa-save']")
	WebElement saveCatergoryBtn;

	public void saveCategory()
	{
		saveCatergoryBtn.click();
	}
	
	@FindBy(xpath="//div[contains(text(),'Upload a file')]")
	WebElement uploadFileBtn;
		

	public void clickOnUploadFile() throws AWTException
	{
		
		Actions action =new Actions(driver);
		action.moveToElement(uploadFileBtn).click().build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Robot rb = new Robot();
		 
		 StringSelection str = new StringSelection("C:\\workspace\\CucumberFrameWork\\TestDataFiles\\slambook.jpeg");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
		     // press Contol+V for pasting
		     rb.keyPress(KeyEvent.VK_CONTROL);
		     rb.keyPress(KeyEvent.VK_V);
		 
		    // release Contol+V for pasting
		    rb.keyRelease(KeyEvent.VK_CONTROL);
		    rb.keyRelease(KeyEvent.VK_V);
		 
		    // for pressing and releasing Enter
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	WebElement confirmCategoryAddSuccessMsg;
	
	public String confirmCatAddSuccess()
	{
		String msg=confirmCategoryAddSuccessMsg.getText();
		return msg;
	}
	
	@FindBy(xpath="//input[@id='SearchCategoryName']")
	WebElement searchCategoryName;

	public void enterCategoryNameforSearch(String name)
	{
		searchCategoryName.sendKeys(name);
	}
	
	@FindBy(xpath="//button[@id='search-categories']")
	WebElement searchCategoryIcon;
	
	public void clickOnSearchCategoryIcon()
	{
		searchCategoryIcon.click();
	}
	
	@FindBy(xpath="//table[@id='categories-grid']/tbody/tr")
	List<WebElement> tableRows;
	
	
	public boolean searchCategory(String name)
	{
		boolean found=false;
		for(int i=1;i<=tableRows.size();i++)
		{
			WebElement ele = driver.findElement(By.xpath("//table[@id='categories-grid']/tbody/tr[" +i +"]/td[2]"));
			String msg = ele.getText();
			if(msg.contains(name))
			{
				found=true;
				break;
			}
		}
		return found;
	}
	
	public void selectCategoryToBeDeleted(String name)
	{
		
		for(int i=1;i<=tableRows.size();i++)
		{
			WebElement ele = driver.findElement(By.xpath("//table[@id='categories-grid']/tbody/tr[" +i +"]/td[2]"));
			String msg = ele.getText();
			if(msg.contains(name))
			{
				WebElement selectCheckBox = driver.findElement(By.xpath("//table[@id='categories-grid']/tbody/tr[" +i +"]/td[1]"));
				selectCheckBox.click();
			}else
			{
				Assert.assertTrue("Element not available", false);
			}
		}
				
	}
	
	@FindBy(xpath="//button[@id='delete-selected']//i")
	WebElement deleteSelectedBtn;
	public void deleteSelectedCategory()
	{
		deleteSelectedBtn.click();
	}
	
	@FindBy(xpath="//button[@id='delete-selected-action-confirmation-submit-button']")
	WebElement yesBtn;
	public void clickOnYesButton()
	{
		yesBtn.click();
	}
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement confCatDeleted;
	public String confirmCategoryDeleted()
	{
		String result = confCatDeleted.getText();
		return result;
	}
}
	
