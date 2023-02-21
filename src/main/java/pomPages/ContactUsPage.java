package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This method consists of all business Libraries related to Contact page
 * @author sunil
 *
 */
public class ContactUsPage {
	//Declaration
	@FindBy(xpath = "//input[@placeholder='Full Name']") private WebElement fullName;
	@FindBy(xpath = "//input[@placeholder='Email']") private WebElement email;
	@FindBy(xpath = "//input[@placeholder='Subject']") private WebElement subject;
	@FindBy(xpath = "//textarea[@placeholder='Message']") private WebElement message;
	@FindBy(xpath = "//button[.='Send us mail']") private WebElement sendUsMailButton;
	
	//Initialization
	public ContactUsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to send mail
	 * @param fullName
	 * @param email
	 * @param subject
	 * @param message
	 */
	public void submitDetails(String fullName, String email, String subject, String message)
	{
		this.fullName.sendKeys(fullName);
		this.email.sendKeys(email);
		this.subject.sendKeys(subject);
		this.message.sendKeys(message);
		sendUsMailButton.click();
	}
}
