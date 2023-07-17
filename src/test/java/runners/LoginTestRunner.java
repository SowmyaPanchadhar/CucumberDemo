package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( tags= "",features = "src/test/resources/features", glue = "stepdef",

plugin = {"pretty","html:target/cucumber-reports.html", 
		"json:target/MyReports/report.json",
		"rerun:target/failedrerun.txt",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome=false,dryRun=false,
publish=true

)
public class LoginTestRunner extends AbstractTestNGCucumberTests{

}
