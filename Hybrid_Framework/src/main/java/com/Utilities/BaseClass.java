package com.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Comp.POM.Page.LoginPage;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage lp;

	@BeforeMethod
	public void setup() throws Exception {
		String brName=ReadProperty.readConfiqdata("browser");
		if (brName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (brName.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (brName.equals("InternetExplorer")) {
			driver = new InternetExplorerDriver();
		}

		String url=ReadProperty.readConfiqdata("url");
		driver.get(url);

		lp = new LoginPage(driver);

	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
