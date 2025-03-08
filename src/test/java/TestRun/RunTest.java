package TestRun;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions
(
features= {".//Features/OpenMRS_Scenario.feature"},
glue= {"StepDefinitions","Base"},
dryRun=false,
monochrome=true,
//tags = "@Sanity",

plugin= {"pretty","html:Reports/cucumber-reports.html"}
		
)

public class RunTest {

}