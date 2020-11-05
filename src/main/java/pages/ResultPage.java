package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class ResultPage {

    // Global variables
    WebDriver driver;

    // Constructor
    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // @FindBy Annotation (provided by Selenium) to locate Web elements
    // All are listed as List objects because we need to check for it's existence so that the program doesn't stop the execution
    // link to website
    @FindBy( how = How.XPATH, using="//a[contains(text(),'.com')]")
    List<WebElement> web_site_lnktxt;
    // phone number
    @FindBy( how = How.XPATH, using="//p[contains( text(),'(4' )]")
    List<WebElement> phone_number;
    // Get Directions Link
    @FindBy( how = How.LINK_TEXT, using="Get Directions")
    List<WebElement> get_directions_lnktxt;
    // Address
    @FindBy( how = How.CSS, using="div > address")
    List<WebElement> address;
    // Reviews
    @FindBy( how = How.CSS, using="span[lang='en']")
    List<WebElement> reviews;


    ///////////////////////////////////////////  METHODS ///////////////////////////////////////
    // Reports WebSite address
    public void report_website() throws InterruptedException {
        if (web_site_lnktxt.size() > 0) {
            String web_site = web_site_lnktxt.get(0).getText();
            Reporter.log("Website Page: " + web_site + " <br>",true);
        }else{ Reporter.log("Result info: 0 references to Website page found",true);}
        Thread.sleep(500);
    }

    // Reports Phone Number
    public void report_phone_number() throws InterruptedException {
        if (phone_number.size() > 0) {
            String ph_number = phone_number.get(0).getText();
            Reporter.log("Phone number: "+ph_number+" <br>",true);
        }else{ Reporter.log("Result info: 0 references to phone number found",true);}
        Thread.sleep(500);
    }

    // Reports address & returns
    public void report_address() throws InterruptedException {
        if (get_directions_lnktxt.size() > 0) {
            get_directions_lnktxt.get(0).click();
            Thread.sleep(1500);
            String address_string = address.get(0).getText();
            Reporter.log("Address: "+address_string+" <br>",true);
            driver.navigate().back();
            Thread.sleep(3000);
        }else{ Reporter.log("Result info: 0 references to address found",true);}
        Thread.sleep(500);
    }

    // Reports first n reviews
    public void report_reviews(int n_reviews) throws InterruptedException {

        try {
            if (reviews.size() < n_reviews) throw new Exception();
        }
        catch(Exception exception){
            Reporter.log("Reviews: Not enough reviews to report.");
        }

        int r = 1;

        for(WebElement rev:reviews){
            String review_msg = rev.getText();
            Reporter.log("Review no. "+Integer.toString(r)+": ' "+review_msg+" ' <br>");
            if(r == n_reviews) break;
            r+=1;

        }
        Thread.sleep(500);
    }

    public void goes_to_restaurant_page() throws InterruptedException {
        driver.navigate().back(); Thread.sleep(5000);
    }

}
