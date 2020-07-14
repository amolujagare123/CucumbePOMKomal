package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkSkyHome;

import static stepdefinitions.SharedSD.getDriver;


public class TempVerifySD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("I am on Darksky Home Page")
    public void i_am_on_Darksky_Home_Page() {
        Assert.assertEquals("Dark Sky - Broadway, New York, NY",getDriver().getTitle());
    }

    @Then("I verify current temp is not greater or less then temps from daily timeline")
    public void i_verify_current_temp_is_not_greater_or_less_then_temps_from_daily_timeline() {

        String expected = darkSkyHome.getTextTempTimelineCurr();
        String atual = darkSkyHome.getTextTempTitleMain();

        Assert.assertEquals("There is a difference in temperature",expected,atual);

    }
}
