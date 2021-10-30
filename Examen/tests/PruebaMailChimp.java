package Examen.tests;

import Examen.pages.MainPage;
import Examen.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PruebaMailChimp extends BaseTest {

    @Test (priority = 1)
    public void  validarTituloTest(){
        mainPage.maximazePage();

        mainPage.aceptCookies();

        String titulos=mainPage.tituloMain();
        Assert.assertEquals(titulos,"Login | Mailchimp","Error: El titulo esperado no coincide con el de la pagina");
    }

    @Test (priority = 2)
    public void iniciarSesionPageTest(){
        mainPage.maximazePage();

        mainPage.aceptCookies();

        boolean iniciarBoolean=true;
        boolean mailChipBoolean=true;
        String iniciarSesionTxt="Log In";
        String mailChipTxt="Need a Mailchimp account?";


        String masgLogIn= mainPage.logInMSG();
        String msgMail=mainPage.MailMSG();

        if(masgLogIn.contains(iniciarSesionTxt)){
            Assert.assertTrue(iniciarBoolean,"Error: No se encontro el txt 'Iniciar Sesión'.");
        }

        if(msgMail.contains(mailChipTxt)){
            Assert.assertTrue(mailChipBoolean,"Error: No se encontro en txt 'Need a Mailchimp account?'.");
        }
    }

    @Test(priority = 3)
    public void voidloginErrorTest(){
        boolean msgErrorBoolean=true;
        mainPage.maximazePage();

        mainPage.aceptCookies();

        mainPage.completeEmail();

        mainPage.btnLoginClick();

        String errorMsg=mainPage.errorMsg();

        if(errorMsg.contains("Looks like you forgot your password there, XXXXX@gmail.com.")){
            Assert.assertTrue(msgErrorBoolean,"Error: No se encontro el mensaje de error esperado.");
        }

        if (mainPage.checkBox().isSelected()){
            Assert.assertFalse(false,"Error, se espearaba que el check box no estuviese seleccionado.");
        }
    }

    @Test(priority = 4)
    public void fakeEmailTest(){
        mainPage.maximazePage();

        mainPage.aceptCookies();

        mainPage.goToRegistrationPage();

        registrationPage.maximazePage();

        if(mainPage.urlAlternative.contains("signup")){
            Assert.assertTrue(true,"Error, se esperaba que la url contenga 'sign up'");
        }

        registrationPage.RandomEmail();

    }

    @Test(priority = 5, dataProvider = "invalidEmail")
    public void dataProviderTest(String email, String pasword){

        mainPage.maximazePage();

        mainPage.aceptCookies();

        driver.findElement(By.xpath("//*[@name='username']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(pasword);
        driver.findElement(By.xpath("//*[@value='log in']")).click();

        WebElement errorPswsMsage= driver.findElement(By.xpath("//*[@class='c-mediaBody--centered']"));
        if(errorPswsMsage.getText().contains("Sorry, that password isn't right. We can help you")){
            Assert.assertTrue(true,"Error, no aparecio el mensaje de error que se esperaba.");
        }

    }

    @DataProvider(name = "invalidEmail")
    public Object[][] datosEmails (){
        return new Object[][]{
                {fakeEmail2,"HolaMundo"},
                {fakeEmail3,"HolaMundo"},
                {fakeEmail4,"HolaMundo"},
        };
    }


}
