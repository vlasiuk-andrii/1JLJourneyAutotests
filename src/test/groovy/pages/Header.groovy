package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class Header extends StorePage {

    @FindBy(css = ".u-icon--menu")
    private WebElement menuIcon;

    @FindBy(css = ".menu a")
    List<WebElement> menuItems;

    public Header(WebDriver driver) {
        super(driver)
    }

    public void clickMenuIcon() {
        menuIcon.click()
    }

    public int getMenuItemsNumber() {
        menuItems.size()
    }

    public void clickMenuItemByName(String menuItem) {
        getDriver().findElement(By.xpath("//a[contains (text(), '" + menuItem + "')]")).click()
    }

    public void clickMenuItemByName(String subSection, String menuItem) {
        getDriver().findElement(By.xpath("//h4[contains (text(), '" + subSection + "')]//following::a[contains (text(), '" + menuItem + "')]")).click()
    }

}
