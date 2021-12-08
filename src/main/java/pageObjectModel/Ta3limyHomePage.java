package pageObjectModel;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Ta3limyHomePage {

    //****** variables ******//
    private final WebDriver driver;
    private final String Ta3limyHomePage_url = "https://www.ta3limy.com/";

    //****** constructor ******//
    public Ta3limyHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//

    /**
     * get Help menu button
     *
     * @return element locator
     */
    private static By helpMenu_button_locator() {
        return By.id("help-menu");
    }

    /**
     * get Faq button
     *
     * @return element locator
     */
    private static By faq_button_locator() {
        return By.xpath("//a[@data-cy='faq-menuItem']");
    }

    /**
     * get Register button
     *
     * @return element locator
     */
    private static By Register_button_locator() {
        return By.xpath("(//a[@href='/register'])[1]");
    }

    //****** keywords ******//

    /**
     * open Ta3limy Home Page.
     *
     * @return self-reference to be used in fluent design.
     */
    public Ta3limyHomePage openTa3limyHomePage() {
        BrowserActions.navigateToURL(driver, Ta3limyHomePage_url);
        return new Ta3limyHomePage(driver);
    }

    /**
     * open faq page.
     *
     * @return self-reference to be used in fluent design.
     */
    public FaqPage openFaqPage() {
        (new ElementActions(driver))
                .click(helpMenu_button_locator())
                .click(faq_button_locator());
        return new FaqPage(driver);
    }

    /**
     * open Register page.
     *
     * @return self-reference to be used in fluent design.
     */
    public RegisterPage openRegisterPage() {
        (new ElementActions(driver))
                .click(Register_button_locator());
        return new RegisterPage(driver);
    }


}
