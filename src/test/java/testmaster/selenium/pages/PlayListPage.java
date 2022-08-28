package testmaster.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayListPage {

        Methods methods;

        public PlayListPage () {
                methods= new Methods();
        }
        public void controlAddPlaylist() {
                assertTrue(methods.isElementVisible(By.xpath("//input[@role=\"searchbox\"]"),20));
        }

        public void clickPlaylist(){
                By addPlaylistElement =  By.xpath("//section[@role=\"presentation\"]//span//button//span");
                methods.clickElement(addPlaylistElement);
        }
        public void controlEditPlaylist() {
                assertTrue(methods.isElementVisible(By.xpath("//input[@data-testid=\"playlist-edit-details-name-input\"]"),20));
        }


        public void editPlaylist(String playlistName)  {
                methods.sendKeys(By.xpath("//input[@data-testid=\"playlist-edit-details-name-input\"]"), playlistName);
               By saveButton= By.xpath("//button[@data-testid=\"playlist-edit-details-save-button\"]");
                methods.clickElement(saveButton);
                try {
                        Thread.sleep(4000);
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                }
        }
        public void isPlaylistEdited(String playlistName) {

              By listName = By.xpath("//section[@data-testid=\"playlist-page\"]//button//h1");
              String playlistNameFound= methods.getText(listName);
                Assertions.assertEquals(playlistName,playlistNameFound);

        }

    public void playSecondSong() {
            /*
            methods.waitByMilliSeconds(100);
        By secondSong = By.xpath("//div[@role=\"row\" and @aria-rowindex=\"3\"]//div[@data-testid=\"tracklist-row\"]");
        methods.hoverElement(secondSong);
        By secondSongButton = By.xpath("//div[@role=\"row\" and @aria-rowindex=\"3\"]//button");
        methods.clickElement(secondSongButton);
        
             */
    }

    public void deleteThirdSong() {
            methods.waitBySeconds(2);
        By firstSong = By.xpath("//div[@role=\"row\" and @aria-rowindex=\"4\"]");
        methods.clickElement(firstSong);
        methods.waitByMilliSeconds(100);
        By menu1=By.xpath("//div[@role=\"row\" and @aria-rowindex=\"4\"]//button[@data-testid=\"more-button\"]");
        methods.clickElement(menu1);
        By addToPlaylist = By.xpath("//button/span[normalize-space()=\"Bu çalma listesinden kaldır\"]");
        methods.clickElement(addToPlaylist);
    }
}

