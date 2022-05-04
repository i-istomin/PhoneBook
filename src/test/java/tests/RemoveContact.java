package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class RemoveContact extends TestBAse {

    @BeforeMethod(alwaysRun = true)
    public void preCondition(Method m) {
        if (!app.getHelperuser().isSignOutPresent()) {
            app.getHelperuser().login(new User().withEmail("missira85@gmail.com").withPassword("Passw0rd$"));
            logger.info(("Start test" + m.getName()));
        }
        app.getContact().provideContactData();
    }


    @Test(groups = {"web"},priority = 1)
    public void removeOneContactTaya() {

        logger.info("Test 'removeOneContactTaya' started");
      Assert.assertEquals(app.getContact().removeOneContactTaya(),1);
    }


 //@Test(dependsOnMethods = "removeOneContactTaya",alwaysRun = true)
 @Test(priority = 2)
    public void removeAllContactTaya(){
      app.getContact().removeAllContactTaya();
      Assert.assertTrue(app.getContact().isContactMessageDisplayed());


    }


    @AfterMethod
    public void endLogger(Method m) {
        logger.info("End of test" + m.getName());
    }
}
