package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="src/test/resources/Feature",glue = {"org.bookstore.stepdefs"},
        plugin = {"pretty","html:target/cucumber-reports", "json:target/cucumber.json"},
        monochrome = true,
        publish=true,tags = "@Test1")
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
    return super.scenarios();
    }

}
