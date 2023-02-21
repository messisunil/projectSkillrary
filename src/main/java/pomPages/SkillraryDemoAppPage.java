package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This POM class consists of all business libraries related to Skillrary demo application page
 * @author sunil
 *
 */
public class SkillraryDemoAppPage {
	//Declaration
	@FindBy(xpath = "//a[@class='navbar-brand']") private WebElement pageHeader;
	@FindBy(xpath = "//a[@id='course']") private WebElement courseTab;
	@FindBy(xpath = "//div[@class='dropdown-content']/descendant::a[.='Selenium Training']") private WebElement seleniumTraining;
	@FindBy(xpath = "//select[@class='chosen-select']") private WebElement Category;
	@FindBy(xpath = "//a[.='Contact Us']") private WebElement contactUs;
	
	//Initialization
	public SkillraryDemoAppPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getPageHeader()
	{
		return pageHeader;
	}
	//Utilization
	/**
	 * This method is used to mouse hover to course tab
	 * @param web
	 */
	public void mouseHoverToCourse(WebDriverUtility web)
	{
		web.mouseHover(courseTab);
	}
	/**
	 * This method is used to click selenium training
	 */
	public void clickSeleniumTraining()
	{
		seleniumTraining.click();
	}
	/**
	 * This method is used to select category
	 * @param web
	 * @param text
	 */
	public void selectCategory(WebDriverUtility web, String text)
	{
		web.dropDown(text, Category);
	}
	/**
	 * This method is used to click contact us
	 */
	public void clickContactUs()
	{
		contactUs.click();
	}
	/**
	 * This method is used to scroll til contactUs element
	 * @return
	 */
	public void scrollTilContactUs(WebDriverUtility web)
	{
		web.scrollIntoElement(contactUs);
	}
	
}
