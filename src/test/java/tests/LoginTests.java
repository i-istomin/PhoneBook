package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBAse {


    @Test
    public void loginSuccess() {
        //open login form
        WebElement loginItem = wd.findElement(By.cssSelector("[href='/login']"));//tut seichas rabotaet implicitlyWait code
        loginItem.click();

        //fill email
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));//tolko v elemente "?input" mojno delate "type"
        emailInput.click(); //stavim mishku na field email
        emailInput.clear(); //na vsiakiy sluchay vsegda vitiraem chto mojet bit napisano v field email
        //esli tam chto to tam lejit to komanda kpt-ya budet pechatat, dopishet k uje napisannomu
        emailInput.sendKeys("missira85@gamil.com");// type to the field something

        //fill password
        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Passw0rd$");

        //click button login
        //esli mi sobiraemsia sdelat tolko odno deystview kak najat na knopku "login", to nam ne obazatelno zayavliat WEbElement
        //nam ne nujen eshe odin element i nichego s nim delat
        wd.findElement(By.xpath("//*[text()=' Login']")).click();

        //Assert
        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);
        //  Assert.assertTrue(sing out present?);

    }

    @Test
    public void loginSuccessNew(){

        //open login form
       click(By.cssSelector("[href='/login']")); //vizvali metod cklick iz klassa testbase
        //fill email

        type(By.xpath("//input[1]"),"missira85@gmail.com");
        //fill password
        type(By.xpath("//input[2]"),"Passw0rd$");
        //click button login
        click(By.xpath("//*[text()=' Login']"));
        //Assert
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));

    }
}

// System.setProperty("webdriver.chrome.driver", "/home/i-istomin/TelRan/SYSTEMS/PhoneBook/chromedriver");
