package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends LoginPage {
	@FindBy(css="div.flex.text-sm.items-center.space-x-2 > div")
	WebElement menuBtn;
	@FindBy(css=".w-full.hidden a")
	List<WebElement> menuList;
	@FindBy(css="div.grid > div")
	List<WebElement> projectList;
	@FindBy(css="div:nth-child(1) > div.absolute ul a")
	List<WebElement> ProjectmenuList;
	@FindBy(css=".e-close.nav-link")
	WebElement saveBtn;
	@FindBy(css="span.mr-3.truncate")
	List<WebElement> WorkspacesName;
	@FindBy(css="div.mr-3 > button")
	WebElement ListBtn;
	@FindBy(css="[title='r']")
	List<WebElement> RanameList;
	@FindBy(css="form input")
	WebElement RenameField;
	@FindBy(css="#confirm-create-button")
	WebElement okBtn;
	@FindBy(css="div.justify-between> button")
	WebElement plusBtn;
	@FindBy(css="div.flex-shrink-0> a")
	WebElement homeBtn;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	public void openTab(String name) {
		// click(homeBtn);
		click(menuBtn);

		for (WebElement el : menuList) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}
	public void editProject(String projectName, String option) {
		for (WebElement el : projectList) { 
			//Creating an element within an element
			WebElement ProjectTitle = el.findElement(By.cssSelector("div.mb-3 a"));
			if(getText(ProjectTitle).equals(projectName)) { 
				WebElement ProjectmenuBtn = el.findElement(By.cssSelector("div.flex.justify-right.items-center > div svg")); 
				click(ProjectmenuBtn);
				break;
			}
		} 
		//click option in the menu
		for (WebElement el : ProjectmenuList) { 
			if (getText(el).equals(option)) {
				click(el); 
				break;
			} 
		}
		click(saveBtn);
		sleep(500);

	}

	public void renameWorkspace(String Workspaces, String Options, String name) {
		//choose Workspaces
		sleep(500);
		for (WebElement el : WorkspacesName) {
			if (getText(el).equalsIgnoreCase(Workspaces)) {
				click(el);
				break;
			}
		}
		click(ListBtn);
		sleep(500);
		//choose option
		for (WebElement el : RanameList) {
			sleep(500);
			//WebElement OptionsTitle = el.findElement(By.cssSelector("ul button"));
			if (getText(el).equals(Options)) {
				sleep(500);
				click(el);
				break;
			}
		}
		fillText(RenameField, name);
		click(okBtn);
	}
	public void plusWorkspace(String name) {
		click(plusBtn);
		fillText(RenameField, name);
		click(okBtn);
		//click(startBtn);
	}
	public void clickHomePage() {
		click(homeBtn);
		sleep(500);
	}
}