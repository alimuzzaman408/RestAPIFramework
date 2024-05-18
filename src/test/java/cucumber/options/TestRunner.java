package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Feature",
		glue = {"StepDefination"},
		//monochrome = true,
		dryRun=false,
		//tags = "@DeletePlace",
		plugin="json:target/jsonReports/cumcumber-report.json"
		
		)



public class TestRunner {

}
