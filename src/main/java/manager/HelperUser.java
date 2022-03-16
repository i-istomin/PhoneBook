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
        //fill email
        type(By.xpath("//input[1]"), "missira85@gmail.com");
        //fill password
        type(By.xpath("//input[2]"), "Passw0rd$");
    }

    public void submitLogin() {
        click(By.xpath("//*[text()=' Login']"));
    }

    public boolean isLoginRegistrationSuccess() {
       return isElementPresent(By.xpath("//*[text()='Sign Out']"));

    }

    public void submitRegistration() {
By.ByXPath.button[2]
    }
    // naslednik obizan ispolzovat constructor superclassa
    //najimaem alt+enter+create constructor
}


