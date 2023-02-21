package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM class consists of all business libraries related to Selenium training video page
 * @author sunil
 *
 */
public class SeleniumTrainingVideoPage {
	//Declaration
	@FindBy(tagName = "h1") private WebElement pageHeader;
	@FindBy(xpath = "//*[name()='svg' and contains(@class,'PlayButton')]") private WebElement playButton;
	@FindBy(xpath = "//*[name()='svg' and contains(@class,'pauseIcon')]") private WebElement pauseButton;
	@FindBy(xpath = "//span[.='Add To Wishlist']") private WebElement addToWishList;
	@FindBy(xpath = "//a[.='X']") private WebElement ignoreCookies;
	//Initialization
	public SeleniumTrainingVideoPage(WebDriver driver)
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
	 * This method is used to click play button
	 */
	public void clickPlayButton()
	{
		playButton.click();
	}
	/**
	 * This method is used to click pause button
	 */
	public void clickPauseButton()
	{
		pauseButton.click();
	}
	/**
	 * This method is used to click add to wishlist button
	 */
	public void clickAddToWishList()
	{
		addToWishList.click();
	}
	
	public void ignoreCookies()
	{
		ignoreCookies.click();
	}

	
}
