import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyDiagnoses {
    WebDriver driver;

    public MyDiagnoses(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By myDiagnoses = By.xpath("//a[text()='My Diagnoses']");  //locator for 'My Diagnoses' link

    public void clickMyDiagnoses() {
        driver.get("http://"+MainClass.site);
        Home.refreshPage();
        driver.findElement(myDiagnoses).click();
    }
}
