import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SoilTexture {
    WebDriver driver;

    public SoilTexture(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    //Elements on page
    private By soilTexture = By.xpath("//a[text()='Soil Texture']");  //locator for 'Soil Texture' link
    //Footer
    private By footer = By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation1 footer-rectangle MuiPaper-rounded']");  //locator for footer
    private By footerHome = By.xpath("//a[@class='site-map-nav-link'][text()='Home']");  //Footer -> Site map -> Home
    private By footerSurvey = By.xpath("//a[@class='site-map-nav-link'][text()='Survey']");  //Footer -> Site map -> Survey
    private By footerMyDiagnoses = By.xpath("//a[@class='site-map-nav-link'][text()='My Diagnoses']");  //Footer -> Site map -> My Diagnoses
    private By footerSoilTexture = By.xpath("//a[@class='site-map-nav-link active'][text()='Soil Texture']");  //Footer -> Site map -> Soil Texture
    private By footerTC = By.xpath("//div[@class='site-map-nav-link'][text()='Terms&Conditions']");  //Footer -> Legal -> Terms&Conditions
    private By footerPrivacyPolicy = By.xpath("//div[@class='site-map-nav-link'][text()='Privacy policy']");  //Footer -> Site map -> Privacy policy
    private By footerCookiesPolicy = By.xpath("//div[@class='site-map-nav-link'][text()='Cookies policy']");  //Footer -> Site map -> Cookies policy
    private By footerGeneralInquiries = By.xpath("//a[@class='contact-us-a'][text()='info@syngenta.com']");  //Footer -> Contact us -> General inquiries email
    private By footerTechnicalSupport = By.xpath("//a[@class='contact-us-a'][text()='info@syngenta.com']");  //Footer -> Contact us -> Technical support email
    private By closeButton = By.xpath("//*[@class='MuiSvgIcon-root terms-conditions-close-icon']");  //Close button in modal window

    public void clickSoilTexture() {
        driver.get("https://"+MainClass.site);
        driver.findElement(soilTexture).click();
    }

    public void validateFooter() {
        elementExists(footer);
        elementExists(footerHome);
        elementExists(footerSurvey);
        elementExists(footerMyDiagnoses);
        elementExists(footerSoilTexture);
        elementExists(footerTC);
        elementExists(footerPrivacyPolicy);
        elementExists(footerCookiesPolicy);
        elementExists(footerGeneralInquiries);
        elementExists(footerTechnicalSupport);
        driver.findElement(footerTC).click();
        driver.findElement(closeButton).click();
        driver.findElement(footerPrivacyPolicy).click();
        driver.findElement(closeButton).click();
        driver.findElement(footerCookiesPolicy).click();
        //driver.findElement(closeButton).click();
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
