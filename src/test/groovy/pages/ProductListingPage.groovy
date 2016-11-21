package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy


class ProductListingPage extends StorePage {

    @FindBy(css = ".product-list-container a")
    List<WebElement> products

    @FindBy(css = ".product-list-container")
    WebElement container

    @FindBy(css = ".pagination-item")
    List<WebElement> paginationList

    @FindBy (css = "#filterProductsLink")
    WebElement filterField

    @FindBy (css = ".product-sort")
    WebElement sortField

    @FindBy (css = ".bin-count")
    WebElement productsNumberOnPLP

    @FindBy (css = "main h1")
    WebElement menuNameOnPLP


    public ProductListingPage(WebDriver driver) {
        super(driver)
    }

    public void clickProduct(int index) {
        products.get(index).click()
    }

    public boolean isProductsGridDisplayed() {
        container.isDisplayed()
    }

    public int getPaginationListSize() {
        paginationList.size()
    }

    public void clickPageNumber(int number) {
        paginationList.get(number).click()
    }

    public boolean isPageNumberActive(int number) {
        paginationList.get(number).findElement(By.tagName("span")).getAttribute("class").contains("active")
    }

    def isFilterDisplayed(){
        filterField.isDisplayed()
    }

    def isFilterContainsText(String text){
        filterField.getText().contains(text)
    }

    def isSortDisplayed(){
        sortField.isDisplayed()
    }

    def isSortContainsText(String text){
        sortField.getText().contains(text)
    }

    def isProductsNumberOnPLPDisplayed(){
        productsNumberOnPLP.isDisplayed()
    }

    def isMenuNameOnPLPDisplayed(String menuName){
        menuNameOnPLP.getText().contains(menuName)
    }
}
