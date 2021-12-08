package pageObjectModel;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerificationCodePage {

    //****** variables ******//
    private final WebDriver driver;

    //****** constructor ******//
    public VerificationCodePage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//

    /**
     * get confirmation code input
     *
     * @return element locator
     */
    private static By confirmationCode_input_locator() {
        return By.id("confirmationCode");
    }

    /**
     * get google captcha
     * it's not a best practice to automate google captcha. please refer to this link: https://www.selenium.dev/documentation/test_practices/discouraged/captchas/
     *
     * @return element locator
     */
    private static By googleCaptcha_locator() {
        return By.id("googleRecaptcha");
    }

    /**
     * get submit button
     *
     * @return element locator
     */
    private static By submit_Button_locator() {
        return By.xpath("//button[@data-cy='submitButton']");
    }


    //****** keywords ******//

    /**
     * confirm mobile number
     * @param ConfirmationNumber  6 digits number
     * @return
     */
    public RegisteredUserHomePage confirmMobileNumber(int ConfirmationNumber) {
        (new ElementActions(driver))
                .type(confirmationCode_input_locator(), String.valueOf(ConfirmationNumber))
                .click(googleCaptcha_locator())
                .click(submit_Button_locator());
        return new RegisteredUserHomePage(driver);
    }
}
