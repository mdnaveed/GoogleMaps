package GoogleMaps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/*** Created by Naveed on 24/02/2016. */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/GoogleMaps/googleMapsSearch.feature",
        format = {"html:target/Results", "pretty"}

        )
public class RunCukesTest {

}
