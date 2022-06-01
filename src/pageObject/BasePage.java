package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//wait = new WebDriverWait(driver, 15);
		actions = new Actions(driver);
		js=(JavascriptExecutor)driver; 	
	}
	public void fillText(WebElement el, String text) {
		//highlight
		highlightElement(el, "yellow");
		el.clear();
		el.sendKeys(text);
	}
	public void click(WebElement el) {
		//highlight
		highlightElement(el, "red");
		el.click();
	}
	public void select(WebElement el, String text) {
		Select s = new Select(el);
		s.selectByValue(text);
	}
	public String getText(WebElement el) {
		return el.getText();
	}
	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void moveTo(WebElement el) {
		actions.moveToElement(el).build().perform();
	}
	public void alertOk(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}
	public void alertAccept() {
		driver.switchTo().alert().accept();
	}
	private void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:"+ color + ";" + " border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);
	}
}

