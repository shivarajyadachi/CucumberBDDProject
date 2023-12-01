package StepDefenition;

import org.junit.Assert;

import PageObject.AddProduct;
import PageObject.Category;
import io.cucumber.java.en.*;

public class DeleteCategory extends BaseClass{
	
	Category categoryPage = new Category(driver);
	AddProduct addProductPage = new AddProduct(driver);
	
	@When("select the category to be deleted {string}")
	public void select_the_category_to_be_deleted(String name) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		categoryPage.selectCategoryToBeDeleted(name);
		 
	}

	@When("click on delete selected button")
	public void click_on_delete_selected_button() {
		categoryPage.deleteSelectedCategory();
	}

	@When("confirm delete yes button")
	public void confirm_delete_yes_button() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		categoryPage.clickOnYesButton();
	}

	@Then("confirm category deleted")
	public void confirm_category_deleted() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectedResult = "No data available in table";
		String actualResult=categoryPage.confirmCategoryDeleted();
		if(actualResult.contains(expectedResult))
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}
	}

}
