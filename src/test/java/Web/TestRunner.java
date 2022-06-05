package Web;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //Path to feature files
        features = {"src/test/resources/.feature"},
        //Specify Step Definition package name
        glue = {"StepDefinition","Web"},
        //tags to be executed
        tags = "@regression",
        //Creates a default Cucumber report
        plugin = {"pretty","html:target/HTMLReports"}
)
public class TestRunner {
}