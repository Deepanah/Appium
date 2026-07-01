import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import utils.DriverFactory;
import utils.WaitUtils;

public class LoginPage {

    private AppiumDriver driver; 

    // constructor initializes elements using PageFactory
    public LoginPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // locators using appium anotation for login fields
    @iOSXCUITFindBy(accessibility  = "username")
    private WebElement usernamefield;
    
    @iOSXCUITFindBy(accessibility  = "password")
    private WebElement passwordfield;
    
    @iOSXCUITFindBy(accessibility  = "submit")
    private WebElement loginbutton;
    
    
    //Creating a method to enter user name and pass the value in the method parameter
    public void enterName(WebElement usernamefield, String Testname) {

        int maxRetries = 3;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {

            try {

                WebElement field =WaitUtils.waitForVisibility(usernamefield);
                field.clear();
                field.sendKeys(Testname);

                return;

            } catch (Exception e) {

                if (attempt == maxRetries) {
                    throw new RuntimeException("Unable to enter username after "+ maxRetries + " attempts.", e);
                }
            }
        }
    }
    
    

    public void enterPassword(WebElement loginbutton) {

        int maxRetries = 3;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                WebElement field =WaitUtils.waitForVisibility(loginbutton);
                field.click();
                return;
            } catch (Exception e) {

                if (attempt == maxRetries) {
                    throw new RuntimeException("Unable to enter password after "+ maxRetries + " attempts.", e);
                }
            }
        }
    }

    public void clickSubmit(WebElement passwordfield, String testpassword) {

        int maxRetries = 3;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                WebElement field =WaitUtils.waitForVisibility(passwordfield);
                field.clear();
                field.sendKeys(testpassword);
                return;
            } catch (Exception e) {

                if (attempt == maxRetries) {
                    throw new RuntimeException("Unable to clcik login button after "+ maxRetries + " attempts.", e);
                }
            }
        }
    }
}