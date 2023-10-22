package sauceDemo.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sauceDemo/feature",
        glue = "sauceDemo.stepDef",
        plugin = {"html:target/HTML report.html"}
)

public class runLogin {
}