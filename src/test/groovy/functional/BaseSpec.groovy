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

   public static Properties useProperties() {
        FileInputStream input = new FileInputStream("gradle.properties");
        Properties properties = new Properties();
        properties.load(input);
        return properties
    }

    /*protected static final String WEB_SERVER = useProperties().getProperty("WEB_SERVER")
    protected static final String BROWSER = useProperties().getProperty("BROWSER");*/

    protected static final String WEB_SERVER = System.getProperty("WEB_SERVER", "https://test.onejl.uk");
    protected static final String BROWSER = System.getProperty("BROWSER", "firefox");

    @Shared
    WebDriver driver;

    def setupSpec() {
        if (BROWSER.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (BROWSER.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
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
                    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, ".\\phantomjs.exe");
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

