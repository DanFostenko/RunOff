import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    WebDriver driver;

    public Home(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By home = By.xpath("//a[text()='Home']");  //locator for 'Home' link

    public void clickHome() {
        driver.get("http://"+MainClass.site);
        driver.findElement(home).click();
        waitObjectLoad(500);
    }

    public static void waitObjectLoad(int timeout) {
        try {
            Thread.sleep(timeout);  //forced timeout to wait for the next object element to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
