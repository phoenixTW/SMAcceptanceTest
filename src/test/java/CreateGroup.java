import com.sun.tools.javac.util.Name;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreateGroup {
    private List<String> getAllItemsName() {
        WebElement element = DriverFactory.driver.findElements(By.className("batch-list-container")).get(0);
        List<String> itemList = new ArrayList<String>();

        for (WebElement item : element.findElements(By.className("group-tab")))
            itemList.add(item.getText());

        return itemList;
    }

    @Step("enter name <NAME>")
    public void setGroupName(String name) {
        WebElement nameElement = DriverFactory.driver.findElement(By.name("name"));
        nameElement.sendKeys(name);
    }

    @Step("enter description <This batch started on 2013 and ended on 2015>")
    public void setDescription(String description) {
        WebElement descElement = DriverFactory.driver.findElement(By.name("description"));
        descElement.sendKeys(description);
    }

    @Step("click save button")
    public void clickOnSave() {
        WebElement saveButton = DriverFactory.driver.findElement(By.id("save-group-btn"));
        saveButton.click();
    }

    @Step("Ensure results contain following products <GROUPS>")
    public void varifyGroups(Table groups) {
        List<String> columnValues = groups.getColumnValues("Item name");
        List<String> items = getAllItemsName();
        for (int index = 0; index < columnValues.size(); index++) {
            assertEquals(columnValues.get(index), items.get(index));
        }
    }

    @Step("click create group button")
    public void clickOnCreateGroupButton() {
        WebElement createGroupButton = DriverFactory.driver.findElement(By.id("create-button-link"));
        createGroupButton.click();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
