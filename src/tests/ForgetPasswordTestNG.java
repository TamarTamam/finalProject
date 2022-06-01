package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageObject.ForgetPage;
import pageObject.LoginPage;

public class ForgetPasswordTestNG extends BaseTest{
	
	@Test
	public void tc01_forgetPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.forgetPassword();
		ForgetPage fp = new ForgetPage(driver);
		fp.resetPassword("tamarr56@gmail.com");
		String actual = "A reset link has been sent to the email address, if it has been used to register for an account.";
		String expected = fp.getCorrectMsg();	
		assertEquals(actual, expected);
		lp.clickLoginAgain("login");
	}
	@Test
	public void tc02_forgetPassword2() {
		LoginPage lp = new LoginPage(driver);
		lp.forgetPassword();
		ForgetPage fp = new ForgetPage(driver);
		fp.resetPassword("tamarr5@gmail.com");
		String actual = "We can't find a user with that e-mail address.";
		String expected = fp.getErrorMsg();	
		assertEquals(actual, expected);
	}
}
