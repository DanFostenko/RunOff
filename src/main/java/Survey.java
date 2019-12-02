import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
    private By locationOfTheField = By.id("field_location"); //locator for 'Location of the field' input field
    private By uploadButton = By.xpath("//span[text()='Choose the file to upload']"); //locator for 'Choose the file to upload' button
    private By noPhotoCheckbox = By.xpath("//span[contains(text(),'have a photo.')]/../span[1]"); //locator for 'I don't have a photo.' checkbox
    private By continueButton = By.xpath("//span[text()='Continue']/.."); //locator for 'Continue' button
    private By finishButton = By.xpath("//span[text()='Finish']/.."); //locator for 'Finish' button
    private By soilTextureDropdown = By.id("soil_texture_sel"); //locator for '1. Select the soil texture:' dropdown
    //report
    private By reportPotentialScore = By.xpath("//div[@class='potential-score-value-max']");  //locator for 'Run-off potential score' parameter
    private By reportPotentialClass = By.xpath("//div[@class='potential-class-value']");  //locator for 'Run-off potential class' parameter
    private By reportScoreLevel = By.xpath("//div[@class='score-level-title']/../*[local-name()='svg']");  //locator for 'Score level' chart
    private By reportSummaryTable = By.xpath("//table[@class='MuiTable-root']");  //locator for 'Summary' table
    private By reportRecommendations = By.xpath("//div[@class='recommendations-warning-caption']");  //locator for 'Recommendations' table
    private By reportFullReport = By.xpath("//div[@class='pdf-report-title']");  //locator for 'Full Report' table

    public void clickSurvey() {
        driver.get("http://"+MainClass.site);
        Home.refreshPage();
        driver.findElement(survey).click();
    }

    //farm_details
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

    public void clickNoPhoto() {
        driver.findElement(noPhotoCheckbox).click();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    //crop_data
    public void selectCurrentCrop(String currentCrop) {
        By currentCropBy = By.xpath("//div[1]/button/span[text()=\"" + currentCrop + "\"]");
        driver.findElement(currentCropBy).click();
    }

    public void selectPreviousCrop(String previousCrop) {
        By previousCropBy = By.xpath("//div[2]/button/span[text()=\"" + previousCrop + "\"]");
        driver.findElement(previousCropBy).click();
    }

    //field_details
    public void selectTheSoilTexture(String soilTextureOption) {
        driver.findElement(soilTextureDropdown).click();
        Home.waitObjectLoad(50);   //forced timeout to open and render the dropdown
        By soilTextureOptionBy = By.xpath("//li[text()=\"" + soilTextureOption + "\"]");
        driver.findElement(soilTextureOptionBy).click();
        Home.waitObjectLoad(300);   //forced timeout to close the dropdown
    }

    public void selectDepth(String depth) {
        By depthBy = By.xpath("//div[2]/button/span[starts-with(text(), \"" + depth + "\")]/..");
        //By depthBy = By.xpath("//h2[contains(text(),'depth')]/../div[2]/button/span[starts-with(text(), \"" + depth + "\")]/..");
        driver.findElement(depthBy).click();
    }

    public void selectType(String type) {
        By typeBy = By.xpath("//div[3]/button/span[starts-with(text(), \"" + type + "\")]/..");
        driver.findElement(typeBy).click();
    }

    public void selectLength(String length) {
        By lengthBy = By.xpath("//div[4]/button/span[starts-with(text(), \"" + length + "\")]/..");
        driver.findElement(lengthBy).click();
    }

    public void selectApproach(String approach) {
        By approachBy = By.xpath("//div[5]/button/span[contains(text(), \"" + approach + "\")]/..");
        driver.findElement(approachBy).click();
    }

    public void selectSoilCoverage(String soilCoverage) {
        By soilCoverageBy = By.xpath("//div[6]/button/span[starts-with(text(), \"" + soilCoverage + "\")]/..");
        driver.findElement(soilCoverageBy).click();
    }

    public void selectWaterBody(String waterBody) {
        By waterBodyBy = By.xpath("//div[7]/button/span[starts-with(text(), \"" + waterBody + "\")]/..");
        driver.findElement(waterBodyBy).click();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public void validateReport() {
        elementExists(reportPotentialScore);
        elementExists(reportPotentialClass);
        elementExists(reportScoreLevel);
        elementExists(reportSummaryTable);
        elementExists(reportRecommendations);
        elementExists(reportFullReport);
    }

    public boolean elementExists(By xpath) {
        try {
            driver.findElement(xpath);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

}
