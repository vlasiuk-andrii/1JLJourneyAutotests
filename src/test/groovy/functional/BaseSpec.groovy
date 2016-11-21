package functional

import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.phantomjs.PhantomJSDriverService
import org.openqa.selenium.remote.DesiredCapabilities
import spock.lang.Shared
import spock.lang.Specification

class BaseSpec extends Specification {

    public static String getProjectProperty(String propertyName) {
        String property = "null"
        Properties projectProperties = new Properties();
        FileInputStream input = new FileInputStream("gradle.properties");
        projectProperties.load(input);

        for (String propertyValue : projectProperties){
            if(propertyValue.contains(propertyName)){
                property = projectProperties[propertyName]
            }
        }
        return property
    }

    protected static final String WEB_SERVER = getProjectProperty('WEB_SERVER')
    protected static final String BROWSER = getProjectProperty('BROWSER')
    

    /***** this block will be used for passing variables via command line*****/
   /* protected static final String WEB_SERVER = System.getProperty("WEB_SERVER", "https://test.onejl.uk");
    protected static final String BROWSER = System.getProperty("BROWSER", "firefox");*/

    @Shared
    WebDriver driver;

    def setupSpec() {
        if (BROWSER.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (BROWSER.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (BROWSER.equals("internetExplorer")) {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(capabilities);
        } else if (BROWSER.equals("phantomjs")){
             Capabilities caps = new DesiredCapabilities();
            ((DesiredCapabilities) caps).setJavascriptEnabled(true);
            ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
            ((DesiredCapabilities) caps).setCapability(
                    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "src\\test\\resources\\phantomjs.exe");
            driver = new  PhantomJSDriver(caps);
        } else {
            throw new RuntimeException("Browser type unsupported");
        }
        driver.get(WEB_SERVER)
    }

    def cleanupSpec() {
        driver.quit()
    }
}

