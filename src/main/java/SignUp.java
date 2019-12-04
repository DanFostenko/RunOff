import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
    WebDriver driver;

    public SignUp(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By signUpButton = By.xpath("//span[text()='SIGN UP']/..");  //locator for 'Sign Up' button

    public void clickArticles() {
        driver.get("http://"+MainClass.site);
        driver.findElement(signUpButton).click();
    }
}
