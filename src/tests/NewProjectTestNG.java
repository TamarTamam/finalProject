package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.ProfilePage;

public class NewProjectTestNG extends BaseTest{


	@Test
	public void tc01_login() {
		HomePage hp = new HomePage(driver);
		hp.login("tamarr56@gmail.com", "T123456789t");
	}
	/*@Test
	public void tc02_change() {
		HomePage hp = new HomePage(driver);
		hp.openTab("Account Settings");
		ProfilePage pp = new ProfilePage(driver);
		pp.changeName("l", "Tamam");
		pp.changeTimeZone("Asia/Jayapura");
		pp.clickChange();
		hp.clickHomePage();
	}
	@Test
	public void tc03_edit() {
		HomePage hp = new HomePage(driver);
		hp.editProject("Feedback Survey", "Edit");
	}*/
	@Test
	public void tc04_rename() {
		HomePage hp = new HomePage(driver);
		hp.renameWorkspace("Tamar Tamam", "Raname Workspace","levi1");
	}
	/*@Test
	public void tc05_plus() {
		HomePage hp = new HomePage(driver);
		hp.plusWorkspace("Tamar Tamam");
	}*/
}
