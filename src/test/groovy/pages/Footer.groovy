package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class Footer extends StorePage {

    @FindBy(css = ".footer-site-wide")
    private WebElement footer;

    @FindBy(css = ".footer-help.u-separator.footer-section")
    private WebElement footerNeedHelpSection;

    @FindBy(css = ".footer-feedback-link.u-separator.u-centred.footer-section")
    private WebElement footerSendFeedbackSection;

    @FindBy(css = ".footer-sign-up.u-separator.footer-section")
    private WebElement footerSignUpSection;

    @FindBy(css = ".sub-footer")
    private WebElement footerSubSection;

    @FindBy(css = "#email-sign-up")
    private WebElement emailSignUpInput;

    @FindBy(css = "[class~='input--invalid']")
    private WebElement emailSignUpUnderlinedInput;

    @FindBy(css = "#button--sign-up-submit")
    private WebElement emailSignUpButton;

    @FindBy(css = ".u-icon.u-icon--positive-feedback.u-zero-spacing")
    private WebElement successSignUpMessage;

    @FindBy(css = ".u-icon u-icon--negative-feedback email-valid-info u-icon--centred")
    private WebElement errorSignUpMessage;

    Footer(WebDriver driver) {
        super(driver)
    }

    public void enterEmailInSignUp(String email) {
        emailSignUpInput.sendKeys(email)
    }

    public void scrollToFooter(){
        scrollTo(footer)
    }

    public void containAppropriateContent(){
    footerNeedHelpSection.isDisplayed()
    footerSendFeedbackSection.isDisplayed()
    footerSignUpSection.isDisplayed()
    footerSubSection.isDisplayed()
    }

    public void clickOnSignUpButton(){
        emailSignUpButton.click()
    }

    public void successMessageIsShown(){
        successSignUpMessage
    }

    public void errorMessageIsShown(){
        errorSignUpMessage
    }

    public void assertSuccessMessageContainText(String messageText){
        assert successSignUpMessage.getText() == messageText
    }

    public void signUpInputIsUnderlinedByRed(){
        emailSignUpUnderlinedInput
    }

    public void clickOnVisitFullSiteLink(String linkText){
        getDriver().findElement(By.cssSelector("a[href='" + linkText + "']"))
    }
}
