import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Challenge_Multiple_Contexts {
    private static final String APP_IOS = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.app.zip";
    private static final String APPIUM = "http://localhost:4723/wd/hub";
    private static final String APPIUM_PRO = "https://appiumpro.com";
    private static final String OTHER_SITE = "https://cloudgrey.io";

    private static final By WEBVIEW_PAGE = MobileBy.AccessibilityId("?"); // TODO
    private static final By URL_FIELD = By.xpath("?"); // TODO
    private static final By GO_BUTTON = MobileBy.AccessibilityId("?"); // TODO

    private IOSDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "iPhone X");
        caps.setCapability("app", APP_IOS);
        driver = new IOSDriver(new URL(APPIUM), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Nullable
    private String getWebContext(IOSDriver driver) {
        ArrayList<String> contexts = new ArrayList<String>(driver.getContextHandles());
        for (String context : contexts) {
            if (!context.equals("NATIVE_APP")) {
                return context;
            }
        }
        return null;
    }

    @Test
    public void testHybridApp() {
        // 1. Navigate to the webview page
        // TODO

        // 2. Attempt to navigate to an incorrect site
        // TODO

        // 3. Assert that an error message pops up
        // TODO

        // 4. assert that the webview did not actually go anywhere
        // TODO

        // 5. attempt to navigate to the correct site
        // TODO

        // 6. assert that the webview went to the right place
        // TODO
    }
}
