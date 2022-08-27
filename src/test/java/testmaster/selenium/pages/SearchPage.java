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

    public void searchArtist(String artistName){
        methods.sendKeys(By.xpath("//input[@data-testid=\"search-input\"]"), artistName);
    }

    public void artistControl(String artistName) {
        By element = By.xpath("//div[@data-testid=\"top-result-card\"]//a");
        assertTrue(methods.getText(element).equalsIgnoreCase(artistName));
    }
}
