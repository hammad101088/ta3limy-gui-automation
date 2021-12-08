import com.shaft.driver.DriverFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectModel.FaqPage;
import pageObjectModel.Ta3limyHomePage;

public class TestFaq {

    //****** variables ******//
    private WebDriver driver;
    private JSONFileManager jsonFileManager_faqTestData;

    //****** methods ******//
    @BeforeClass
    public void beforeClass() {
        jsonFileManager_faqTestData = new JSONFileManager(System.getProperty("testDataFolderPath") + "/ta3limy/faq.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.getDriver();
    }

    @Test(description = "Test common questions/answers page")
    @Description("""
            Validating the common questions/answers page content displayed properly
            Steps:
            - open Ta3limy website.
            - open common questions/answers page.
            - Check that page content displayed properly.
            """)
    public void TestFaq_shouldBeSuccessful() {
        (new Ta3limyHomePage(driver))
                .openTa3limyHomePage()
                .openFaqPage()
                .openQuestion(1);

        Validations.verifyThat()
                .element(driver, FaqPage.questionsAndAnswer_div_locator(1))
                .matchesReferenceImage()
                .withCustomReportMessage("using AI library (openCv) for visual testing to assert that the desired question and answer are displayed correctly")
                .perform();

        //if the previous AI assertion failed for any reason, the code will proceed with the following assertion (to make it less flakiness)
        Validations.assertThat()
                .element(driver, FaqPage.faqPageTitle_text_locator())
                .text()
                .isEqualTo(jsonFileManager_faqTestData.getTestData("faq.pageTitle_expectedResults"))
                .withCustomReportMessage("assert that page title is correct")
                .perform();


    }

}
