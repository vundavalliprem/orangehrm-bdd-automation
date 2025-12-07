package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	 /**
     * Saves screenshot to file in screenshots folder
     *  driver WebDriver instance
     *  scenarioName Name of the failed scenario
     */
	
	
    public static byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void saveScreenshotToFile(WebDriver driver, String scenarioName) {
            try {
            	
            	
            	
            	
            	
            //	It only creates a variable that POINTS to a folder path
                File screenshotDir = new File("screenshots");

                // Create screenshots folder if not exists

                if (!screenshotDir.exists()) {
                    screenshotDir.mkdir();
                }

                // Generate filename with timestamp
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                
               // This replaces all special characters (space, :, ?, -, etc.) with _.
                String fileName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
                
                // Take screenshot and save to file
            //    Now screenshot contains a temporary file on your computer.
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                
             //   Place the screenshot inside the screenshots folder
                File destination = new File("screenshots/" + fileName);
                
           //     Takes the screenshot file from temporary memory Saves it permanently into your folder
                FileUtils.copyFile(screenshot, destination);
                
                System.out.println("Screenshot saved: " + destination.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("Failed to save screenshot: " + e.getMessage());
            }
    }

}
