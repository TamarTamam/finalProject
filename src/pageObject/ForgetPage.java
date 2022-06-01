package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPage extends BasePage{
	@FindBy(css="[name='email']")
	WebElement email;
	@FindBy(css=".btn.btn-primary")
	WebElement sendBtn;
	@FindBy(css=".alert.alert-success")
	WebElement correctMsg;
	@FindBy(css=".alert.alert-danger")
	WebElement errorMsg;

	public ForgetPage(WebDriver driver) {
		super(driver);
	}
	public void resetPassword(String mail) {
		fillText(email, mail);
		click(sendBtn);
	}
	public String getCorrectMsg() {
		return correctMsg.getText();
	}
	public String getErrorMsg() {
		return errorMsg.getText();
	}
}
