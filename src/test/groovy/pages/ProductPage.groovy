package pages

import org.openqa.selenium.WebDriver

class ProductPage extends StorePage{

    ProductPage(WebDriver driver) {
        super(driver)
    }

    def isProductPageDisplayed(){
        driver.currentUrl.contains("/p/")
    }

}
