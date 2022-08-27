package testmaster.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {

    Methods methods;

    public HomePage(){

        methods = new Methods();
    }

    public void loginControl(String username){

        String usernameElement = "figure[data-testid=\"user-widget-avatar\"]" +
                "[title=\""+ username+"\"]";

        Assertions.assertTrue(methods.isElementVisible(By.cssSelector(usernameElement),20));
        String usernameTitle = methods.getAttribute(By.cssSelector("figure[data-testid=\"user-widget-avatar\"]"),"title");
        Assertions.assertEquals(username, usernameTitle);
        String actualUserName = methods.getText(By.cssSelector("figure[data-testid=\"user-widget-avatar\"][title=\"YunusB\"]" +
                " ~ span[data-testid=\"user-widget-name\"]"));
        Assertions.assertEquals(username, actualUserName);
    }
    public void clickSearch(){
        By searchLink = By.cssSelector("a[href=\"/search\"]");
        methods.clickElement(searchLink);
    }

}
