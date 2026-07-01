package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WaitUtils {
	// i have made default wait time as 20 seconds, can be wait till the given time if app is slow
    private static final int DEFAULT_TIMEOUT = 20; 
    
    // This method is used to create object for WebDriverWait to avoid repeting it for every wait method and used to dynamically pass different timeout values instead of hardcoding.
    private static WebDriverWait getWait(int timeout) {
    	
        return new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(timeout));
    }
    
    // For waitForVisibility alone i have created 2 method where it can support for both direct locators or webelemnts as well
    //This method is used to make the script waits until element is visible on screen by elements
    public static WebElement waitForVisibility(WebElement element) {
    	return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }
    
    //This method is used to make the script waits until element is visible on screen by locator
    public static WebElement waitForVisibility(By locator) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions
                .visibilityOfElementLocated(locator));
    }
    
  //This method is used to make the script waits until element is clickable
    public static WebElement waitForClickable(By locator) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions
                .elementToBeClickable(locator));
    }
    
  //This method is used to make the script waits until the given text shows up inside the element
   
    public static boolean waitForText(By locator,
                                      String text) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions
                .textToBePresentInElementLocated(locator, text));
    }
}