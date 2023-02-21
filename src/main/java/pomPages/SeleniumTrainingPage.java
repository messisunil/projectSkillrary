package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This POM class consists of all business libraries related to selenium training page
 * @author sunil
 *
 */
public class SeleniumTrainingPage {
	
	//Declaration
	@FindBy(xpath = "//h1[@class='page-header']") private WebElement pageHeader;
	@FindBy(id = "add") private WebElement add;
	@FindBy(xpath = "//button[.=' Add to Cart']") private WebElement addToCart;
	@FindBy(xpath = "//span[@class='message']") private WebElement addMessage;
	
	//Initialization
	public SeleniumTrainingPage(WebDriver driver)
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
	 * This method is used to double click plus button
	 * @param web
	 */
	public void doubleclickplusButton(WebDriverUtility web)
	{
		web.doubleClick(add);
	}
	/**
	 * This method is used to click add to cart 
	 */
	public void clickAddToCart()
	{
		addToCart.click();
	}
	/**
	 * This method is used to get text after adding item to cart
	 * @return
	 */
	public String getItemAddedMessage()
	{
		return addMessage.getText();
	}
	/**
	 * This method is used to get item added WebElement
	 * @return
	 */
	public WebElement getItemAddedWebElement()
	{
		return addMessage;
	}
}
