package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class HomePageDesktopSite extends StorePage {

    @FindBy(css = "li>a[data-pos = '1,1']")
    private WebElement linkToAllProductsOfCategory

    @FindBy(css = 'div.result-row>article.first')
    private WebElement firstProductInList

    HomePageDesktopSite(WebDriver driver) {
        super(driver)
    }

    public boolean isOnHomePageDesktopSite(String fullSiteUrl) {
        return getDriver().getCurrentUrl() == fullSiteUrl
    }

    public void navigateToCategory(String categoryName){
        getDriver().findElement(By.cssSelector("li>a:contains('" + categoryName + "')")).click()
    }

    public void navigateToAllProducts(){
        linkToAllProductsOfCategory.click()
    }

    public void navigateToFirstProduct(){
        firstProductInList.click()
    }

}
