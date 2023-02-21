package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class contains all reusable methods to perform operation on WebDriverUtilies
 * @author sunil
 *
 */
public class WebDriverUtility {
	private WebDriver driver;
	private Actions action;
	private Select select;
	/**
	 * This method is used navigate to the application
	 * @param browser
	 * @param url
	 * @param timeout
	 * @return
	 */
	public WebDriver launchBrowser(String browser, String url, long timeout)
	{
		switch(browser)
		{
		case "chrome": driver = new ChromeDriver();break;
		case "firefox": driver = new FirefoxDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		default: System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		return driver;
	}
	/**
	 * This method is used to perform mouse hover to the application
	 * @param element
	 */
	public void mouseHover(WebElement element)
	{
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method is used to perform double click on the element
	 * @param element
	 */
	public void doubleClick(WebElement element)
	{
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	/**
	 * This method is used to perform right click on the element
	 * @param element
	 */
	public void rightClick(WebElement element)
	{
		action = new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method is used to perform drag and drop operation
	 * @param source
	 * @param destination
	 */
	public void dragAndDrop(WebElement source, WebElement destination)
	{
		action = new Actions(driver);
		action.dragAndDrop(source, destination).perform();
	}
	/**
	 * This method is used to select option by using index
	 * @param element
	 * @param index
	 */
	public void dropDown(WebElement element, int index)
	{
		select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method is used to select option by using value
	 * @param element
	 * @param value
	 */
	public void dropDown(WebElement element, String value)
	{
		select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method is used to select option by using 
	 * @param text
	 * @param element
	 */
	public void dropDown(String text, WebElement element)
	{
		select = new Select(element);
		select.selectByVisibleText(text);
		
	}
	
	/**
	 * This method is used to switch to frame using index
	 * @param index
	 */
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to frame using id attribute
	 * @param id_Attribute
	 */
	public void switchToFrame(String id_Attribute)
	{
		driver.switchTo().frame(id_Attribute);
	}
	/**
	 * This method is used to switch back from frame to main window
	 */
	public void switchBackFromFrame()
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to switch to parent window
	 */
	public void switchToParentWindow()
	{
		driver.switchTo().window(driver.getWindowHandle());
	}
	/**
	 * This method is used to switch to child window
	 */
	public void handleChildWindow()
	{
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		while(itr.hasNext())
		{
			String child_id = itr.next();
			driver.switchTo().window(child_id);
		}	
	}
	/**
	 * This method is used to accept alert
	 */
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to dismiss alert
	 */
	public void dismissAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used get alert text
	 */
	public void fetchAlertText()
	{
		driver.switchTo().alert().getText();
	}
	/**
	 * This method is used scroll into the particular element
	 * @param element
	 */
	public void scrollIntoElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	/**
	 * This method is used to take screenshot of the page
	 */
	public void takeScreenshot()
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/picture.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * This method is used to perform explicit wait action
	 * @param timeout
	 * @param element
	 */
	public void explicitWait(long timeout, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to close current window
	 */
	public void closeCurrentWindow()
	{
		driver.close();
	}
	/**
	 * This method is used to close all the windows
	 */
	public void closeAllWindows()
	{
		driver.quit();
	}
}
