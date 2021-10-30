package Examen.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage  {



    public RegistrationPage(WebDriver remoteDriver){this.driver=remoteDriver;}

    public void RandomEmail(){
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(fakeEmail);

    }


}
