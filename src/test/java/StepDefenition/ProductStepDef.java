package StepDefenition;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObject.AddNewCustomerPage;
import PageObject.AddProduct;
import PageObject.DeleteProduct;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ProductStepDef extends BaseClass{
	
	
	AddProduct addProductPage = new AddProduct(driver);
	DeleteProduct deleteProductPage = new DeleteProduct(driver);
	
	
	@When("Click on Catalog And Product")
	public void click_on_catalog_and_product() {
		addProductPage.clickOnCatalog();
		addProductPage.clickOnProductLink();
	}
	@When("Click on Add new Product button")
	public void click_on_add_new_product_button() {
	 addProductPage.clickOnaddNewProductBtn();
	}


	@When("Enter Product Name {string}")
	public void enter_product_name(String string) {
		addProductPage.enterProductName(string);
	}

	@When("Enter Product Description")
	public void enter_product_description() {
		addProductPage.enterProductDesc("This is Weedicide");
	}


	@When("Click on Save button")
	public void click_on_save_button1() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addProductPage.clickOnSave();
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message1(String expectedMsg) {
		
	  String actualMsg= addProductPage.succProdAddMsg();
	 
	  if(actualMsg.contains(expectedMsg))
	  {
		  Assert.assertTrue(true);
	  }else
	  {
		  Assert.assertTrue(false);
	  }
	}
		
	

	@When("Click on Search icon")
	public void click_on_search_icon() {
		deleteProductPage.clickOnSearchIcon();
		
	}
	
	@When("Enter Search Product Name {string}")
	public void enter_search_product_name(String productName) {
	  deleteProductPage.enterProductName(productName);
	}

	@When("Click on Search button")
	public void click_on_search_button() {
		deleteProductPage.clickOnSearchButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("user should search Product name is search table")
	public boolean user_should_search_product_name_is_search_table() {
	
		String expectedName = "Gramaxone"; 
		
		if(deleteProductPage.searchProductName(expectedName)==true)
		{		
			return true;
			
			
		}else
		{
			
			return false;
			
			
		}
		
		
	}
	

	@When("Click on Select CheckBox")
	public void click_on_select_check_box() {
		
			if(user_should_search_product_name_is_search_table()==true)
			{
				deleteProductPage.selectAllCheckBox();
			}else
			{
				Assert.assertFalse("product Name not found", false);
			}
	}

	@When("Click on Delete button")
	public void click_on_delete_button() {
	deleteProductPage.clickOnDeleteButton();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@When("Click on Confirm Delete")
	public void click_on_confirm_delete() {
     deleteProductPage.clickDeleteConfirmOkButton();
     try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	}
	
	@Then("Delete Confirm message {string}")
	public void delete_confirm_message(String expectedConfMsg) {
		System.out.println("shikari"+deleteProductPage.deleteConfirmMsg());
		if(deleteProductPage.deleteConfirmMsg().equals(expectedConfMsg))
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}
	   
	}

	
	
}
