package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseModel {
    WebDriver webDriver;

    public BaseModel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void click(By byElement, int timeOut) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
    }

    public String getText(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).getText();
    }

    public void scrollDown(String input){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript(input);
    }

    public void hover(WebElement webElement) throws InterruptedException {
        Actions action = new Actions(webDriver);
        action.moveToElement(webElement).perform();
        Thread.sleep(5000);
    }
}
