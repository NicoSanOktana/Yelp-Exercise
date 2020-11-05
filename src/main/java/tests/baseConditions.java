package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class baseConditions {

    public static WebDriver driver;

    @BeforeSuite
    // Starts Browser
    // Goes to yelp page
    // Goes to Restaurant section
    // Click and have page ready
    public void before_scenario() throws InterruptedException {
        initialize_browser(10);
        go_to_restaurants_page();
    }
    // @BeforeSuite defined functions
        // Initializes the browser
        private void initialize_browser(int implicit_time_wait) {
            // Point to browser driver
            System.setProperty( "webdriver.chrome.driver",
                                "/Users/nicolassanchez/QATraining" +
                                "/Dependencies/Drivers/chromedriver");
            // Browser driver object
            driver = new ChromeDriver();
            // Maximize windows
            driver.manage().window().maximize();
            // Manage Timeout
            driver.manage().timeouts().implicitlyWait(implicit_time_wait, TimeUnit.SECONDS);
        }

        // Goes to Restaurants search page
        private void go_to_restaurants_page() throws InterruptedException {
            driver.get("https://www.yelp.com/");
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("#find_desc")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")).click();
            //Thread.sleep(2000);
        }

        /*
        @AfterSuite
        public void after_all() throws InterruptedException {
            System.out.println("You can access reports in /test_output ");
            Thread.sleep(3000);
            driver.quit();
        }
        */


}
