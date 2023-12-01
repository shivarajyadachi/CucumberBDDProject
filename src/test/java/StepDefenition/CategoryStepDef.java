package StepDefenition;

import java.awt.AWTException;

import org.junit.Assert;
import org.junit.experimental.categories.Categories;

import PageObject.AddProduct;
import PageObject.Category;
import PageObject.DeleteProduct;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CategoryStepDef extends BaseClass{
	
    
	Category categoryPage = new Category(driver);
	AddProduct addProductPage = new AddProduct(driver);
	
	@When("Click on Catalog And Category")
	public void click_on_catalog_and_category() {
		addProductPage.clickOnCatalog();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		categoryPage.clickOnCategoryLink();
		
	}

	@When("Click on AddNew Category button")
	public void click_on_add_new_category_button() {
	  categoryPage.clickOnAddCategoryBtn();
	}

	@When("enter Catergory Name {string}")
	public void enter_catergory_name(String name) {
	 
		categoryPage.enterCatergoryName(name);
	}
	
	@When("select parent category from dropDownList {string}")
	public void select_parent_category_from_drop_down_list(String val) {
		categoryPage.parentCategory().click();
	   selectDropDownList(categoryPage.parentCategory(), val);
	   try {
		Thread.sleep(3000);
	   } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	}
	
	@When("click on upload file button")
	public void click_on_upload_file_button() throws AWTException {
	  categoryPage.clickOnUploadFile();
	}
	@When("click on save button")
	public void click_on_save_button() {
	    categoryPage.saveCategory();
	}

	@Then("confirm successful message {string}")
	public void confirm_successful_message(String expMsg) {
		
	   String actMsg=categoryPage.confirmCatAddSuccess();
	   System.out.println("shikari"+actMsg);
	   if(actMsg.contains(expMsg))
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
	}


}
