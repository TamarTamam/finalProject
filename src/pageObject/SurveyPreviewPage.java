package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SurveyPreviewPage extends BasePage{
	@FindBy(css = ".fa.fa-angle-right.text-white")
	WebElement right;
	@FindBy(css = "[style=\"height: auto; justify-content: flex-start;\"]")
	List<WebElement> ageList;

	public SurveyPreviewPage(WebDriver driver) {
		super(driver);	
	}
	public void clickRight() {
		click(right);	
	}
	public void clickAge(String age) {
		for (WebElement el : ageList) {
			if (getText(el).equals(age)) {
				click(el);	
			}	
		}
	}
}