package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasePage{
	@FindBy(css = "[name='profile-firstname']")
	WebElement firstName;
	@FindBy(css = "[name='profile-lastname']")
	WebElement lastNameField;
	@FindBy(css = "[name='profile-timezone']")
	WebElement timeZoneField;
	@FindBy(css = "#account-profile .p-4.md\\:py-4 span")
	WebElement update;

	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	public void changeName(String name ,String lastName) {
		sleep(500);
		fillText(firstName, name);
		fillText(lastNameField, lastName);
	}
	public void changeTimeZone(String TimeZone) {
		Select s = new Select(timeZoneField);
		s.selectByValue(TimeZone);
	}
	public void clickChange() {
		click(update);
		sleep(1000);
	}
}