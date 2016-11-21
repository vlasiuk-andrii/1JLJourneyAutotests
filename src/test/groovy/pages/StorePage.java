package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

import static java.lang.Thread.sleep;


public class StorePage {

    WebDriver driver;

    public StorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitForMenuItemIsSelected(String menu) {
        new WebDriverWait(this.driver, 10).until(ExpectedConditions.attributeContains(By.xpath("//*[contains (text(), '" + menu + "')]"), "class", "selected"));
    }

    public void waitForLoad(WebDriver driver) {
        try {
            new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        } catch (Throwable error) {
            assertTrue("Timeout waiting for Page Load Request to complete.", true);
        }
    }

    public Object evaluateJavascript(String script, Object... params) {
        return ((JavascriptExecutor) driver).executeScript(script, params);
    }

    public void jsClickElement(WebElement el) {
        if (el.isDisplayed()) {
            evaluateJavascript("arguments[0].click()", el);
        } else {
            throw new RuntimeException("Can't click element. It's not present on the page");
        }
    }

    public void scrollTo(WebElement el){
        evaluateJavascript("arguments[0].scrollIntoView(true);", el);
    }

    public void waitForJsInactivity() {
        waitForJsInactivity(5);
    }

    public void waitForJsInactivity(int seconds) {
        try {
            sleep(500);
            for (int i = 0; i < seconds * 2; i++) {
                if (!evaluateJavascript("return document.readyState").equals("complete")) {
                    sleep(500);
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
