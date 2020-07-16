package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.DarkSkyHome;

/*
1. expand todays timeline

2. min & max temp -- make an array list - done

3. mintimeline & maxTimeline -- make an array list - done

4. camare 2 lists using assert
 */

public class TodaysTimeLineSD {

DarkSkyHome darkSkyHome = new DarkSkyHome();

    @When("I expand todays timeline")
    public void i_expand_todays_timeline() {

       darkSkyHome.clickBarToday();
    }

    @Then("I verify lowest and highest temp is displayed correctly")
    public void i_verify_lowest_and_highest_temp_is_displayed_correctly() {


        System.out.println(darkSkyHome.getTimelineTempList());
        System.out.println(darkSkyHome.getTodaysTimelineTempList());

        Assert.assertEquals(darkSkyHome.getTimelineTempList(),darkSkyHome.getTodaysTimelineTempList());


    }

}
