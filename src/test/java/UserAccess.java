import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class UserAccess {
    @Step("enter  username <USERNAME>")
    public void setUserName(String userName) {
        WebElement userNameElement = DriverFactory.driver.findElement(By.id("session_email_id"));
        userNameElement.sendKeys(userName);
    }

    @Step("enter password <PASSWORD>")
    public void setPassword(String password) {
        WebElement passwordElement = DriverFactory.driver.findElement(By.id("session_password"));
        passwordElement.sendKeys(password);
    }

    @Step("click submit")
    public void clickOnLogin() {
        WebElement submitButton = DriverFactory.driver.findElement(By.name("commit"));
        submitButton.click();
    }

    @Step("Verify text <Varifier>")
    public void varifyUser(String verifierText) {
        WebElement link = DriverFactory.driver.findElement(By.id("top-nav-label"));
        int indexOfVarifierText = link.getText().indexOf(verifierText);
        assertTrue(indexOfVarifierText > -1);
    }
}
