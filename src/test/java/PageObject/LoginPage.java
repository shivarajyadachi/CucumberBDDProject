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
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement LoginBtn;
	
	@FindBy(linkText="Logout")
	WebElement logoutBtn;
	
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
	}
	
	public void clickOnLogoutBtn()
	{
		logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
		logoutBtn.click();
	}
}
