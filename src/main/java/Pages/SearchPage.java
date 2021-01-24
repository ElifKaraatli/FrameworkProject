package Pages;

import Bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageBase {

    By devicesTab = By.xpath("//*[@id=\"search-results\"]/div/div[3]/div[1]/div/div[1]/div/div[2]/a");
    By firstDevice = By.xpath("//*[@id=\"tabDevices\"]/div[1]/a/div[1]/span");

    public SearchPage(WebDriver driver) {

        init(driver);

    }

    public void clickDevices() {

        clickElement(devicesTab);

    }

    public String getFirstDeviceName() {

        return getElementText(firstDevice);

    }



}