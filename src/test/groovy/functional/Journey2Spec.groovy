package functional

import pages.Footer
import pages.HomePage

class Journey2Spec extends BaseSpec {

    Footer footer = new Footer(driver)
    HomePage homePage = new HomePage(driver)

    def 'should show homepage'(){
        when:
        homePage.navigateToHomePage()

        then:
        homePage.containsAppropriateContent()
    }

    def 'should sign up email' (){
        given:
        homePage.navigateToHomePage()
        footer.scrollToFooter()
        footer.containAppropriateContent()

        when:
        footer.enterEmailInSignUp("testFooter@email.com")
        footer.clickOnSignUpButton()

        then:
        footer.waitForJsInactivity()
        footer.successMessageIsShown()
        footer.assertSuccessMessageContainText("We’ll be in touch with offers, trends and new products")
    }

    def 'should not sign up email and show error message' (){
        given:
        homePage.navigateToHomePage()
        footer.scrollToFooter()

        when:
        footer.enterEmailInSignUp("@email.com")
        footer.clickOnSignUpButton()

        then:
        footer.waitForJsInactivity()
        footer.errorMessageIsShown()
        footer.signUpInputIsUnderlinedByRed()
    }


}
