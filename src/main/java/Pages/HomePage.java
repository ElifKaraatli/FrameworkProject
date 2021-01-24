package Pages;

import Bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

    By searchButton = By.xpath("/html/body/header/div[2]/div/div[2]/div[2]/div/a[1]");
    By searchText = By.xpath("//*[@id=\"header-search\"]/div[1]/div/div/form/div/input");
    By searchButtonInBar = By.xpath("//*[@id=\"header-search\"]/div[1]/div/div/form/div/button/i");
    By pasajButton = By.xpath("/html/body/header/div[2]/div/nav/a[1]");

    public HomePage(WebDriver driver) {
        init(driver);
    }

    public void clickSearchButton() {
        clickElement(searchButton);
    }

    public void clickAndSetTextToSearch(String text) {
        clickElement(searchText);
        sendTextToElement(searchText,text);
    }

    public SearchPage clickSearchButtonInBar() {
        clickElement(searchButtonInBar);
        return new SearchPage(driver);
    }

    public PasajPage clickPasaj() {
        clickElement(pasajButton);
        return new PasajPage(driver);
    }

}