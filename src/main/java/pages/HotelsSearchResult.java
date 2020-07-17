package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinitions.SharedSD;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotelsSearchResult  extends  BasePage{

   By starFields = By.xpath("//span[contains(@class,'star-rating-text')]");



   public ArrayList<String> getStarlist()
   {
       ArrayList<String> starList = new ArrayList<>();

        ArrayList<String>  starWithdashList =  getElementTextList(starFields);
        // 5-star

       for(int i=0;i<starWithdashList.size();i++)
       {
           starList.add(starWithdashList.get(i).split("-")[0]+" stars");  // 5-star
       }

       return  starList;

   }


    public void selectstarProperty(String star) throws InterruptedException {
        //SharedSD.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Thread.sleep(5000);
        SharedSD.getDriver().findElement(By.xpath("//input[@id='f-star-rating-"+star+"']")).click();
        Thread.sleep(8000);
    }
}
