package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBAse {

    @BeforeMethod
    public void preCondition(){
        if (app.getHelperuser().isSignOutPresent()){
            app.getHelperuser().logout();
        }
    }


    @Test
    public void registrationSuccess() {
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index); //==sout


        app.getHelperuser().openLoginRegistrationForm();//1.open regform
        app.getHelperuser().fillLoginRegistrationForm("iraira1"+index+"@gmail.com", "passw0rd$");//2.fill email + fill password
        app.getHelperuser().submitRegistration();//3.click registration
        //Assert.assertTrue(app.getHelperuser().isSignOutPresent());
        app.getHelperuser().pause(1000);    //4. make pause


    }
//    @AfterMethod
//    public void postConditions(){
//        app.getHelperuser().submitLogin();
//    }
}
