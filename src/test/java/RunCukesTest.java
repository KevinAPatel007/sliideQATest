import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/kevinpatel/Downloads/technical_task_qa_web-master/src/test/resources",
        dryRun = false,
        strict = true,

        tags= "@login"
        ,
        plugin = "json:target/cucumber-report/cucumber.json")
public class RunCukesTest {
     // a json report is generated as target/cucumber-report
    //open maven tab and click 'execute maven goal'
    //enter 'cluecumber-report:reporting' and click ok to build

    //report will generated in target folder as generated-report
    //to run from intellij
}
