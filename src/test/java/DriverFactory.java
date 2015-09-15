import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static WebDriver driver;

    @BeforeSuite
    public void setup(){ driver = new FirefoxDriver(); }

    @AfterSuite
    public void teardown(){
        driver.close();
    }

    @Step("Navigate to <URL>")
    public void navigateTo(String url) {
        driver.get(url);
    }
}
