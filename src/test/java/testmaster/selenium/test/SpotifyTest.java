package testmaster.selenium.test;

import org.junit.jupiter.api.Test;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.pages.*;

public class SpotifyTest extends Driver {

    GuestPage guestPage;
    LoginPage loginPage;
    HomePage homePage;

    PlayListPage playListPage;

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
        homePage.clickAddPlaylist();
        playListPage.controlAddPlaylist();
        playListPage.clickPlaylist();
        playListPage.controlEditPlaylist();
        String spotify_listem_esra = "Spotify Listem Esra "+System.currentTimeMillis();
        playListPage.editPlaylist(spotify_listem_esra);
        playListPage.isPlaylistEdited(spotify_listem_esra);
        homePage.clickSearch();
        searchPage.searchControl();
        String daft_punk = "Daft Punk";
        searchPage.saerchArtist(daft_punk);
        searchPage.artistControl(daft_punk);
        String songName0 = searchPage.addThreeSongsToList(spotify_listem_esra,0);
        searchPage.clear();
        homePage.clickSearch();
        searchPage.searchControl();
        searchPage.saerchArtist(daft_punk);
        searchPage.artistControl(daft_punk);
        String songName1 = searchPage.addThreeSongsToList(spotify_listem_esra,1);
        searchPage.clear();
        homePage.clickSearch();
        searchPage.searchControl();
        searchPage.saerchArtist(daft_punk);
        searchPage.artistControl(daft_punk);
        String songName2 = searchPage.addThreeSongsToList(spotify_listem_esra,2);
        searchPage.clear();
        homePage.goToPlayList(spotify_listem_esra);
        playListPage.playSecondSong();
        playListPage.deleteThirdSong();
        int x=0;
    }

    public void init(){

        guestPage = new GuestPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        searchPage= new SearchPage();
        playListPage= new PlayListPage();
    }
}
