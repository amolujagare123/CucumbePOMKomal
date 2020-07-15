package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkSkyHome extends  BasePage{

    By tempTitleMain = By.xpath("//span[@class='summary swap']");
    By tempTimelineCurr = By.xpath("//span[@class='first']//span");
    By timelineList = By.xpath("//span[@class='hour']/span");


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
