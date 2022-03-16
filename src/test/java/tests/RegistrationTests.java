package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBAse {



    @Test
    public void registrationSuccess() {
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index); //==sout

        //open regform
        app.getHelperuser().openLoginRegistrationForm();

        //fill email +   //fill password
        app.getHelperuser().fillLoginRegistrationForm("iraira85"+index+"@gmail.com", "passw0rd$");


        //click registration
        app.getHelperuser().submitRegistration();// noviy metod kot-go u nas ne bilo v logine.
        //poetomu nam nujno ego sdelat v he;per usere


        //assert
        Assert.assertTrue(app.getHelperuser().isLoginRegistrationSuccess());


    }
}