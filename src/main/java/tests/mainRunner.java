package tests;


import dataProvider.dataprovider;
import org.testng.annotations.Test;
import pages.RestaurantsPage;
import pages.ResultPage;

public class mainRunner extends baseConditions{

    // Pages to work with
    public RestaurantsPage restaurant_page;
    public ResultPage result_page;

    // Report the result of search (no filters)
    @Test(priority=0)
    public void results_no_filter() throws InterruptedException {
        restaurant_page = new RestaurantsPage(driver);
        restaurant_page.search_restaurant_pizza();
        restaurant_page.report_n_results("Non Filtered Search");
    }

    // Report the result of parametrized filtered search
    @Test(priority = 1, dataProvider = "filter-checkbox", dataProviderClass = dataprovider.class)
    public void results_with_filters(String filter1, String filter2) throws InterruptedException {
        restaurant_page = new RestaurantsPage(driver);
        restaurant_page.select_filter_param_and_search(filter1,filter2);
        // Report No. Results
        restaurant_page.report_n_results("Filtered Search");
        //Report No. Stars f/ each result
        restaurant_page.report_n_stars();
        restaurant_page.deselect_all_filters();
    }

    // Expands first result and reports info
    @Test(priority = 2, dataProvider = "filter-checkbox", dataProviderClass = dataprovider.class)
    public void information_first_result(String filter1, String filter2) throws InterruptedException {

        restaurant_page = new RestaurantsPage(driver);
        restaurant_page.select_filter_param_and_search(filter1,filter2);
        // On Restaurants page: goes to result page
        restaurant_page = new RestaurantsPage(driver);
        restaurant_page.click_first_result();

        // On Result Page: reports info
        result_page = new ResultPage(driver);
        // Reports info
        result_page.report_website();
        result_page.report_phone_number();
        result_page.report_address();
        result_page.goes_to_restaurant_page();
        //result_page.report_reviews();
        restaurant_page.deselect_all_filters();


    }


}
