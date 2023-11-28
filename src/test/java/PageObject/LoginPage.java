package PageObject;




import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	WebDriver ldriver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		wait= new WebDriverWait(rdriver, Duration.ofSeconds(10));

	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement LoginBtn;
	
	@FindBy(linkText="Logout")
	WebElement logoutBtn;
	
	@FindBy(xpath="//ul/parent::div")
	WebElement errorMessage;
	
	public void enterEmail(String emailAddress)
	{
		email.clear();
		email.sendKeys(emailAddress);
	}
	
	public void enterPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickOnLogonBtn()
	{
		LoginBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickOnLogoutBtn()
	{
		logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
		logoutBtn.click();
		
	}
	public String invalidCredentials()
	{
		String msg= errorMessage.getText();
		return msg;
	}
}
