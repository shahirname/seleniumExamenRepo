package Examen.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public WebDriver driver;

    public void maximazePage(){
        driver.manage().window().maximize();
    }

    public void aceptCookies(){
        WebElement btnCookies=driver.findElement(By.xpath("//*[@id='onetrust-pc-btn-handler']"));
        btnCookies.click();
        WebElement aceptCookies=driver.findElement(By.xpath("//*[@class='save-preference-btn-handler onetrust-close-btn-handler']"));
        aceptCookies.click();
    }

    public String urlAlternative="https://login.mailchimp.com/signup/";

    Faker faker=new Faker();
    String fakeEmail=faker.internet().emailAddress();

}
