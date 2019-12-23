import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static String site = "3.122.245.190:8081";   //Test 3.122.245.190:8081; Stage 54.93.213.241:8081

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DanFo\\IdeaProjects\\run-off-test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit waiting for GUI element to appear
        driver.manage().window().maximize(); //maximize browser window
        driver.get("http://"+site);

        String name = "UserX";
        String email = "zeal.roseabella@owee.org";
        String password = "Eamw5768";

        Home home = new Home(driver);
        Survey survey = new Survey(driver);
        MyDiagnoses myDiagnoses = new MyDiagnoses(driver);
        SoilTexture soilTexture = new SoilTexture(driver);

        home.clickHome();
        home.signUpWithCreds(name,password);
        home.clickSignOut();
        home.signInWithCreds(email,password);
        home.changeLanguage("English");
        home.playVideo();
        survey.clickSurvey();
        survey.inputNameOfField("FieldX");
        survey.inputLocationOfTheField("CPC4, Capital Park Cambridge (CPC3), Cambridge Rd, Fulbourn, Cambridge CB21 5XE, UK");
        survey.uploadImage();
        survey.clickNoPhoto();
        survey.clickNoPhoto();
        survey.clickConfirmLocation();
        survey.clickContinue();
        survey.selectCurrentCrop("Beet");
        survey.selectPreviousCrop("Grass");
        survey.clickContinue();
        survey.selectTheSoilTexture("Clay");
        survey.selectDepth("Shallow");
        survey.selectType("Moderate");
        survey.selectLength("Long");
        survey.selectApproach("Reduced");
        survey.selectSoilCoverage("Burying stubble");
        survey.selectWaterBody("> 100 m");
        survey.clickFinish();
        survey.validateReport();
        survey.clickDiagnoseAnotherField();
        myDiagnoses.clickMyDiagnoses();
        myDiagnoses.openDiagnose("FieldX");
        myDiagnoses.downloadDiagnose("FieldX");
        myDiagnoses.emailDiagnose("FieldX");
        //myDiagnoses.editDiagnose("FieldX");
        myDiagnoses.deleteDiagnose("FieldX");
        myDiagnoses.addDiagnose();
        soilTexture.clickSoilTexture();
        soilTexture.validateFooter();

        driver.quit();  //end work of driver
    }
}
