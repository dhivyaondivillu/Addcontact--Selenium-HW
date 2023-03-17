package addcontact;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Addcontact {

	WebDriver driver;

// storing element on By type
	By USERNAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By SIGNIN_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");
	By CUSTOMERS_MENU_FIELD = By.xpath("//span[contains(text(),'Customers')]");
	By ADD_CONTACT_FIELD = By.xpath("//a[contains(text(),'Add Customer')]");
	By ADD_CONTACT_HEADER_FIELD=By.xpath("//h5[contains(text(),'Add Contact')]");
//	By ADD_CONTACT_HEADER_FIELD=By.xpath("*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/table/tbody/tr[5]/td[3]/a");
	By FULL_NAME_FIELD = By.xpath("//*[@id=\"account\"]");
	By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@id='cid']");
	By EMAIL_FIELD=By.xpath("//*[@id=\"email\"]");
	By CONTACT_NUMBER=By.xpath("//*[@id=\"phone\"]");
	By ADDRESS_FIELD=By.xpath("//*[@id=\"address\"]");
	By CITY_FIELD=By.xpath("//*[@id=\"city\"]");
	By STATE_FIELD=By.xpath("//*[@id=\"state\"]");
	By ZIPCODE_FIELD=By.xpath("//*[@id=\"zip\"]");
	By COUNTRY_FIELD=By.xpath("//select[@id='country']");
	By SAVE_FIELD= By.xpath("//*[@id=\"submit\"]");
	By LIST_CUSTOMERS_FIELD=By.xpath("//a[contains(text(),'List Customers')]");
	By SEARCH_FIELD=By.xpath("//*[@id=\"foo_filter\"]");
	By CUSTOMERS_DETAIL_FIELD=By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/table/tbody/tr[1]/td[3]/a");
	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void loginTest() throws InterruptedException {
// login 
		driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
	//	driver.findElement(SIGNIN_FIELD).click();
//using KeyBoardEvent	
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
//verify the webpage using Assertion

     	String dashboardHeaderText = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
		System.out.println(dashboardHeaderText);
		Assert.assertEquals("Page not found!!", "Dashboard", dashboardHeaderText);	
	    Thread.sleep(2000);
		
//enter the customers field
		
		driver.findElement(CUSTOMERS_MENU_FIELD).click();
		driver.findElement(ADD_CONTACT_FIELD).click();
// verify the webpage using Assertion
		
/*		String addcontactHeaderText = driver.findElement(ADD_CONTACT_HEADER_FIELD).getText();
		System.out.println(addcontactHeaderText);
		Assert.assertEquals("Add Contact page not found", "Add Contact", addcontactHeaderText);
		Thread.sleep(2000); */
		
//fill out the customer details			
		driver.findElement(FULL_NAME_FIELD).sendKeys("Dhivya");
		
//using dropdown option		
		Select sel = new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
		sel.selectByVisibleText("Amazon");
		
		driver.findElement(EMAIL_FIELD).sendKeys("techfiosdhivya@gmail.com");
		driver.findElement(CONTACT_NUMBER).sendKeys("845321897");
		driver.findElement(ADDRESS_FIELD).sendKeys("11 RIVERCHASE");
		driver.findElement(CITY_FIELD).sendKeys("AL"); 
		driver.findElement(STATE_FIELD).sendKeys("GA");	
		driver.findElement(ZIPCODE_FIELD).sendKeys("56009");
// Using dropdown 		
//		Select sel2= new Select(driver.findElement(COUNTRY_FIELD));
//		sel2.deselectByVisibleText("United States");
		driver.findElement(COUNTRY_FIELD).sendKeys("United States");
		driver.findElement(SAVE_FIELD).click();
		Thread.sleep(3000);
			
//Verification of the customer Details
		
/*		driver.findElement(CUSTOMERS_MENU_FIELD).click();
		driver.findElement(LIST_CUSTOMERS_FIELD).click();
		//WebElement x = driver.findElement(By.xpath("//a[contains(text(),'ab@gmail.com')]"));
		driver.findElement(SEARCH_FIELD).sendKeys("zxcv");
		//Thread.sleep(5000);
		//action.keyDown(Keys.SHIFT).sendKeys(driver.findElement(SEARCH_FIELD),"abc");
		driver.findElement(By.xpath("//a[contains(text(),'Dhivya')]")).click(); ////a[contains(text(),'Dhivya')] */
		
//Using scrolldown	
		Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,100)");
			
			
	}
	
	
//	@After
//	public void teardown() {
		
//		driver.close();
		
//	}

}
