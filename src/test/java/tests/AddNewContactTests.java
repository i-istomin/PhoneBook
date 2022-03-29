package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBAse {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperuser().isSignOutPresent()) {
            app.getHelperuser().login(new User().withEmail("missira85@gmail.com").withPassword("Passw0rd$"));
        }
    }


    @Test

    public void addNewContactSuccess() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;

        Contact contact = Contact
                .builder()
                .name("Moshe" + index)
                .lastName("Kaplan" + index)
                .phone("05258634" + index)
                .email("hello" + index + "@gmail.com")
                .address("Levinsky 17,Tel Aviv")
                .description("friend")
                .build();

        System.out.println(contact.getName());//raspechativaem imia kot-e budem iskat
        System.out.println(contact.getPhone());

        app.getContact().addContactForm();
        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().saveContactForm();
        app.getContact().pause(5000);

        Assert.assertTrue(app.getContact().isContactButtonBold());
        Assert.assertTrue(app.getContact().isContactCardExist());
        Assert.assertTrue(app.getContact().isContactByName(contact.getName()));
        Assert.assertTrue(app.getContact().isContactByPhone(contact.getPhone()));

    }
}
