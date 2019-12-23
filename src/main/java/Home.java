import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    private By languageDropdown = By.xpath("//div[@class='select-language-div']/*[name()='svg' and @class='MuiSvgIcon-root']");  //locator for language icon
    private By youtubeVideo = By.xpath("//iframe[@class='MuiCardMedia-root video-content MuiCardMedia-media']");  //locator for YouTube video
    //Sign In/Out/Up
    private By signUpButton = By.xpath("//span[text()='SIGN UP']/..");  //locator for 'SIGN UP' button
    private By signInTab = By.xpath("//span[@class='MuiTab-wrapper'][text()='Sign In']/..");  //locator for 'SIGN UP' tab
    private By emailField = By.xpath("//input[@name='email']");  //locator for 'Email Address *' field
    private By passwordField = By.xpath("//input[@name='password']");  //locator for 'Password *' field
    private By signInSubmitButton = By.xpath("//span[@class='MuiButton-label'][text()='Sign In']/..");  //locator for 'Sign In' button in Sign in menu
    private By signOutSubmitButton = By.xpath("//span[@class='MuiButton-label'][text()='Sign Out']/..");  //locator for 'Sign Out' button in Sign in menu
    private By userButton = By.xpath("//div[@class='auth-profile-name']");  //locator for user name button
    private By signUpTab = By.xpath("//span[text()='Sign Up']/..");  //locator for 'SIGN UP' tab
    private By nameField = By.xpath("//input[@name='name']");  //locator for 'Name *' field
    private By confirmPasswordField = By.xpath("//input[@name='passwordConfirm']");  //locator for 'Confirm password *' field
    private By acceptTCCheckbox = By.xpath("//input[@type='checkbox']");  //locator for 'Accept Terms and Conditions' checkbox
    private By signUpSubmitButton = By.xpath("//span[@class='MuiButton-label'][text()='Sign up']/..");  //locator for 'Sign up' button in Sign in menu
    private By emailReadField = By.xpath("//span[@id='email']");    //email on temporary email service page

    //Methods
    public void clickHome() {
        driver.get("http://"+MainClass.site);
        driver.findElement(home).click();
        elementExists(diagnoseMyFieldButton);
        elementExists(startNowButton);
        elementExists(footer);
    }

    public void clickSignIn() {
        driver.findElement(signUpButton).click();
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

    public String signUpWithCreds(String name, String password) {
        String mainTab = driver.getWindowHandle();  //remember the name of main browser tab
        ((JavascriptExecutor)driver).executeScript("window.open('https://www.minuteinbox.com','_blank');");    //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t")
        switchToActiveTab();
        String email = driver.findElement(emailReadField).getText();
        System.out.println("Registration email: " + email);
        driver.switchTo().window(mainTab);
        switchToActiveTab();
        driver.close();
        switchToActiveTab();
        this.clickSignUp();
        this.typeName(name);
        this.typeEmail(email);
        this.typePassword(password);
        this.typeConfirmPassword(password);
        this.clickAcceptTC();
        driver.findElement(signUpSubmitButton).click();
        return email;
    }

    public void clickAcceptTC() {
        driver.findElement(acceptTCCheckbox).click();
    }

    public void changeLanguage(String language) {
        driver.findElement(languageDropdown).click();
        By languageBy = By.xpath("//span[text()=\"" + language + "\"]/../..");
        driver.findElement(languageBy).click();
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

    private void switchToActiveTab() {
        for (String tab : driver.getWindowHandles()) {  //switch to the active tab
            driver.switchTo().window(tab);
        }
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
