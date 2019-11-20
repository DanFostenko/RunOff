import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Survey {
    WebDriver driver;

    public Survey(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By survey = By.xpath("//a[text()='Survey']");  //locator for 'Survey' link

    public void clickSurvey() {
        driver.get("http://"+MainClass.site);
        driver.findElement(survey).click();
        Home.waitObjectLoad(500);
    }
}
