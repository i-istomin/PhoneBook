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
        //   click(By.cssSelector("[href='/add']"));
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
        //  click(By.cssSelector("div[class='add_form__2rsm2'] button"));
        click(By.cssSelector("b"));
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
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name))//procerit text po imeni esli ono takoe je
                return true;
        }
        return false;
    }

    public boolean isContactByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone))
                return true;
        }
        return false;
    }

//    public int getCardCount() {
//        return wd.findElements(By.xpath("//div[@class='contact-page_leftdiv__yhyke']")).size() - recentlyViewedCards();
//    }
//
//    private int recentlyViewedCards() {
//        return wd.findElements(By.xpath("//div[@class='contact-page_leftdiv__yhyke']//div//div[1]")).size();
//    }

//nujno eredelat
//    public int clickOnTheFirstCard() {
//
//        int countBefore = countOfContacts();
//
//        if (!isCountListEmpty()) {
//            WebElement element = wd.findElement(By.cssSelector("div[class='contact-page_leftdiv__yhyke'] div div:nth-child(1)"));
//            JavascriptExecutor executor = (JavascriptExecutor) wd;
//            executor.executeScript("arguments[0].click();", element);
//
//            click(By.xpath("//button[normalize-space()='Remove']"));
//            pause(500);
//        }
//        int countAfter=countOfContacts();
//        return countBefore-countAfter;
//    }
//
//    public void removeAllContacts() {
//        clickOnTheFirstCard();
//        pause(500);
//
//        if (wd.findElements(By.cssSelector("div[class='contact-page_leftdiv__yhyke'] div div:nth-child(1)")).size() != 0 ) {
//            System.out.println("Cards are available");
//            clickOnTheFirstCard();
//            pause(1000);
//        }
//        else {
//            System.out.println("no cards available");
//            wd.close();
//        }
//    }

    public int removeOneContactTaya() { //zapihem "int" chtobi srazu schital

        int countBefore = countOfContacts();

        if (!isCountListEmpty()) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[normalize-space()='Remove']"));//click(By.xpath("//button[text()='Remove']"));
            pause(500);
        }
        int countAfter = countOfContacts();
        return countBefore - countAfter;
    }

    private boolean isCountListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();

    }

    public void openContactPage() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[normalize-space()='Remove']"));
        pause(1000);
    }

    public void removeAllContactTaya() {
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() != 0) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(500);
        }
    }

    public void provideContactData() {
        // add contact (3-4)
    }

    public boolean isContactMessageDisplayed() {

        return isElementPresent(By.cssSelector(".contact-page_message__2qafk"));
    }
}



