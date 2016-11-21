package functional

import pages.Header
import pages.ProductListingPage
import pages.ProductPage

class Journey1Spec extends BaseSpec {

    Header header = new Header(driver)
    ProductPage productPage = new ProductPage(driver)
    ProductListingPage productListingPage = new ProductListingPage(driver)

    //TODO
    def 'a user should see the content from home page'(){

    }

    def 'a user selects #menu_item and sees PLP and pagination listing' (){
        given:
        header.waitForLoad(driver)
        header.clickMenuIcon()
        header.clickMenuItemByName("Electricals")
        header.waitForMenuItemIsSelected("Electricals")
        header.clickMenuItemByName("Washing Machines")
        header.waitForMenuItemIsSelected("Washing Machines")

        when:
        def menu_item = "All Washing Machines"
        header.clickMenuItemByName(menu_item)

        then:
        productListingPage.isProductsGridDisplayed()
        productListingPage.isFilterDisplayed()
        productListingPage.isFilterContainsText("Filter products")
        productListingPage.isSortDisplayed()
        productListingPage.isSortContainsText("Sort by: Default view")
        productListingPage.isProductsNumberOnPLPDisplayed()
        productListingPage.isMenuNameOnPLPDisplayed(menu_item)
        productListingPage.getPaginationListSize() == 5
    }

    def 'the product listing pagination works correctly and page details are correct'(){
        when:
        productListingPage.clickPageNumber(1)
        productListingPage.isProductsGridDisplayed()
        productListingPage.isPageNumberActive(1)
        productListingPage.clickPageNumber(0)

        then:
        productListingPage.isProductsGridDisplayed()
        productListingPage.isPageNumberActive(0)
    }

    def 'a user selects #first_product and sees product page is displayed'(){
        when:
        def first_product = 0;
        productListingPage.clickProduct(first_product)

        then:
        productPage.isProductPageDisplayed()
    }

}
