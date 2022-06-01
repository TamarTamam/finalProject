package tests;

import org.testng.annotations.Test;
import pageObject.CouponPage;
import pageObject.HomePage;
import pageObject.ProjectPage;
import pageObject.SurveyPreviewPage;

public class CreatesTestNG extends BaseTest{
	@Test
	public void tc01_login() {
		HomePage hp = new HomePage(driver);
		hp.login("tamarr56@gmail.com", "T123456789t");
	}
	@Test
	public void tc02_createProject() {
		ProjectPage prp = new ProjectPage(driver);
		prp.createProject("Survey");
		prp.selectProject("Feedback Survey", "Preview");
		SurveyPreviewPage sp = new SurveyPreviewPage(driver);
		sp.clickRight();
		HomePage hp = new HomePage(driver);
		hp.clickHomePage();
	}
	@Test
	public void tc03_createProject2() {
		ProjectPage prp = new ProjectPage(driver);
		prp.createProject("Survey");
		prp.selectProject("Promoter Feedback Survey", "Choose");
		HomePage hp = new HomePage(driver);
		hp.clickHomePage();
	}
	@Test
	public void tc04_newCouponsList() {
		HomePage hp = new HomePage(driver);
		hp.openTab("Coupons");
		CouponPage cp = new CouponPage(driver);
		cp.couponSingleList("tamar", "wix","124356", "2");
		hp = new HomePage(driver);
		//hp.clickHomePage();
	}
	@Test
	public void tc05_newCouponsList2() {
		//HomePage hp = new HomePage(driver);
		//hp.openTab("Coupons");
		CouponPage cp = new CouponPage(driver);
		cp.couponMultipleList("hghjg", "amazon","65665");
		//hp.clickHomePage();
	}
}