package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkSkyHome;

import java.util.ArrayList;

import static stepdefinitions.SharedSD.getDriver;


public class DarkSkyTimelineSD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("I am on Darksky Home Page")
    public void i_am_on_Darksky_Home_Page() {
        Assert.assertEquals("Dark Sky - Range Hills Road, Pune, Maharashtra",getDriver().getTitle());
    }

    @Then("I verify current temp is not greater or less then temps from daily timeline")
    public void i_verify_current_temp_is_not_greater_or_less_then_temps_from_daily_timeline() {

        String expected = darkSkyHome.getTextTempTimelineCurr();
        String atual = darkSkyHome.getTextTempTitleMain();

        Assert.assertEquals("There is a difference in temperature",expected,atual);

    }

    @Then("I verify timeline is displayed with two hours incremented")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented() {

        ArrayList<Integer> timelist = darkSkyHome.getTimelist();

        ArrayList<Integer> expected = new ArrayList<>();
        for(int i=0;i<10;i++)
            expected.add(2);

        System.out.println("expected list "+expected);

        ArrayList<Integer> actual = new ArrayList<>();
        for(int i=0;i<timelist.size()-1;i++)
        {
            int timeDiff=0;

            int time1 = timelist.get(i);
            int time2 = timelist.get(i+1);

            if(time2>time1)
              timeDiff = time2 - time1;
            if(time1>time2)
                timeDiff = (time2 +12) - time1;

            actual.add(timeDiff);
        }

        System.out.println("actual list:"+actual);

        Assert.assertEquals(expected,actual);

    }

}
