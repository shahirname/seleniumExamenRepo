package Examen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {


    public MainPage(WebDriver remoteDriver){this.driver=remoteDriver;}

    public String tituloMain(){
        String titulo=driver.getTitle();
        return titulo;
    }

    public String logInMSG(){
        WebElement msgIniciaSesion= driver.findElement(By.xpath("//*[contains(text(),'Log In')]"));
        return msgIniciaSesion.getText();
    }

    public String MailMSG(){
        WebElement msgMailChip= driver.findElement(By.xpath("//*[contains(text(),'Need a Mailchimp account?')]"));
        return msgMailChip.getText();
    }

    public void completeEmail(){
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("XXXXX@gmail.com");
    }

    public void btnLoginClick(){ driver.findElement(By.xpath("//*[@value='log in']")).click();}

    public String errorMsg(){
        WebElement errorMsg= driver.findElement(By.xpath("//*[@class='media-body']"));
        return errorMsg.getText();
    }

    public WebElement checkBox(){
        WebElement checkBox= driver.findElement(By.xpath("//*[@aria-checked='false']"));
        return checkBox;
    }

    public void goToRegistrationPage(){
        driver.navigate().to(urlAlternative);
        RegistrationPage nextPage=new RegistrationPage(driver);
    }

}
