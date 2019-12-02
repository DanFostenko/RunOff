import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Articles {
    WebDriver driver;

    public Articles(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By articles = By.xpath("//a[text()='Articles']");  //locator for 'Soil Texture' link

    public void clickArticles() {
        driver.get("http://"+MainClass.site);
        Home.refreshPage();
        driver.findElement(articles).click();
    }
}
