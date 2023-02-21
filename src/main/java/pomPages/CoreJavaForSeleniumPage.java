package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM class consists of all Business libraries related to CoreJavaForSelenium page
 * @author sunil
 *
 */
public class CoreJavaForSeleniumPage {
	//Declaration
	@FindBy(xpath = "//h2[@class='list_title']") private WebElement pageHeader;
	@FindBy(xpath = "//a[contains(@title,'Selenium Training')]") private WebElement coreJavaForSeleniumLink;
	
	//Initialization
	public CoreJavaForSeleniumPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get page header text
	 * @return
	 */
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	/**
	 * This method is used to go to core java for selenium training page
	 */
	public void clickCoreJaveForSeleniumLink()
	{
		coreJavaForSeleniumLink.click();
	}
	
}
