package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import com.sun.org.apache.bcel.internal.generic.Select;

public class TechfiosPage extends BasePage  {

	WebDriver driver;//Global
	//every Page must have a constructor to invite the driver
	public TechfiosPage(WebDriver driver) {
		this.driver = driver;
	} 
	// Element library
	@FindBy(how = How.NAME,using = "data")	
	WebElement CategoryInputBox;
	@FindBy(how = How.NAME,using = "submit")	
	WebElement AddButton;
    @FindBy(how = How.XPATH,using = "//body[contans(text),'Sorry that TODO item already exists. ']")	
	WebElement DuplicateWarningMessage;
	@FindBy(how = How.NAME,using = "due_month")	
	WebElement MonthDropDown;
	@FindBy(how = How.LINK_TEXT,using = "Back")	
	WebElement BackButton;
	@FindBys(@FindBy(how = How.XPATH,using = "//select[@name = 'due_month']/descendant::option"))	
	List<WebElement> MonthList;
	private Object selectMonthDropDown;
	private Object allMonthOptions;
	//private String months;
	// Methods to interact with the Elements
	public void ClickOnAddCategoryButton(String category) {
		CategoryInputBox.click();
		CategoryInputBox.sendKeys(category);
 	    AddButton.click();
 	    }
	//Method to check if warning massage is displayed
    public boolean isWarningMassageDisplayed() {
		return DuplicateWarningMessage.isDisplayed();
		}
		
		//Method to go back after warning massage has been displayed
		public void ClickOnBackButton() throws InterruptedException{
		BackButton.click();
	Thread.sleep(4000);
	}
	//Test 3
		public void selectMonthDropDown() {
			MonthDropDown.click();
	}
    public boolean isMonthDropDownHasMonthsDisplayed() {
    	
		Select selectMonthDropDown = new Select(MonthDropDown);
	List<WebElement>allMonthOptions =   selectMonthDropDown.getoptions();
	
	
		
		  String  months = "None;Jan;Feb;Mar;Apr;May;Jun;Jul;Aug;Sep;Oct;Nov;Dec";
		String[] arrMonths = months.split(";");
		
		int count = 0;
		for (String str : arrMonths) {
		
			boolean found = false;
			for (WebElement ele : allMonthOptions) {
				if (str.equals(ele.getText())) {
					found = true;
					count++;
					System.out.println(str + "   Month exists!");
					break;
					
				}
			}
			if (!found) {
				System.out.println(str + "   Month does not exists!");	
			}
		}
		System.out.println("count : " + count);
		if(count <13){
		return false;
		}
		else {
		return true;
		}
		}
	}
