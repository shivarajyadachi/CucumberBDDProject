package StepDefenition;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import PageObject.AddNewCustomerPage;
import PageObject.AddProduct;
import PageObject.DeleteProduct;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;


/* Parent Class */
public class BaseClass {

	public static WebDriver driver;
	public LoginPage loginpage;
	public AddNewCustomerPage addNewCustpage;
	public SearchCustomerPage searchCustPage;
	public AddProduct addProductPage;
	public DeleteProduct deleteProductPage;
	public static Logger log;
	public ReadConfig readConfig;
	
	
	
	// Generate unique emailId
	public String generateEmailId()
	{
		return RandomStringUtils.randomAlphabetic(5);

	}
	public void selectDropDownList(WebElement ele,String value)
	{
		Select sel = new Select(ele);
		sel.selectByVisibleText(value);
	}
	
	public void launchBrowser()
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
	
}
