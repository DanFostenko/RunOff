import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MyDiagnoses {
    WebDriver driver;

    public MyDiagnoses(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By myDiagnoses = By.xpath("//a[text()='My Diagnoses']");  //locator for 'My Diagnoses' link
    private By disagreeButton = By.xpath("//span[text()='Disagree']/..");  //locator for 'Disagree' button of popup message about deletion
    private By agreeButton = By.xpath("//span[text()='Agree']/..");  //locator for 'Agree' button of popup message about deletion
    private By addDiagnose = By.xpath("//h2[text()='My Diagnoses']/../div[last()]/div/button");  //locator for '+' button

    public void clickMyDiagnoses() {
        driver.get("http://"+MainClass.site);
        driver.findElement(myDiagnoses).click();
    }

    public void openDiagnose(String fieldName) {
        scrollDown();
        By diagnoseLineBy = By.xpath("//a[text()=\"" + fieldName + "\"]/../..");
        driver.findElement(diagnoseLineBy).click();
        driver.findElement(myDiagnoses).click();
    }

    public void downloadDiagnose(String fieldName) {
        By downloadBy = By.xpath("//a[text()=\"" + fieldName + "\"]/../../td[6]");
        driver.findElement(downloadBy).click();
    }

    public void emailDiagnose(String fieldName) {
        By emailBy = By.xpath("//a[text()=\"" + fieldName + "\"]/../../td[7]");
        driver.findElement(emailBy).click();
    }

    public void editDiagnose(String fieldName) {
        By editBy = By.xpath("//a[text()=\"" + fieldName + "\"]/../../td[8]");
        driver.findElement(editBy).click();
        driver.findElement(myDiagnoses).click();
    }

    public void deleteDiagnose(String fieldName) {
        scrollDown();
        By deleteBy = By.xpath("//a[text()=\"" + fieldName + "\"][last()]/../../td[last()]/button");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(deleteBy)).build().perform();   //mouseover
        driver.findElement(deleteBy).click();
        driver.findElement(disagreeButton).click();
        Home.waitObjectLoad(1000);  //forced timeout to render close popup message
        driver.findElement(deleteBy).click();
        driver.findElement(agreeButton).click();
        Home.waitObjectLoad(1000);  //forced timeout to render close popup message
    }

    public void addDiagnose() {
        driver.findElement(addDiagnose).click();
        /*survey.inputNameOfField("FieldX");
        survey.inputLocationOfTheField("CPC4, Capital Park Cambridge (CPC3), Cambridge Rd, Fulbourn, Cambridge CB21 5XE, UK");
        survey.uploadImage();
        survey.clickNoPhoto();
        survey.clickNoPhoto();
        survey.clickContinue();
        survey.selectCurrentCrop("Beet");
        survey.selectPreviousCrop("Grass");
        survey.clickContinue();
        survey.selectTheSoilTexture("Clay");
        survey.selectDepth("Shallow");
        survey.selectType("Moderate");
        survey.selectLength("Long");
        survey.selectApproach("Reduced");
        survey.selectSoilCoverage("Keep stubble");
        survey.selectWaterBody("> 100 m");
        survey.clickFinish();
        survey.validateReport();
        survey.clickDiagnoseAnotherField();*/
        driver.findElement(myDiagnoses).click();
    }

    public static void scrollDown() {
        try {
            Robot r = null;
            try {   //scroll down to the bottom of the page
                r = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            r.keyPress(KeyEvent.VK_END);  r.keyRelease(KeyEvent.VK_END);
        } finally{};
    }
}
