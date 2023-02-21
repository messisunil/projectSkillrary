package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class DragNDrop extends BaseClass {
	@Test
	public void dragNDropTheCourse()
	{
		SoftAssert soft = new SoftAssert();
		homePage.clickGears();
		homePage.clickSkillraryDemoApp();
		WebdriverUtil.handleChildWindow();
		soft.assertTrue(skillraryDemoAppPage.getPageHeader().isDisplayed());
		skillraryDemoAppPage.selectCategory(WebdriverUtil, "Testing");
		soft.assertEquals(testingPage.getPageHeader(), "Testing");
		testingPage.dragAndDropSeleniumImage(WebdriverUtil);
		testingPage.scorllTillFacebook(WebdriverUtil);
		testingPage.clickFacebook();
		soft.assertAll();
	}
}
