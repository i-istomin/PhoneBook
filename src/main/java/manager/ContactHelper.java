package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
      //  click(By.cssSelector(".active"));
        click(By.xpath("//a[@class='active']"));
        
    }

    public void fillContactForm(Contact contact) {
      // type(By.cssSelector("input[placeholder='Name']"), contact.getName());

        type(By.xpath("//input[@placeholder='Name']"),contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
       // type(By.cssSelector("input[placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        //type(By.cssSelector("input[placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        //type(By.cssSelector("input[placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        //type(By.cssSelector("input[placeholder='description']"), contact.getDescription());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());

    }

    public void saveContactForm() {
        //click(By.xpath("//button[contains(.,'Save')]"));
        click(By.cssSelector("div[class='add_form__2rsm2'] button"));
    }

    public boolean isContactButtonBold() {
      return isElementPresent(By.cssSelector(".active"));
    }

    public boolean isContactCardExist() {
        return isElementPresent(By.cssSelector(".contact-item_card__2SOIM"));
    }
}
