package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class RestaurantsPage {

    //global
    WebDriver driver;
    // Constructor
    public RestaurantsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // @FindBy Annotation (provided by Selenium) to locate Web elements

    // Search Button
    @FindBy( how = How.XPATH, using="//body/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/button[1] ")
    WebElement search_btn;
    // Search Text Field
    @FindBy( css = "#search_description")
    WebElement search_txt_field;
    // Results (counted by the Stars)
    // --> counted by n_stars
    // Filter Checkboxes
    @FindBy( how = How.CSS, using = "input[type='checkbox']")
    List<WebElement> filters_chkbx;
    // Number of stars
    @FindBy( how = How.CSS, using = "div[class*='i-stars']")
    List<WebElement> n_stars;
    // Search Results on page (given by @DataProvider Filters)
    @FindBy(how = How.CSS,using = "h4[class=' heading--h4__09f24__2ijYq alternate__09f24__39r7c']") //remember to ignore sponsored results --> bc they omit filters
    List<WebElement> search_results;
    // Checked Filters (checkboxes)
    @FindBy(how = How.CSS, using = "input:checked")
    List<WebElement> checked_filters;

    /////////////////////////////////////////// METHODS ///////////////////////////////////////

    // Appends 'Pizza' to 'Restaurant' & search
    public void search_restaurant_pizza() throws InterruptedException {
        search_txt_field.click();
        search_txt_field.clear();
        search_txt_field.sendKeys("Restaurant Pizza");
        Thread.sleep(3000);
        search_btn.click();
        Thread.sleep(3000);
    }

    // Report number of results given by previous method, in current page
    public void report_n_results(String test_name) throws InterruptedException {
        int n_results = n_stars.size();
        Reporter.log(test_name+": There are "+ Integer.toString(n_results-2) +
                        " Pizza Restaurant results in current page.", true);
        Thread.sleep(3000);
    }

    // Selects Filter parameters given by @DataProvider and searches
    //      --> Finds parameter in checkboxes List, selects and makes the search
    public void select_filter_param_and_search(String filter1,String filter2) throws InterruptedException {

        for(WebElement we: filters_chkbx){
            String we_value = we.getAttribute("value");
            if(we_value.equals(filter1) || we_value.equals(filter2) ){
                we.click();
                Thread.sleep(2000);
            }
        }
        Thread.sleep(3000);

        //search_btn.click(); DO NOT CLICK SEARCH. IT DELETES SELECTED CHECK BOXES
    }

    // Reports number of stars of each result
    public void report_n_stars() throws InterruptedException {
        int s = 1;
        for (WebElement we : n_stars) {
            String star_rating = we.getAttribute("aria-label");
            Reporter.log("Number of stars of Result[" + Integer.toString(s) + "]: " + star_rating + "<br>");
            s += 1;
        }
        Thread.sleep(3000);
    }

    // Click on first result (under 'All Result' [~Sponsored] )
    public void click_first_result() throws InterruptedException {
        WebElement first_result = search_results.get(2); // We retrieve third element of list (first 2 are sponsored results)
        first_result.click();
        Thread.sleep(3000);
    }

    public void deselect_all_filters() throws InterruptedException {
        for(WebElement chckbx:checked_filters){
            if(chckbx.isSelected()) { chckbx.click();}
        }
        search_btn.click(); // make sure they are all deselected (search btn does that)
        Thread.sleep(5000);
    }
}

