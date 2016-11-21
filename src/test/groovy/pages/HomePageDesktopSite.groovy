package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class HomePageDesktopSite extends StorePage {

    @FindBy(css = "")
    private WebElement category

    HomePageDesktopSite(WebDriver driver) {
        super(driver)
    }

    public boolean isDesktopSiteNavigated(String fullSiteUrl) {
        return getDriver().getCurrentUrl() == fullSiteUrl
    }

    public void navigateToCategory(){

    }
}
