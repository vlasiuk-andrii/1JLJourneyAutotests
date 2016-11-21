package functional

import pages.Footer
import pages.HomePage
import pages.HomePageDesktopSite


class Journey3VisitDesktopSite extends BaseSpec {
    HomePage homePage = new HomePage()
    HomePageDesktopSite homePageDesktopSite = new HomePageDesktopSite()
    Footer footer = new Footer()

    def 'should visit desktop site'(){
        given:
        //homePage.navigateToHomePage()
        //footer.scrollToFooter()

        when:
        footer.clickOnVisitFullSiteLink("http://www.johnlewis.com/?stop_mobi=yes")

        then:
        homePage.waitForJsInactivity()
        homePageDesktopSite.isDesktopSiteNavigated("http://www.johnlewis.com/?stop_mobi=yes") == true
    }

//    def 'should stay on desktop site through out the session'(){
//        when:
//        homePageDesktopSite.navigateToCategory()
//        homePageDesktopSite.navigateToProduct()
//    }
}
