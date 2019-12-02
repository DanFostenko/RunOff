import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static String site = "3.122.245.190:8081";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DanFo\\IdeaProjects\\run-off-test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit waiting for GUI element to appear
        driver.manage().window().maximize(); //maximize browser window
        driver.get("http://"+site);

        Home home = new Home(driver);
        Survey survey = new Survey(driver);
        MyDiagnoses myDiagnoses = new MyDiagnoses(driver);
        SoilTexture soilTexture = new SoilTexture(driver);
        Articles articles = new Articles(driver);

        home.clickHome();
        survey.clickSurvey();
        survey.inputNameOfField("FieldX");
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
        myDiagnoses.clickMyDiagnoses();
        soilTexture.clickSoilTexture();
        articles.clickArticles();

        driver.quit();  //end work of driver
    }
}
