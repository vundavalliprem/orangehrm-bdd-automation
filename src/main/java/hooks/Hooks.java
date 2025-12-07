package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtils;

public class Hooks {

    @Before
    public void setup() {
        BaseClass.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Attach screenshot to Cucumber report
            byte[] screenshot = ScreenshotUtils.captureScreenshot(BaseClass.driver);
            scenario.attach(screenshot, "image/png", scenario.getName());
            
            // Save screenshot to file
            ScreenshotUtils.saveScreenshotToFile(BaseClass.driver, scenario.getName());
        }
        BaseClass.tearDown();
    }
}
