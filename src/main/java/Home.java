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

    private By home = By.xpath("//a[text()='Home']");  //locator for 'Home' link
    private By diagnoseMyFieldButton = By.xpath("//a[text()='Diagnose my field']");  //locator for 'Diagnose My Field' button
    private By startNowButton = By.xpath("//a[text()='Start Now']");  //locator for 'Start Now' button
    private By youtubeVideo = By.xpath("//iframe[@class='MuiCardMedia-root video-content MuiCardMedia-media']");  //locator for YouTube video

    public void clickHome() {
        driver.get("http://"+MainClass.site);
        driver.findElement(home).click();
        elementExists(diagnoseMyFieldButton);
        elementExists(startNowButton);
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
