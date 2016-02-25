package GoogleMaps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Naveed on 22/02/2016.
 */
public class StepDefinitions {

    WebDriver driver = null;
    By resultElement = By.xpath("/html/body/jsl/div[3]/div[5]/div[6]/div/div[1]/div/div[1]/div[2]/div/h1");
    By searchBox = By.id("searchboxinput");
    static String gmailMapURL = "https://www.google.co.uk/maps";
    static final int TIME_10_S = 10000; /*10s Wait is introduced to avoid intermittent failures due to Maps while Loading*/

    @Given("^User is on the Google maps main page$")
    public void userIsOnGoogleMapsMainPage() throws InterruptedException {

        /* Instantiate the FirefoxBrowser */
        driver = new FirefoxDriver();

        /* Go to google maps */
        driver.get(gmailMapURL);

        /* An Alternative to avoid Intermittent failures using PageLoadTimeout Explicit wait of 10 seconds
         using "driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);" */
        Thread.sleep(TIME_10_S);

        /* Maximizing the Window after the Page is loaded */
        driver.manage().window().maximize();

        /* Verify that the user is on the Main Page */
        Assert.assertTrue(driver.getTitle().equals("Google Maps"));
    }

    @When("^User search for a location as \"([^\"]*)\"$")
    public void userSearchLocation(String searchKeys) {

        /* Explicit wait to element present check is now not required as the page is assumed as fully loaded */
        driver.findElement(searchBox).sendKeys(searchKeys);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }

    @Then("^User should see the results for the location searched as\"([^\"]*)\"$")
    public void userReceivesTheResponse(String expectedResult) {

        /* Wait to see the resultElement is available for the response */
        WebDriverWait setWaitForElementPresent = new WebDriverWait(driver,60);
        setWaitForElementPresent.until(ExpectedConditions.visibilityOfElementLocated(resultElement));

        /*Get the actualResult text from returned element */
        String actualResult = driver.findElement(resultElement).getText();

        /*Verifying the Response to the search request*/
        Assert.assertTrue(actualResult.equals(expectedResult));
    }

    @And("^User close the Browser$")
    public void userCloseTheBrowsers(){
        //Close all the Browser instances
        driver.quit();
    }
}
