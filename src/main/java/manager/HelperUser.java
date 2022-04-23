package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelperUser extends HelperBase  {


    public HelperUser(WebDriver wd) {//podcherknet krasnim. teper naslednik mojet polzovatsia vsem chto est u roditelia
        super(wd);
    }

    public void openLoginRegistrationForm() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email); //fill email
        type(By.xpath("//input[2]"), password);//fill password
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }


    public void submitLogin() {
        click(By.xpath("//*[text()=' Login']"));//By.xpath("//*[text()=' Login']")
    }

    public boolean isSignOutPresent() {//is word  "sign out" display on the screen
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void logout() { //click on button "sign out"
        click(By.xpath("//button[text()='Sign Out']")); // click(By.xpath("//*[contains(text(),'Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//*[text()=' Registration']"));  //   click(By.xpath("//button[2]"));
    }


    public void handleAlert() {
        Alert alert = wd.switchTo().alert();  // Switching to Alert
        String alertMessage = wd.switchTo().alert().getText();  // Capturing alert message.
        System.out.println(alertMessage); // Displaying alert message
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alert.accept(); // A ccepting alert
    }

    public boolean isRegistrationErrorDisplayed() {
        return isElementPresent(By.xpath("//*[.='Registration failed with code 400']"));
    }


    public boolean isAlertDisplayed() {
        //zajali ALT+ENTER-->introduce local variable-> alert
        //posle cklick na knopku login, mi znaem chto uspeha ne budet. u nas negativniy test. i my
        //znaem  chto sistaema vidaet alert
        //poetomu nam nujno napisat metod kot-y provetrit esli alert poyavilsia ili net, i takim obrazom mi vidadim true ili false
        Alert alert = new WebDriverWait(wd, 10).until(ExpectedConditions.alertIsPresent());
        // mi vivizem wait i daem na poyavlenie etogo alerta 10 sec
        if (alert == null) { //esli alert ne poyavilsia, to vernem false
            return false;
        } else {
            return true; //togda zapishem obyect alert
        }
    }

    public boolean isErrorWrongFormat() {
        Alert alert = new WebDriverWait(wd, 10).until(ExpectedConditions.alertIsPresent());//snachala dojidaemsia poka alert poyavitsia
        wd.switchTo().alert(); //potom perekluchaem alert na drugoe okno
        String error= alert.getText();//vichitivaet text kot-y vpisan v alert
        System.out.println(error);
        alert.accept();
        return error.contains("Wrong email or password format");
    }


    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
    }

    public void openContactPage() {
        click(By.xpath("//a[@class='active']"));

    }




}


