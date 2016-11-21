package pages

import functional.BaseSpec
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy


class HomePage extends StorePage {

    @FindBy(css = "body>header.header-site-wide")
    private WebElement header

    @FindBy(css = "body>main.home-main")
    private WebElement main

    @FindBy(css = "body>footer.footer-site-wide")
    private WebElement footer

    BaseSpec baseSpec = new BaseSpec()

    HomePage(WebDriver driver) {
        super(driver)
    }

    public void navigateToHomePage(){
        driver.get(BaseSpec.WEB_SERVER)

    }

    public void containsAppropriateContent(){
        header
        main
        footer
    }


}
