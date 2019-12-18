import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Home {
    WebDriver driver;

    public Home(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    //Elements on page
    private By home = By.xpath("//a[text()='Home']");  //locator for 'Home' link
    private By diagnoseMyFieldButton = By.xpath("//a[text()='Diagnose my field']");  //locator for 'Diagnose My Field' button
    private By startNowButton = By.xpath("//a[text()='Start Now']");  //locator for 'Start Now' button
    private By footer = By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation1 footer-rectangle MuiPaper-rounded']");  //locator for footer
    private By youtubeVideo = By.xpath("//iframe[@class='MuiCardMedia-root video-content MuiCardMedia-media']");  //locator for YouTube video
    //Sign In/Out/Up
    private By signInButton = By.xpath("//span[text()='SIGN IN']/..");  //locator for 'SIGN IN' button
    private By signInTab = By.xpath("//span[@class='MuiTab-wrapper'][text()='Sign In']/..");  //locator for 'SIGN UP' tab
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInSubmitButton = By.xpath("//span[@class='MuiButton-label'][text()='Sign In']/..");  //locator for 'Sign In' button in Sign in menu
    private By signOutSubmitButton = By.xpath("//span[@class='MuiButton-label'][text()='Sign Out']/..");  //locator for 'Sign Out' button in Sign in menu
    private By userButton = By.xpath("//div[@style='cursor: pointer;']");  //locator for user name button
    private By signUpTab = By.xpath("//span[text()='Sign Up']/..");  //locator for 'SIGN UP' tab
    private By nameField = By.id("name");
    private By confirmPasswordField = By.id("confirmPassword");
    private By acceptTCCheckbox = By.xpath("//input[@type='checkbox']");  //locator for 'Accept Terms and Conditions' checkbox
    private By signUpSubmitButton = By.xpath("//span[@class='MuiButton-label'][text()='Sign up']/..");  //locator for 'Sign up' button in Sign in menu

    //Methods
    public void clickHome() {
        driver.get("http://"+MainClass.site);
        driver.findElement(home).click();
        elementExists(diagnoseMyFieldButton);
        elementExists(startNowButton);
        elementExists(footer);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
        driver.findElement(signInTab).click();
    }

    public Home typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public Home typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public Home typeName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public Home typeConfirmPassword(String password) {
        driver.findElement(confirmPasswordField).sendKeys(password);
        return this;
    }

    public Home signInWithCreds(String email, String password) {
        this.clickSignIn();
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signInSubmitButton).click();
        return new Home(driver);
    }

    public void clickSignOut() {
        driver.findElement(userButton).click();
        driver.findElement(signOutSubmitButton).click();
    }

    public void clickSignUp() {
        this.clickSignIn();
        driver.findElement(signUpTab).click();
    }

    public void signUpWithCreds(String name, String email, String password) {
        this.clickSignUp();
        this.typeName(name);
        this.typeEmail(email);
        this.typePassword(password);
        this.typeConfirmPassword(password);
        this.clickAcceptTC();
        driver.findElement(signUpSubmitButton).click();
    }

    public void clickAcceptTC() {
        driver.findElement(acceptTCCheckbox).click();
    }

    public void playVideo() {
        driver.findElement(youtubeVideo).click();
    }

    public static void waitObjectLoad(int timeout) {
        try {
            Thread.sleep(timeout);  //forced timeout to wait for the next object element to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean elementExists(By xpath) {
        try {
            driver.findElement(xpath);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public static void refreshPage() {
        try {
            Robot r = null;
            try {
                r = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_F5);  r.keyRelease(KeyEvent.VK_F5);
            r.keyRelease(KeyEvent.VK_CONTROL);
        } finally{};
    }
}
