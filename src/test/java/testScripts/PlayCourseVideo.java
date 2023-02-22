package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class PlayCourseVideo extends BaseClass{

	@Test
	public void playVideo()
	{
		SoftAssert soft = new SoftAssert();
		homePage.searchFor("core java for selenium");
		soft.assertEquals(coreJavaForSeleniumPage.getPageHeader(), "CORE JAVA FOR SELENIUM");
		coreJavaForSeleniumPage.clickCoreJaveForSeleniumLink();
		soft.assertEquals(seleniumTrainingVideoPage.getPageHeader(), "Core Java For Selenium Training");
		seleniumTrainingVideoPage.ignoreCookies();
		WebdriverUtil.switchToFrame(0);
		seleniumTrainingVideoPage.clickPlayButton();
		seleniumTrainingVideoPage.clickPauseButton();
		WebdriverUtil.switchBackFromFrame();
		seleniumTrainingVideoPage.clickAddToWishList();
		soft.assertAll();
		
	}
}
