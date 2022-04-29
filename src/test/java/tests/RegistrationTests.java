package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class RegistrationTests extends TestBAse {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getHelperuser().isSignOutPresent()) {
            app.getHelperuser().logout();
        }
    }


    @Test(groups = {"web"})
    public void registrationSuccess() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(index); //==sout

        app.getHelperuser().openLoginRegistrationForm();//1.open regform
        app.getHelperuser().fillLoginRegistrationForm("iraira1" + index + "@gmail.com", "Passw0rd$");//2.fill email + fill password
        app.getHelperuser().submitRegistration();//3.click registration
        app.getHelperuser().pause(1000);    //4. make pause
        Assert.assertTrue(app.getHelperuser().isSignOutPresent());

    }

    @Test
    public void registrationSuccessModel() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        // System.out.println(index); //==sout
        User user = new User().withEmail("iraira1" + index + "@gmail.com").withPassword("Passw0rd$");

        app.getHelperuser().openLoginRegistrationForm();//1.open regform
        app.getHelperuser().fillLoginRegistrationForm(user);//2.fill email + fill password
        app.getHelperuser().submitRegistration();//3.click registration
        app.getHelperuser().pause(1000);    //4. make pause
        Assert.assertTrue(app.getHelperuser().isSignOutPresent());
    }


    @Test
    public void registrationWrongPasswordModel() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("iraira2" + index + "@gmail.com").withPassword("12345");

        app.getHelperuser().openLoginRegistrationForm();//1.open regform
        app.getHelperuser().fillLoginRegistrationForm(user);//2.fill email + fill password
        app.getHelperuser().submitRegistration();//3.click registration
        app.getHelperuser().pause(1000);    //4. make pause


        app.getHelperuser().handleAlert();
        Assert.assertTrue(app.getHelperuser().isRegistrationErrorDisplayed());


    }

    @AfterMethod
    public void endLogger(Method m) {
        logger.info("End of test" + m.getName());
    }

}


//TOOL DEMOQA.COM