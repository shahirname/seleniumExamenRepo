package Examen.tests;

import Examen.pages.MainPage;
import Examen.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public String urlSite= "https://login.mailchimp.com/";

    Faker faker=new Faker();
    String fakeEmail2=faker.internet().emailAddress();
    String fakeEmail3=faker.internet().emailAddress();
    String fakeEmail4=faker.internet().emailAddress();
    protected MainPage mainPage;
    protected RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp (){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get(urlSite);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        mainPage=new MainPage(driver);
        registrationPage=new RegistrationPage(driver);
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }

}
