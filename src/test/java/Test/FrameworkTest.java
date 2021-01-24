package Test;

import Bases.FrameworkTestBase;
import org.testng.Assert;
import Pages.HomePage;
import Pages.PasajPage;
import Pages.SearchPage;
import org.testng.annotations.Test;


public class FrameworkTest extends FrameworkTestBase {

    @Test
    public void searchTest() {

        HomePage home = new HomePage(driver);

        final String searchText = "Samsung Galaxy S20";

        home.clickSearchButton();
        home.clickAndSetTextToSearch(searchText);
        SearchPage searchPage = home.clickSearchButtonInBar();
        searchPage.clickDevices();
        String deviceName = searchPage.getFirstDeviceName();
        log.info("Found device is:" + deviceName);
        Assert.assertEquals(deviceName,searchText);

    }

    @Test
    public void OpenPasajAndCheckBasket() {

        HomePage homePage = new HomePage(driver);

        PasajPage pasajHomePage = homePage.clickPasaj();
        pasajHomePage.clickBasket();
        Assert.assertTrue(pasajHomePage.isBasketEmpty());
        log.info("Basket is empty.");

    }

    @Test
    public void OpenPasajAndCheckInstallments() {

        HomePage homePage = new HomePage(driver);

        PasajPage pasajPage =homePage.clickPasaj();
        pasajPage.moveAndClickMacbookHeader();
        pasajPage.clickMacbook();

        float result = pasajPage.getInstallmentValue();

        log.info("Found price is : " + result);
        Assert.assertTrue(result > 10000);

    }



}