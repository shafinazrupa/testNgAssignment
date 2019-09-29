  package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TechfiosPage;
import util.BrowserFactory;

//Test 1: Validate a user is able to add a category and
// once the category is added it should display.

public class FinalTestngAsnmnt {
 WebDriver driver;
 
 @BeforeMethod
 public void launchBrowser() {
	// Start Browser and saved the driver in the test class
	 driver = BrowserFactory.startBrowser();
 }
	@Test
	public void validUsersShouldBeAbleToAddCategory()throws InterruptedException {
		//Go to site
		driver.get(" http://techfios.com/test/101/");
		//Call Login Method from LoginPage
		//Call LoginPage, reference name = new LoginPage()
		TechfiosPage techfiospage = PageFactory.initElements(driver, TechfiosPage.class);
		//techfiospage.ClickOnAddCategoryButton("Java Seaaion at Techfios");
		techfiospage.ClickOnAddCategoryButton("Session at Techfios");
		Thread.sleep(4000);
		
		//Test 2: Validate a user is not able to add a duplicated category. 
		//If it does then the following message will display:
		//"The category you want to add already exists: <duplicated category name>."
		
 Assert.assertTrue(techfiospage.isWarningMassageDisplayed(), "Warning Masssage is not Displayed");
       Thread.sleep(4000);
 
		
//Test 3: Validate the Month drop down has all the months (Jan,Feb,......) 
		//in the Due Date drop down section
		
		  // click on back button
		techfiospage.ClickOnBackButton();
		
		//click Month drop down
		techfiospage.selectMonthDropDown();
		
		//checking the list
		techfiospage.isMonthDropDownHasMonthsDisplayed();
		
		//Validate the Month list
		Assert.assertTrue(techfiospage.isMonthDropDownHasMonthsDisplayed(),
		"Months in the drop down box do not match");
		 
		
		
	}
}
