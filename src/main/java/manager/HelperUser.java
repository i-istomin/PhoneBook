package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    } //podcherknet krasnim. teper naslednik mojet polzovatsia vsem chto est u roditelia

    public void openLoginRegistrationForm() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
               type(By.xpath("//input[1]"), email); //fill email
               type(By.xpath("//input[2]"), password);//fill password
    }

    public void submitLogin() {
        click(By.xpath("//*[text()=' Login']"));//By.xpath("//*[text()=' Login']")

    }

    public boolean isSignOutPresent() {//is word  "sign out" display on the screen
       return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }
    public void logout(){ //click on button "sign out"
       // click(By.xpath("//*[contains(text(),'Sign Out']"));
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//*[text()=' Registration']"));  //   click(By.xpath("//button[2]"));
    }


}


