package testmaster.selenium.pages;

import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPage {
    Methods methods;

    public SearchPage(){

        methods = new Methods();
    }
    public void searchControl(){
        assertTrue(methods.isElementVisible(By.xpath("//form[@role=\"search\"]"),20));

    }

    public void saerchArtist(String artistName){
        methods.clear(By.xpath("//input[@data-testid=\"search-input\"]"));
        methods.sendKeys(By.xpath("//input[@data-testid=\"search-input\"]"), artistName);
    }

    public void artistControl(String artistName) {
        By element = By.xpath("//div[@data-testid=\"top-result-card\"]//a");
        assertTrue(methods.getText(element).equalsIgnoreCase(artistName));
    }
    public String addThreeSongsToList(String listName,int songNo){
        By songs = By.linkText("Şarkılar");
        methods.clickElement(songs);
        songNo= songNo+2;
        By firstSong = By.xpath("//div[@role=\"row\" and @aria-rowindex=\""+songNo+"\"]");
        methods.clickElement(firstSong);
        methods.waitByMilliSeconds(100);
        String songName = methods.getText(firstSong);

       By menu1=By.xpath("//div[@role=\"row\" and @aria-rowindex=\""+songNo+"\"]//button[@data-testid=\"more-button\"]");
       methods.clickElement(menu1);
       By addToPlaylist = By.xpath("//button/span[normalize-space()=\"Çalma listesine ekle\"]");
       methods.clickElement(addToPlaylist);

       By playlist = By.xpath("//button/span[normalize-space()=\""+listName+"\"]");
       methods.clickElement(playlist);
        methods.waitBySeconds(2);
        methods.clickElement(songs);

      return songName;
    }

    public void clear() {
        methods.clear(By.xpath("//input[@data-testid=\"search-input\"]"));
        methods.waitBySeconds(1);
    }
}
