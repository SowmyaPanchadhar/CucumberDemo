package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"pretty","rerun:target/failedrerun.txt"},
features= {"@target/failedrerun.txt"})
public class FailedTestRunner extends AbstractTestNGCucumberTests{

}
