package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class AddToCart extends BaseClass{

	@Test
	public void addCourseToCart()
	{
		SoftAssert soft = new SoftAssert();
		homePage.clickGears();
		homePage.clickSkillraryDemoApp();
		WebdriverUtil.handleChildWindow();
		soft.assertTrue(skillraryDemoAppPage.getPageHeader().isDisplayed());
		skillraryDemoAppPage.mouseHoverToCourse(WebdriverUtil);
		skillraryDemoAppPage.clickSeleniumTraining();
		seleniumTrainingPage.doubleclickplusButton(WebdriverUtil);
		seleniumTrainingPage.clickAddToCart();
		WebdriverUtil.acceptAlert();
		//
		WebdriverUtil.explicitWait(timeout, seleniumTrainingPage.getItemAddedWebElement());
		WebdriverUtil.takeScreenshot();
		soft.assertEquals(seleniumTrainingPage.getItemAddedMessage(), "Item added to cart");	
		soft.assertAll();
	}
}
