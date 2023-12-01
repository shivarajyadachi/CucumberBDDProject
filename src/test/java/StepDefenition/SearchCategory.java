package StepDefenition;

import org.junit.Assert;

import PageObject.AddProduct;
import PageObject.Category;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchCategory extends BaseClass{
	
	Category categoryPage = new Category(driver);
	AddProduct addProductPage = new AddProduct(driver);
	
	@When("enter Catergory Name for search {string}")
	public void enter_catergory_name_for_search(String name) {
		driver.navigate().refresh();
		categoryPage.enterCategoryNameforSearch(name);

	}

	@When("click on search icon")
	public void click_on_search_icon() {
	  categoryPage.clickOnSearchCategoryIcon();
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Then("confirm categoy is available")
	public void confirm_categoy_is_available() {
		String expected="SlamBook";
		boolean result=categoryPage.searchCategory(expected);
		System.out.println("shikari"+result);
		if(result==true)
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}
	}


}
