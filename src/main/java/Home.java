import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Home {
    WebDriver driver;

    public Home(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By home = By.xpath("//a[text()='Home']");  //locator for 'Home' link

    public void clickHome() {
        driver.get("http://"+MainClass.site);
        refreshPage();
        driver.findElement(home).click();
    }

    public static void waitObjectLoad(int timeout) {
        try {
            Thread.sleep(timeout);  //forced timeout to wait for the next object element to load
        } catch (InterruptedException e) {
            e.printStackTrace();
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
