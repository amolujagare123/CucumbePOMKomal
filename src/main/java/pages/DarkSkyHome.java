package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepdefinitions.SharedSD;

import java.util.ArrayList;
import java.util.List;

public class DarkSkyHome extends  BasePage{

    By tempTitleMain = By.xpath("//span[@class='summary swap']");
    By tempTimelineCurr = By.xpath("//span[@class='first']//span");
    By timelineList = By.xpath("//span[@class='hour']/span");
    By todayMinTemp = By.xpath("//a[@class='day revealed']//span[@class='minTemp']");
    By todayMaxTemp = By.xpath("//a[@class='day revealed']//span[@class='maxTemp']");
    By barToday = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]/span[3]");
    By TimeLineTemps = By.xpath("//div[@class='dayDetails revealed']//span[@class='temp']");


    public ArrayList<String> getTodaysTimelineTempList()
    {
        List<WebElement> temps = driver.findElements(TimeLineTemps);

        ArrayList<String> minmaxTemps = new  ArrayList<>();
        minmaxTemps.add(temps.get(0).getText().split("˚")[0]); // 70˚
        minmaxTemps.add(temps.get(1).getText().split("˚")[0]); // 70˚

        return minmaxTemps;
    }

    public ArrayList<String> getTimelineTempList() {

        ArrayList<String> minmaxTemps = new  ArrayList<>();

        minmaxTemps.add(getTextFromElement(todayMinTemp).split("˚")[0]);
        minmaxTemps.add(getTextFromElement(todayMaxTemp).split("˚")[0]);

        return  minmaxTemps;
    }



     public void clickBarToday()
     {
         JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
         js.executeScript("window.scrollBy(0,800)", "");


         js.executeScript("arguments[0].click();",  driver.findElement(barToday));


       //  clickOn(barToday);
     }




       public ArrayList<Integer> getTimelist()
       {
           ArrayList<String> timeListText = getElementTextList(timelineList);
           ArrayList<Integer> timeListInt = new ArrayList<>();

           for(int i=0;i<timeListText.size();i++)
           {
               // trim last 2 characters
               int l = timeListText.get(i).length();

               String timeStr = timeListText.get(i).substring(0,l-2);  // am or pm are trimmed - 8

                  int time = Integer.parseInt(timeStr);

               timeListInt.add(time);

           }

           System.out.println("Timeline List:"+timeListInt);
                return timeListInt;
       }



    public String getTextTempTitleMain() // 76˚ Clear.
    {
        String temp =   getTextFromElement(tempTitleMain);

       return  temp.split("˚")[0];
    }

    public String getTextTempTimelineCurr() // 76°
    {
        String temp = getTextFromElement(tempTimelineCurr);
        return  temp.split("°")[0];
    }

}
