package tests;

import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBAse {

    @BeforeMethod
    public void preCondition() {

    }

    @Test

    public void addNewContactSuccess(){
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;

        Contact contact = Contact
                .builder()
                .name("Moshe")
                .lastName("Kaplan")
                .phone("05258634" + index)
                .email("hello" + index + "@gmail.com")
                .address("Levinsky 17,Tel Aviv")
                .description("ok")
                .build();


        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().saveContactForm();
        app.getContact().pause(5000);

        Assert.assertTrue(app.getContact().isContactButtonBold());
        Assert.assertTrue(app.getContact().isContactCardExist());
    }
}