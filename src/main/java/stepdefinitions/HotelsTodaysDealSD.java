package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import pages.HotelsHome;
import pages.HotelsSearchResult;

import java.util.concurrent.TimeoutException;

public class HotelsTodaysDealSD {
   // HotelsHome hotelsHome = new HotelsHome();
    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Then("^I verify todays deal is less than \"([^\"]*)\" rs$")
    public void i_verify_todays_deal_is_less_than_something_rs(String dealpriceExpected)

        {

            // String dealpriceExpected ="6000";
            int dealPriceExpectedInt = Integer.parseInt(dealpriceExpected);
            int dealPriceActual =0;

            System.out.println("dealPriceExpectedInt:"+dealPriceExpectedInt);
           // System.out.println("dealPrice actal raw:"+hotelsSearchResult.getDealPrice());

            String dealPriceActualStr = "";
            try {

                String price = /*"Rs6,523";*/hotelsSearchResult.getDealPrice(); //Rs6,523
                System.out.println("dealPrice actal raw:"+price);

                String str = price.substring(2);
                System.out.println("deal price witout rs:"+str);
                String strWihoutComma = "";

                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) != ',')
                        strWihoutComma = strWihoutComma + str.charAt(i);
                }

                dealPriceActualStr = strWihoutComma;

                System.out.println("deal price WihoutComma:"+dealPriceActualStr);
                dealPriceActual = Integer.parseInt(dealPriceActualStr);

            }

            catch (NoSuchElementException e) {

            } catch (Throwable e)
            {

            }


            boolean result = false;

            if (!dealPriceActualStr.equals(""))
                result = dealPriceActual < dealPriceExpectedInt;
            else
                result = false;

            Assert.assertTrue("higher or incorrect deal price ,Expected:"+dealpriceExpected+",Actual:"
                    +dealPriceActual, result);

            //Assert.assertEquals("higher or incorrect deal price",dealpriceExpected,dealPriceActual);
        }

    }
