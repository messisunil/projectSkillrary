package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.ContactUsPage;
import pomPages.CoreJavaForSeleniumPage;
import pomPages.HomePage;
import pomPages.SeleniumTrainingPage;
import pomPages.SeleniumTrainingVideoPage;
import pomPages.SkillraryDemoAppPage;
import pomPages.TestingPage;

public class BaseClass {
 
	//@BeforeSuite used to dataBase Connectivity
	
	//@BeforeTest used to parallel execution
	protected PropertiesFileUtility propertyUtil;
	protected ExcelFileUtility excelUtil;
	protected WebDriverUtility WebdriverUtil;
	protected WebDriver driver;
	
	protected ContactUsPage contactUsPage;
	protected CoreJavaForSeleniumPage coreJavaForSeleniumPage;
	protected HomePage homePage;
	protected SeleniumTrainingPage seleniumTrainingPage;
	protected SeleniumTrainingVideoPage seleniumTrainingVideoPage;
	protected SkillraryDemoAppPage skillraryDemoAppPage;
	protected TestingPage testingPage;
	 protected long timeout;
	
	@BeforeClass
	public void classConfiguration()
	{
		propertyUtil = new PropertiesFileUtility();
		excelUtil = new ExcelFileUtility();
		WebdriverUtil = new WebDriverUtility();
		
		propertyUtil.propertiesFileInitialization(IConstantPath.PROPERTIES_PATH);
		excelUtil.excelInitialization(IConstantPath.EXCEL_PATH);
		
	}
	
	@BeforeMethod
	public void methodConfiguration()
	{
		timeout = Long.parseLong(propertyUtil.fetchProperty("timeout"));
		driver = WebdriverUtil.launchBrowser(propertyUtil.fetchProperty("browser"), propertyUtil.fetchProperty("url"), timeout);
		contactUsPage = new ContactUsPage(driver);
		homePage = new HomePage(driver);
		seleniumTrainingPage = new SeleniumTrainingPage(driver);
		coreJavaForSeleniumPage = new CoreJavaForSeleniumPage(driver);
		seleniumTrainingVideoPage = new SeleniumTrainingVideoPage(driver);
		skillraryDemoAppPage = new SkillraryDemoAppPage(driver);
		testingPage = new TestingPage(driver);
	}
	
	@AfterMethod
	public void methodTearDown()
	{
		excelUtil.closeExcel();
		
	}
	
	@AfterClass
	public void classTearDown()
	{
		WebdriverUtil.closeAllWindows();
	}
	
	//@AfterTest
	
	//@AfterSuite used to close dataBase Conncetivity
}
