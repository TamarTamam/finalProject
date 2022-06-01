package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends HomePage{

	@FindBy(css = "div.px-4.items-center > a")
	WebElement newProject;
	@FindBy(css = "#app-layout div.title")
	List<WebElement> projectList;
	@FindBy(css = "div.details-container > h3")
	List<WebElement> project;
	@FindBy(css = "#template-gallery > tbody > tr:nth-child(2) > td:nth-child(1) > div > div.caption > div.e-button-container > a:nth-child(2) > button")
	WebElement projectBnt;

	public ProjectPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void createProject(String projectName) {
		click(newProject);
		for (WebElement el : projectList) {
			if (getText(el).equals(projectName)) {
				click(el);
				break;
			}
		}
	}
	public void selectProject(String projectName , String name) {
		for (int i = 0; i < projectList.size(); i++) {
			if (getText(projectList.get(i)).equalsIgnoreCase(projectName)) {
				moveTo(projectList.get(i));
				click(ProjectmenuList.get(i));
				click(projectBnt);

				/*for (WebElement el : project) { 
			if (getText(el).equals(projectName)) {
				moveTo(el); 
				break;

					}
			List<WebElement> bnt = el.findElements(By.cssSelector("[#template-gallery > tbody  td:nth-child(1) > div > div.caption > div.e-button-container  button"));
			for (WebElement eli : bnt) {
				if (getText(eli).equals(name)) {
					click(eli);
					//click(projectBnt);
					break;
				}
			}
		}*/
			}
		}
	}
}
