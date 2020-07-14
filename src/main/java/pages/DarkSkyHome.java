package pages;

import org.openqa.selenium.By;

public class DarkSkyHome extends  BasePage{

    By tempTitleMain = By.xpath("//span[@class='summary swap']");
    By tempTimelineCurr = By.xpath("//span[@class='first']//span");



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
