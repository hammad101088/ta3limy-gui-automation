package pageObjectModel;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaqPage {

    //****** variables ******//
    private WebDriver driver;

    //****** constructor ******//
    public FaqPage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//
    /**
     * get text of faq page title
     * @return element locator
     */
    public static By faqPageTitle_text_locator(){ return By.xpath("//*[@id='root']/div/section/div/h1");}

    /**
     * get all page to be used in visual assertion using openCv (a screenshot of the page will be the reference every time to be compared)
     * @return element locator
     */
    public static By questionsAndAnswer_div_locator(int questionOrder){
        return By.xpath("(//div[@class='Collapsible'])["+questionOrder+"]");
        //todo: unreliable locator, should be enhanced.
    }

    //****** keywords ******//

    /**
     * open question
     * @param questionOrder the order of the question on the page
     * @return self-reference to be used in fluent design.
     */
    public FaqPage openQuestion(int questionOrder) {
        (new ElementActions(driver))
                .click(questionsAndAnswer_div_locator(questionOrder));
        return new FaqPage(driver);
    }

}
