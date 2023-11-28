package StepDefenition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


/* child class of Base class*/
public class StepDef extends BaseClass{
	


	@Before
	public void setup()
	{
		
		// initilaize readConfig
		readConfig = new ReadConfig();
		// initialize logger
		log = LogManager.getLogger("StepDef");				
		System.out.println("setup() method executed");
		String loadBrowser = readConfig.getBrowser();
		
		//launch browser
		switch(loadBrowser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
		log.fatal("Setup1 executed...");
	}

	/*@Before("@Sanity")
	public void setup1()
	{
		log = LogManager.getLogger("StepDef");				
		System.out.println("setup() method executed....");
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  log.info(" Browser Setup for Sanity Testing is Executed....");
	}*/


	/////////// Login ///////////////
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		loginpage = new LoginPage(driver);
		addNewCustpage = new AddNewCustomerPage(driver);
		searchCustPage = new SearchCustomerPage(driver);
		driver.manage().window().maximize();
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("URL opened...");

	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {

		loginpage.enterEmail(emailadd);
		loginpage.enterPassword(password);
		log.info("email and password entered...");
	}

	@When("Click on Login")
	public void click_on_login() {

		loginpage.clickOnLogonBtn();
		log.info("Clicked On Login Button...");
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {

		loginpage.clickOnLogoutBtn();
		log.info("Clicked on logout Button....");
	}

	@Then("error message is {string}")
	public void error_message_is(String expectedErrorMsg) {
	 String actualErrorMsg = loginpage.invalidCredentials();
	  if(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg))
	  {
		  Assert.assertTrue(true);
	  }else
	  {
		  Assert.assertTrue(false);
	  }
	}


	////////////Add new Customer /////////////
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		String actualTitle = addNewCustpage.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		Assert.assertEquals(expectedTitle, actualTitle);
		log.info("DashBoard is Verified......");
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		addNewCustpage.clickOnCustomersMenu();
		log.info("Clicked on Customers Menu....");
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		addNewCustpage.clickOnCustomersMenuItem();
		log.info("Clicked on Customer Menu Item.....");
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustpage.clickOnAddnew();
		log.info("Clicked on Add new Button....");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustpage.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		//addNewCustpage.enterEmail("shivaraj.yadachi321@hotmail.com");
		addNewCustpage.enterEmail(generateEmailId()+"@gmail.com");
		addNewCustpage.enterPassword("test1");
		addNewCustpage.enterFirstName("Shivaraj");
		addNewCustpage.enterLastName("Yadachi");
		addNewCustpage.enterGender("male");
		addNewCustpage.enterDob("8/12/1984");
		addNewCustpage.enterCompanyName("No Company");
		addNewCustpage.enterAdminContent("admin content");
		addNewCustpage.enterManagerOfVendor("Vendor 1");
		log.info("Customer Informations Entered....");

	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustpage.clickOnSave();
		log.info("Clicked on Save Button");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfMsg) {

		String actualConfmsg = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissable\"]")).getText();
		if(actualConfmsg.contains(expectedConfMsg))
		{
			Assert.assertTrue(true);
			log.info("Customer  saved successfully");
		}else
		{
			Assert.assertTrue(false);
			log.warn("TEST FAILED:Customer NOT saved successfully");
		}

	}

	//////Search customer page by email ///////////////

	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		searchCustPage.enterEmailAddress("victoria_victoria@nopCommerce.com");
		log.info("Entered email address....");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchCustPage.clickOnCustSearchBtn();

	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmailAddress = "victoria_victoria@nopCommerce.com";
		Assert.assertTrue(searchCustPage.searchCustomerByEmail(expectedEmailAddress));
		log.info("Email Searched Successfully....");

	}


	////////// search customer by name /////////////////
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchCustPage.enterFirstName("Shivaraj");
		log.info("First Name entered....");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCustPage.enterLastName("Yadachi");
		log.info("last Name entered....");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Shivaraj Yadachi";
		if(searchCustPage.searchCustomerName(expectedName)==true)
		{
			log.info("Passed Name search");
			Assert.assertTrue(true);
		}else
		{
			log.warn("TEST FAILED: Name not available");
			Assert.assertTrue(false);
		}
	}

	/*@After
	public void tearDown(Scenario sc) throws IOException
	{
		System.out.println("TearDown Method() executed");
		if(sc.isFailed())
		{
			String filePath = "C:\\workspace\\CucumberFrameWork\\Screenshots\\Failed.png";
			TakesScreenshot takeScreenShot = ((TakesScreenshot)driver);
			// Call getScreenShotAs method to create Image File
			File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
			// Move Image file to new Destination file 
			File destinationFile = new File(filePath);
			//Copy File to utils
			FileUtils.copyFile(sourceFile, destinationFile);
		}
		driver.quit();
	}*/

	@AfterStep
	public void addScreenShot(Scenario scenario)
	{
		if(scenario.isFailed()) {
			final byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			// attach image file report(data,mediaType,name of the attachment)
			scenario.attach(screenShot,"image/png" ,scenario.getName());
		}

	}
}

