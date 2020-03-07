package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelReader;

		public class TestBase {

			public static void main(String[] args) throws Throwable {
				String filePath = "C:\\Users\\uadulla\\Documents\\AutomationTestData.xlsx";
				String sheetName = "Login";
				ExcelReader readExcel = new ExcelReader(filePath,sheetName);
				HomePage objHomePage;
				
				// TODO Auto-generated method stub
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\uadulla\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				driver.get("http://www.demo.guru99.com/V4/");
				driver.manage().window().maximize();
				LoginPage objLoginPage = new LoginPage(driver);
				for(int i=0;i<4;i++) {
			    objHomePage =objLoginPage.loginUser(readExcel.getData("Username"),readExcel.getData("Password"));
				if(objHomePage.getUserName().contains(readExcel.getData("Username")))
					System.out.println("Logged in successfully");
				else
					System.out.println("Login unsuccessful");	
				}
				//BasePage objBasePage = new BasePage(driver);
				System.out.println("Title: "+objHomePage.getPageTitle());
				driver.close();
				
	}

}
