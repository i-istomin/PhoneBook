package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBAse {


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

        //open login form
        app.getHelperuser().openLoginRegistrationForm();//stanovimsia na imia metoda +enter+ create methid+helperuser
        //  click(By.cssSelector("[href='/login']")); -----> ubiraem i vstavliaem v helper user

        //fill email & password
        app.getHelperuser().fillLoginRegistrationForm("missira85@gmail.com", "Passw0rd$"); //stanovimsia na imia metoda +enter+ create methid+helperuser
        //type(By.xpath("//input[1]"), "missira85@gmail.com");-----> ubiraem i vstavliaem v helper user
        //  type(By.xpath("//input[2]"), "Passw0rd$");-----> ubiraem i vstavliaem v helper user


        //click button login

        app.getHelperuser().submitLogin();
       // click(By.xpath("//*[text()=' Login']"));  -----> ubiraem i vstavliaem v helper user


        //Assert
        Assert.assertTrue(app.getHelperuser().isLoginRegistrationSuccess());
        //Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));   ---> ubiraem i vstavliaem v helper user


    }
}

// System.setProperty("webdriver.chrome.driver", "/home/i-istomin/TelRan/SYSTEMS/PhoneBook/chromedriver");
