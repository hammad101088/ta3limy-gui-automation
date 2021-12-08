package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisteredUserHomePage {

    //****** variables ******//
    private final WebDriver driver;

    //****** constructor ******//
    public RegisteredUserHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//
    /**
     * get add child button
     *
     * @return element locator
     */
    public static By addChile_Button_locator() {
        return By.xpath("//a[@data-cy='addChild-link']");
    }




    //****** keywords ******//
}
