import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyDiagnoses {
    WebDriver driver;

    public MyDiagnoses(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By myDiagnoses = By.xpath("//a[text()='My Diagnoses']");  //locator for 'My Diagnoses' link
    private By disagreeButton = By.xpath("//span[text()='Disagree']/..");  //locator for 'Disagree' button of popup message about deletion
    private By agreeButton = By.xpath("//span[text()='Agree']/..");  //locator for 'Agree' button of popup message about deletion

    public void clickMyDiagnoses() {
        driver.get("http://"+MainClass.site);
        driver.findElement(myDiagnoses).click();
    }

    public void openDiagnose(String fieldName) {
        By diagnoseLineBy = By.xpath("//span[text()=\"" + fieldName + "\"]/../..");
        driver.findElement(diagnoseLineBy).click();
        driver.findElement(myDiagnoses).click();
    }

    public void deleteDiagnose(String fieldName) {
        By deleteButtonBy = By.xpath("//span[text()=\"" + fieldName + "\"]/../../td[last()]");
        driver.findElement(deleteButtonBy).click();
        driver.findElement(disagreeButton).click();
        Home.waitObjectLoad(500);
        driver.findElement(deleteButtonBy).click();
        driver.findElement(agreeButton).click();
        //driver.findElement(deleteButton).click();
    }

}
