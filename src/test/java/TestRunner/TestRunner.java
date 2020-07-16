package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (features="C:\\Users\\PC\\IdeaProjects\\CucumbePOMKomal\\Features",
          glue= "stepdefinitions",
           tags="@TodayTimeline")
public class TestRunner {
}
