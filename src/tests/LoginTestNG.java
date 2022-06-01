package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LoginPage;

public class LoginTestNG extends BaseTest{


	@Test (dataProvider = "getData",description = "use incorect login information")
	public void tc01_loginFailedData(String user,String password) {
		//Initiate the login page object
		LoginPage lp = new LoginPage(driver);
		//call the login methods from the login page - the login should failed
		lp.login(user, password);

		String actual = "These credentials do not match our records.";
		String expected = lp.getErrorMsg();	
		assertEquals(actual, expected);
	}
	@Test//(dataProvider = "getData",description = "use incorect login information")
	public void tc02_loginSecceed() {
		LoginPage lp = new LoginPage(driver);
		lp.login("tamarr56@gmail.com","T123456789t");
	}
	@Test//(dataProvider = "getData",description = "use incorect login information")
	public void tc03_loginFailed() {
		LoginPage lp = new LoginPage(driver);
		lp.login("tamarr5@gmail.com","T123456789t");
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"tamarr5@gmail.com","123"},
				{"tamarr56@gmail.com","123"},
				{"tamar@gmail.com","1#444"},
				{"tamarr5@gmail.com","123456878"},
		};
		return myData;
	}
}