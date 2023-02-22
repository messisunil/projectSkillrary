package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This POM class consists of all the business libraries related to Testing page
 * @author sunil
 *
 */
public class TestingPage {
	
	//Declaration
	@FindBy(xpath = "//h1[@class='page-header']") private WebElement pageHeader;
	@FindBy(id = "Selenium Training") private WebElement seleniumImage;
	@FindBy(id = "cartArea") private WebElement cartArea;
	@FindBy(xpath = "//ul/descendant::a[@href='https://bit.ly/FSKILLRARY']") private WebElement facebookPage;
	@FindBy(xpath = "//p[@id='the_total']") private WebElement total;
	
	//Initialization
	public TestingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get page header
	 * @return
	 */
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	/**
	 * This method is used to perform drag and drop action
	 * @param web
	 */
	public void dragAndDropSeleniumImage(WebDriverUtility web)
	{
		web.dragAndDrop(seleniumImage, cartArea);	
	}
	/**
	 * This method is used to scroll down till facebook
	 * @param web
	 */
	public void scorllTillFacebook(WebDriverUtility web)
	{
		web.scrollIntoElement(facebookPage);
	}
	/**
	 * This method is used to click facebook icon
	 */
	public void clickFacebook()
	{
		facebookPage.click();
	}
}
