package com.adactin.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.adactin.baseclass.BaseClass;
import com.adactin.helper.FileReaderManager;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\adactin\\feature", 
				 glue = "com\\adactin\\stepdefinition", 
				 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Report/cucumber_reports.html","html:Report",
						   "json:cucumber_report.json",
						   "rerun:Report1/FailedScenario.txt"
						   },
				 monochrome = true, 
				 dryRun = false, 
				 strict = true
				// tags = {"@Login"}
				  
				 )

public class Runner {

	public static WebDriver driver;

	@BeforeClass
	public static void setup() throws Exception {

		String browsername= FileReaderManager.getInstance().getCrInstance().browsername();
		driver = BaseClass.browserLaunch(browsername);
	}
	
	/*
	 * @AfterClass public static void tearDown() {
	 * 
	 * driver.quit();
	 * 
	 * }
	 */

}
