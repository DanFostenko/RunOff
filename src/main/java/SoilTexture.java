import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SoilTexture {
    WebDriver driver;

    public SoilTexture(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By soilTexture = By.xpath("//a[text()='Soil Texture']");  //locator for 'Soil Texture' link

    public void clickSoilTexture() {
        driver.get("http://"+MainClass.site);
        driver.findElement(soilTexture).click();
    }
}
