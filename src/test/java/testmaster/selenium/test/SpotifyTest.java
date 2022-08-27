package testmaster.selenium.test;

import org.junit.jupiter.api.Test;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.pages.GuestPage;
import testmaster.selenium.pages.HomePage;
import testmaster.selenium.pages.LoginPage;
import testmaster.selenium.pages.SearchPage;

public class SpotifyTest extends Driver {

    GuestPage guestPage;
    LoginPage loginPage;
    HomePage homePage;

    SearchPage searchPage;

    @Test
    public void loginTest(){

        /**
        https://github.com/YunusBalaman/TestmasterSeleniumProject
         */
        System.out.println("Spotify");
        init();
        guestPage.controlGuestPage();
        guestPage.clickLoginButton();
        loginPage.controlLoginPage();
        loginPage.validLogin("yunussahabt@gmail.com","Testinium2022");
        homePage.loginControl("YunusB");
        homePage.clickSearch();
        searchPage.searchControl();
        searchPage.searchArtist("sezen aksu");
        searchPage.artistControl("sezen aksu");
    }

    public void init(){

        guestPage = new GuestPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        searchPage= new SearchPage();
    }
}
