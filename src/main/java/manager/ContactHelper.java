package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isLogInPresent() {
        return isElementPresent(By.xpath("a[href='/home']")); //a[href='/login']
    }

    public void openContactForm() {
        //  click(By.cssSelector(".active"));
        click(By.xpath("//a[@class='active']"));

    }

    public void fillContactForm(Contact contact) {
        // type(By.cssSelector("input[placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
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


    public void addContactForm() {
        click(By.cssSelector("a[href='/add']"));
    }


    public boolean isContactByName(String name) {
        List<WebElement> list=wd.findElements(By.cssSelector("h2"));
        for (WebElement el:list) {
            if (el.getText().equals(name))//procerit text po imeni esli ono takoe je
                return true;
        }
        return false;
    }

    public boolean isContactByPhone(String phone) {
       List<WebElement> list=wd.findElements(By.cssSelector("h3"));
        for (WebElement el:list) {
            if (el.getText().equals(phone))
                return true;
        }
        return false;
    }
}
