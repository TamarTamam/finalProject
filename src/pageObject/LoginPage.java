package pageObject;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(css=".other-link.login")
	WebElement loginHome;
	@FindBy(css="[name='email']")
	WebElement userel;
	@FindBy(css="[name='password']")
	WebElement passwordel;
	@FindBy(css="[type='submit']")
	WebElement loginBtn;
	@FindBy(css="div  div:nth-child(6) a")
	WebElement forgetBtn;
	@FindBy(css=".alert.alert-danger")
	WebElement errorMsg;
	@FindBy(css = ".nav-link")
	List<WebElement> loginAgain;

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public void clickLogin() {
		click(loginHome);
	}
	public void login(String user,String password) {
		fillText(userel, user);
		fillText(passwordel,password);
		click(loginBtn);
	}
	public void forgetPassword() {
		click(forgetBtn);
	}
	public void clickLoginAgain(String name) {
		for (WebElement el : loginAgain) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}
	public String getErrorMsg() {
		return getText(errorMsg);
	}
}