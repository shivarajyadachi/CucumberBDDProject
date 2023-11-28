package TestRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {".//Features/Customers.feature",".//Features/LoginFeature.feature"},
		//features = ".//Features/",    /* It will execute all feature files
		glue="StepDefenition",
		dryRun = false,
		monochrome = true,
		tags="@Sanity or @Regression", // It will execute only @Sanity Test cases
		//plugin = {"pretty","html:target/Cucumber-reports/reports_html.html"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

//html report
/*html:target/Cucumber-reports/reports_html.html*/
//json format report
/*json:target/Cucumber-reports/reports_json.json*/
public class Run {

	
	/* This Class will be Empty*/
}
