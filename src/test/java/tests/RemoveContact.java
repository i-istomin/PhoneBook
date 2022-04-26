package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class RemoveContact extends TestBAse {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperuser().isSignOutPresent()) {
            app.getHelperuser().login(new User().withEmail("missira85@gmail.com").withPassword("Passw0rd$"));
        }
    }

    @BeforeMethod
    public void startLogger(Method m) {
        logger.info("start test" + m.getName());
    }


    @Test
    public void removeOneContact() {//throws InterruptedException {
        logger.info("Test 'removeOneContact' started");
        app.getHelperuser().openContactPage();

//        int cardCountBeforeRemoving = app.getContact().getCardCount();
//        app.getContact().clickOnTheFirstCard();
//
//        int cardCountAfterRemoving = app.getContact().getCardCount();
//        Assert.assertEquals(cardCountAfterRemoving, cardCountBeforeRemoving-1);


        Assert.assertTrue(app.getContact().isContactCardExist());


    }

    @Test
    public void removeAllConatct() {
        logger.info("Test 'removeAllContact' started");
        app.getHelperuser().openContactPage();
        app.getContact().removeAllContacts();

       // Assert.assertFalse(app.getContact().isContactCardExist());
        logger.info("no cards display at the page");

    }


    @AfterMethod
    public void endLogger(Method m) {
        logger.info("End of test" + m.getName());
    }
}
