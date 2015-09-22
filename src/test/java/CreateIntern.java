import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class CreateIntern {
    @Step("Click on <GROUP NAME>")
    public void clickOnGroup(String groupName) {
        WebElement groupContainer = DriverFactory.driver.findElement(By.name(groupName));
        groupContainer.click();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    @Step("Click on create intern")
    public void clickOnCreateInternButton() {
        WebElement createInternButton = DriverFactory.driver.findElement(By.linkText("CREATE INTERN"));
        createInternButton.click();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Step("Enter firstname <FIRSTNAME>")
    public void enterFirstName(String firstname) {
        WebElement nameElement = DriverFactory.driver.findElement(By.name("firstName"));
        nameElement.sendKeys(firstname);
    }

    @Step("Enter lastname <LASTNAME>")
    public void enterLastName(String lastname) {
        WebElement lastNameElement = DriverFactory.driver.findElement(By.name("lastName"));
        lastNameElement.sendKeys(lastname);
    }

    @Step("Select date of birth <DAY>, <MONTH>, <YEAR>")
    public void setDOB(String day, String month, String year) {
        WebElement date_day = DriverFactory.driver.findElement(By.id("date_day"));
        date_day.sendKeys(day);
        WebElement date_month = DriverFactory.driver.findElement(By.id("date_month"));
        date_month.sendKeys(month);
        WebElement date_year = DriverFactory.driver.findElement(By.id("date_year"));
        date_year.sendKeys(year);
    }

    @Step("Varify intern <INTERN NAME>")
    public void verifyIntern(String internName) {
        WebElement name = DriverFactory.driver.findElement(By.className("first-name"));
        assertEquals(internName, name.getText());
    }
}
