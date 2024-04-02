package tek.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "tek.bdd.steps",
        dryRun = false,
       tags = "@CreateNewAccount",
       // tags = "@Story_2", // tag is a label or identifier that you can assign
        // to scenarios or features to categorize them. They are used to organize and filter Scenarios
        // or features when running tests. They also can be used to group related scenarios, mark certain
        // scenarios for special attention for instance, smoke testing, regression testing, or to exclude
        // certain scenarios from a test run.
      //  tags = "@Regression",
        plugin = {
                "pretty", // pretty will print the step definitions on the console window
                // It is not commonly used.
                "html:target/test_report/passed_login_test/report.html",
        }
        //dryRun = false
        // "html:target/test_report/report.html" To create a report
)
public class TestRunner {
}
