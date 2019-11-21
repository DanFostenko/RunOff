import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Survey {
    WebDriver driver;

    public Survey(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By survey = By.xpath("//a[text()='Survey']");  //locator for 'Survey' link
    private By nameOfField = By.id("field_name"); //locator for 'Name of field' input field
    private By locationOfTheField = By.id("gps"); //locator for 'Location of the field' input field
    private By uploadButton = By.xpath("//span[text()='Choose the file to upload']"); //locator for 'Choose the file to upload' button
    private By continueButton = By.xpath("//span[text()='Continue']/.."); //locator for 'Continue' button
    private By soilTextureDropdown = By.id("soil_texture_sel"); //locator for '1. Select the soil texture:' dropdown

    public void clickSurvey() {
        driver.get("http://"+MainClass.site);
        driver.findElement(survey).click();
    }

    public void inputNameOfField(String fieldName) {
        driver.findElement(nameOfField).sendKeys(fieldName);
    }

    public void inputLocationOfTheField(String fieldLocation) {
        driver.findElement(locationOfTheField).sendKeys(fieldLocation);
    }

    public void uploadImage() {
        driver.findElement(uploadButton).click();
        Home.waitObjectLoad(500);  //forced timeout to render system upload window
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        driver.switchTo().activeElement();
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_F);  r.keyRelease(KeyEvent.VK_F);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_I);  r.keyRelease(KeyEvent.VK_I);
        r.keyPress(KeyEvent.VK_E);  r.keyRelease(KeyEvent.VK_E);
        r.keyPress(KeyEvent.VK_L);  r.keyRelease(KeyEvent.VK_L);
        r.keyPress(KeyEvent.VK_D);  r.keyRelease(KeyEvent.VK_D);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_X);  r.keyRelease(KeyEvent.VK_X);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_PERIOD);  r.keyRelease(KeyEvent.VK_PERIOD);
        r.keyPress(KeyEvent.VK_P);  r.keyRelease(KeyEvent.VK_P);
        r.keyPress(KeyEvent.VK_N);  r.keyRelease(KeyEvent.VK_N);
        r.keyPress(KeyEvent.VK_G);  r.keyRelease(KeyEvent.VK_G);
        r.keyPress(KeyEvent.VK_ENTER);  r.keyRelease(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
        Home.waitObjectLoad(500);  //forced timeout to process image uploading
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void selectCurrentCrop(String currentCrop) {
        By currentCropBy = By.xpath("//div[1]/button/span[text()=\"" + currentCrop + "\"]");
        driver.findElement(currentCropBy).click();
    }

    public void selectPreviousCrop(String previousCrop) {
        By previousCropBy = By.xpath("//div[2]/button/span[text()=\"" + previousCrop + "\"]");
        driver.findElement(previousCropBy).click();
    }

    public void selectTheSoilTexture(String soilTextureOption) {
        driver.findElement(soilTextureDropdown).click();
        By soilTextureOptionBy = By.xpath("//li[text()=\"" + soilTextureOption + "\"]");
        driver.findElement(soilTextureOptionBy).click();
        Home.waitObjectLoad(5000);
    }

}
