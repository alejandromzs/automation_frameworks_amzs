package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		        features ="src/test/java/features",
		        glue = "glue",
				stepNotifications = true,
		        plugin = {"progress","html:target/cucumber-reports.html","json:target/build/cucumber.json"},
				tags =  "@TC_1 and @Cert"
                )

public class testrunner {
   
}
