package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HotelsHome;
import pages.HotelsSearchResult;
import stepdefinitions.SharedSD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HotesStarSD {
    HotelsHome hotelsHome = new HotelsHome();
    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {
        Assert.assertEquals("Hotels.com India", SharedSD.getDriver().getTitle());

        hotelsHome.setcity("Mumbai, India");
        hotelsHome.clickSearch();
    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars) throws Throwable {
                // 5 stars

        hotelsSearchResult.selectstarProperty(stars.split(" ")[0]);

        ArrayList<String> starList = hotelsSearchResult.getStarlist();
        System.out.println(stars);
        System.out.println(starList);

       int occarance =  Collections.frequency(starList,stars); // 5 stars
        int size = starList.size();

        Assert.assertTrue("all hotes are not "+stars,occarance==size);


    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {

    }
}
