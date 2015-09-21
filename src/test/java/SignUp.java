import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUp {
    @Step("enter signup username <USERNAME>")
    public void enterUserName(String username) {
        WebElement userEmailId = DriverFactory.driver.findElement(By.id("user_email_id"));
        userEmailId.sendKeys(username);
    }

    @Step("enter signup password <step2014>")
    public void enterPassword(String password) {
        WebElement userPassword = DriverFactory.driver.findElement(By.id("user_password"));
        userPassword.sendKeys(password);
    }
}
