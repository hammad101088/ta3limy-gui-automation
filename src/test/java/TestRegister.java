import com.shaft.driver.DriverFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectModel.RegisterPage;
import pageObjectModel.RegisteredUserHomePage;
import pageObjectModel.Ta3limyHomePage;

import java.util.Date;

public class TestRegister {

    Date date = new Date();
    String currentTime_forUniqueFields = date.getTime() + "";
    //****** variables ******//
    private WebDriver driver;
    private JSONFileManager jsonFileManager_registerTestData;

    //****** methods ******//
    @BeforeClass
    public void beforeClass() {
        jsonFileManager_registerTestData = new JSONFileManager(System.getProperty("testDataFolderPath") + "/ta3limy/register.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.getDriver();
    }

    @Test(description = "Test register as a parent")
    @Description("""
            register as a parent
            Steps:
            - open Ta3limy website.
            - open register page.
            - register as a parent.
            - confirm mobile number.
            - assert that user is registered successfully and the home is page opened.
            """)
    public void TestFaq_shouldBeSuccessful() {
        (new Ta3limyHomePage(driver))
                .openTa3limyHomePage()
                .openRegisterPage()
                .register(
                        RegisterPage.userType_enum.parent,
                        jsonFileManager_registerTestData.getTestData("register.firstName"),
                        jsonFileManager_registerTestData.getTestData("register.lastName"),
                        jsonFileManager_registerTestData.getTestData("register.mobilePhone") + currentTime_forUniqueFields.substring(6),
                        RegisterPage.gender_enum.male,
                        Integer.parseInt(jsonFileManager_registerTestData.getTestData("register.ageRange_orderNumber")),
                        jsonFileManager_registerTestData.getTestData("register.password"),
                        jsonFileManager_registerTestData.getTestData("register.confirmPassword"))
                .confirmMobileNumber(
                        Integer.parseInt(jsonFileManager_registerTestData.getTestData("confirmMobileNumber.confirmationNumber")));

        Validations.assertThat()
                .element(driver, RegisteredUserHomePage.addChile_Button_locator())
                .exists()
                .withCustomReportMessage("assert that \"add child\" button is displayed in the home page")
                .perform();
    }

}
