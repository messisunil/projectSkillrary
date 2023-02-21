package testScripts;



import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class SendMail extends BaseClass {

	@Test
	public void sendMail()
	{
	SoftAssert soft = new SoftAssert();
	homePage.clickGears();
	homePage.clickSkillraryDemoApp();
	WebdriverUtil.handleChildWindow();
	soft.assertTrue(skillraryDemoAppPage.getPageHeader().isDisplayed());
	skillraryDemoAppPage.scrollTilContactUs(WebdriverUtil);
	skillraryDemoAppPage.clickContactUs();
	List<String> details = excelUtil.readMultipleData("Sheet1");
	contactUsPage.submitDetails(details.get(0), details.get(1), details.get(2), details.get(3));
	soft.assertAll();
	}
}
