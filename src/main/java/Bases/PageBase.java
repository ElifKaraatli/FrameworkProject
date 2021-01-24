package Bases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    WebDriverWait wait;
    protected WebDriver driver;

    public void init(WebDriver driver) {
        wait = new WebDriverWait(driver, 20);
        this.driver = driver;
    }

    private WebElement getElement(By by) {
        
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        
    }

    public void clickElement(By by) {
        
        getElement(by).click();
        
    }

    public void sendTextToElement(By by, String str) {
        
        getElement(by).sendKeys(str);
        
    }

    public String getElementText(By by) {
        
        return getElement(by).getText();
        
    }

    public String getElementAttributeValue(By by, String attribute) {
        
        return getElement(by).getAttribute(attribute);
    }

    public String getNonVisibleElementAttributeValue(By by, String atb) {
        return driver.findElement(by).getAttribute(atb);
    }

    public boolean isElementDisplayed(By by) {
        try {
            WebElement element = getElement(by);
            return element.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }

    public void moveToElement(By by) {
        WebElement element = getElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void waitUntilElementDisplayedContainsString(By by, String str) {
        
        wait.until((ExpectedCondition<Boolean>) d -> driver.findElement(by).getText().contains(str));

    }
}
