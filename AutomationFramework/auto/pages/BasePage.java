package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	public void clickForward() {
		driver.navigate().back();
		
	}
	public void clickBackward() {
		driver.navigate().back();		
	}
	public void test(){
	}

}
