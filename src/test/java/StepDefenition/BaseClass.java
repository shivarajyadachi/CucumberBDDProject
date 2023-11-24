package StepDefenition;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;


/* Parent Class */
public class BaseClass {

	public static WebDriver driver;
	public LoginPage loginpage;
	public AddNewCustomerPage addNewCustpage;
	public SearchCustomerPage searchCustPage;
	public static Logger log;
	public ReadConfig readConfig;
	// Generate unique emailId
	public String generateEmailId()
	{
		return RandomStringUtils.randomAlphabetic(5);

	}

}
