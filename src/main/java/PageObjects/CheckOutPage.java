package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[placeholder='Select Country'])")
	WebElement placeholder;
	@FindBy(xpath="(//button[contains(@class,'ta-item)])[2]")
	WebElement button;
	
	
	By results= By.cssSelector(".ta-results");
	

	public void selectCountry() {
		Actions a = new Actions(driver);
		a.sendKeys(placeholder, "india").build().perform();
		waitForElementToAppear(results);
		//button.click();
	}

}
