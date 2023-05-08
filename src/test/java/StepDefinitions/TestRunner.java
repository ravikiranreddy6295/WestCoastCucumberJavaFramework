package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/ravikiranreddy/eclipse-workspace/WestCoastCucumberJavaFramework/src/test/resources/Features",
glue= {"StepDefinitions"},
monochrome=true,
plugin = {"pretty","json:target/JSONReports/report.json",
		"pretty","junit:target/JUnitReports/report.xml",
		"pretty","html:target/HTMLReports/report.html"},
tags="@smoketest"
)
public class TestRunner {

}
