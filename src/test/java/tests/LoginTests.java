package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBAse {

    @BeforeMethod
    public void precondition() {////is login?->log out
        if (app.getHelperuser().isSignOutPresent()) {
            app.getHelperuser().logout();
        }
    }

    @Test
    //metod loginsuccess ne smojem pochinit. on trebudet webdriver no ego tut ne budet. poetomu nuno ves metod udalit
    public void loginSuccess() {
    }

    //        //open login form
//        WebElement loginItem = wd.findElement(By.cssSelector("[href='/login']"));//tut seichas rabotaet implicitlyWait code
//        loginItem.click();
//
//        //fill email
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));//tolko v elemente "?input" mojno delate "type"
//        emailInput.click(); //stavim mishku na field email
//        emailInput.clear(); //na vsiakiy sluchay vsegda vitiraem chto mojet bit napisano v field email
//        //esli tam chto to tam lejit to komanda kpt-ya budet pechatat, dopishet k uje napisannomu
//        emailInput.sendKeys("missira85@gamil.com");// type to the field something
//
//        //fill password
//        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys("Passw0rd$");
//
//        //click button login
//        //esli mi sobiraemsia sdelat tolko odno deystview kak najat na knopku "login", to nam ne obazatelno zayavliat WEbElement
//        //nam ne nujen eshe odin element i nichego s nim delat
//        wd.findElement(By.xpath("//*[text()=' Login']")).click();
//
//        //Assert
//        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);
//        //  Assert.assertTrue(sing out present?);
//
//    }
    @Test
    //peredelivaem public void loginSuccessNew()
    public void loginSuccessNew() {

        //1. open login form
        app.getHelperuser().openLoginRegistrationForm();//stanovimsia na imia metoda +enter+ create methid+helperuser
        //2. fill email & password
        app.getHelperuser().fillLoginRegistrationForm("missira85@gmail.com", "Passw0rd$"); //stanovimsia na imia metoda +enter+ create methid+helperuser
        //3.click button login
        app.getHelperuser().submitLogin();// click(By.xpath("//*[text()=' Login']"));  -----> ubiraem i vstavliaem v helper user
        //4. make pause
        app.getHelperuser().pause(5000);
        //Assert
        Assert.assertTrue(app.getHelperuser().isSignOutPresent());
    }

    @Test
    public void loginSuccessNew1() {
        app.getHelperuser().openLoginRegistrationForm();
        app.getHelperuser().fillLoginRegistrationForm("missira85@gmail.com", "Passw0rd$");
        app.getHelperuser().submitLogin();
        app.getHelperuser().pause(5000);
        Assert.assertTrue(app.getHelperuser().isSignOutPresent());
    }

    @Test
    public void loginSuccessModel() {
        User user = new User().withEmail("missira85@gmail.com").withPassword("Passw0rd$");

        app.getHelperuser().openLoginRegistrationForm();
        app.getHelperuser().fillLoginRegistrationForm(user);
        app.getHelperuser().submitLogin();
        app.getHelperuser().pause(5000);
        Assert.assertTrue(app.getHelperuser().isSignOutPresent());
    }


}