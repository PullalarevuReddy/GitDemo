package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement email;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(id = "login")
	WebElement button;

	public void launchApp(String emai, String pass) {
		email.sendKeys(emai);
		password.sendKeys(pass);
		button.click();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");

	}

}
