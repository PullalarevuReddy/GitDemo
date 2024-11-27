package TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public WebDriver launchApplication() throws IOException {
	Properties prop = new Properties();
	FileInputStream fis=new FileInputStream("C://Users//LENOVO//eclipse-workspace//Framework2//src//main//java//resources//GlobalData.properties");
	prop.load(fis);
	String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

	if(browserName.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}else if(browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	}
	public void intilizeDriver() throws IOException {
		driver=launchApplication();
	}
	


}
