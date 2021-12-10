package pageObjectModel;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    //****** Enums ******//
    public static enum userType_enum{
        parent,student,teacher
    }

    public static enum gender_enum{
        male,female
    }

    //****** variables ******//
    private WebDriver driver;

    //****** constructor ******//
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//
    /**
     * get user type
     * @param userType type of the user (Parent - student - teacher). use it like this: "RegisterPage.userType_enum.{the desired value}"
     * @return element locator
     */
    private static By userType_button_locator(userType_enum userType){
        return By.xpath("//label[@for='" + userType + "']");
    }

    /**
     * get first name input
     * @return element locator
     */
    private static By firstName_input_locator(){
        return By.id("firstName");
    }

    /**
     * get last name input
     * @return element locator
     */
    private static By lastName_input_locator(){
        return By.id("lastName");
    }

    /**
     * get mobile number input
     * @return element locator
     */
    private static By mobileNumber_input_locator(){
        return By.id("mobileNumber");
    }

    /**
     * get gender input
     * @param gender the gender of the user (male - female). use it like this: "RegisterPage.gender_enum.{desiredValue}"
     * @return element locator
     */
    private static By gender_input_locator(gender_enum gender){
        return By.xpath("//label[@for='" + gender + "']");
    }

    /**
     * get age range drop down menu
     * @param ageRangeNumber age range number. starts from 2. [2 = under 25 | 3 = from 25 to 35 | 4 = from 35 to 45 | 5 = 45 to 55 | 6 = above 55]
     * @return element locator
     */
    private static By ageRange_dropDownMenu_locator(int ageRangeNumber){
        return By.xpath("//select[@id='ageRange']//option[" + ageRangeNumber + "]");
    }
    /**
     * get password input
     * @return element locator
     */
    private static By password_input_locator(){
        return By.id("password");
    }

    /**
     * get password confirmation input
     * @return element locator
     */
    private static By passwordConfirmation_input_locator(){
        return By.id("passwordConfirmation");
    }

    /**
     * get terms and conditions checkbox
     * @return element locator
     */
    private static By termsAndConditions_checkBox_locator(){
        return By.xpath("//label[@for='termsAndConditionsCheck']");
    }

    /**
     * get google captcha.
     * it's not a best practice to automate google captcha. please refer to this link: https://www.selenium.dev/documentation/test_practices/discouraged/captchas/
     * @return element locator
     */
    private static By captcha_locator(){
        return By.id("googleRecaptcha");
    }

    /**
     * get register button.
     * @return element locator
     */
    private static By register_button_locator(){
        return By.xpath("//button[@data-cy='submitButton']");
    }

    //****** keywords ******//
    /**
     * Register a new account
     * @param userType type of the user (Parent - student - teacher). use it like this: "RegisterPage.userType_enum.{the desired value}"
     * @param firstName user's first name
     * @param lastName user's last name
     * @param mobileNumber user's mobile number. should be unique
     * @param gender gender of the user (male - female). use it like this: "RegisterPage.gender_enum.{desiredValue}"
     * @param ageRangeNumber age range number. starts from 2. [2 = under 25 | 3 = from 25 to 35 | 4 = from 35 to 45 | 5 = 45 to 55 | 6 = above 55]
     * @param password user's password
     * @param confirmPassword user's confirmation password
     * @return self-reference to be used in method chaining.
     */
    public VerificationCodePage register(userType_enum userType, String firstName, String lastName, String mobileNumber, gender_enum gender, int ageRangeNumber, String password, String confirmPassword){
        (new ElementActions(driver))
                .click(userType_button_locator(userType))
                .type(firstName_input_locator(),firstName)
                .type(lastName_input_locator(),lastName)
                .type(mobileNumber_input_locator(),mobileNumber)
                .click(gender_input_locator(gender))
                .click(ageRange_dropDownMenu_locator(ageRangeNumber))
                .type(password_input_locator(),password)
                .type(passwordConfirmation_input_locator(),confirmPassword)
                .click(termsAndConditions_checkBox_locator())
                .click(captcha_locator())
                .click(register_button_locator());

        return new VerificationCodePage(driver);
    }

}
