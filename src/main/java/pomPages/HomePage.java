package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This POM class consists of all business libraries related to skillrary home page
 * @author sunil
 *
 */
public class HomePage {
	// Declaration
	@FindBy(xpath = "//img[@alt='SkillRary']")
	private WebElement logo;
	@FindBy(xpath = "//a[.=' GEARS ']")
	private WebElement gears;
	@FindBy(xpath = "//input[@placeholder='Search for Courses']")
	private WebElement searchBar;
	@FindBy(xpath = "//input[@value='go']")
	private WebElement searchButton;
	@FindBy(xpath = "//ul[@class='dropdown-menu gear_menu']/descendant::a[.=' SkillRary Demo APP']")
	private WebElement skillraryDemoApp;
	@FindBy(xpath = "//a[.='X']") private WebElement ignoreCookies;

	// Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	/**
	 * This method is used to get logo
	 * @return
	 */
	public WebElement getLogo() {
		return logo;
	}
	/**
	 * This method is used to search a course
	 * @param data
	 */
	public void searchFor(String data, WebDriverUtility web) {
		ignoreCookies.click();
		web.explicitWait(10, searchBar);
		searchBar.sendKeys(data);
		searchButton.click();
	}
	/**
	 * This method is used to click gears tab
	 */
	public void clickGears() {
		gears.click();
	}
	/**
	 * This method is used click skillrary demo app option
	 */
	public void clickSkillraryDemoApp() {
		skillraryDemoApp.click();
	}

}
