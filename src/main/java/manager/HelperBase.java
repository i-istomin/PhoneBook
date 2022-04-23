package manager;

import com.google.common.io.Files;
import models.User;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static com.google.common.io.Files.copy;
import static java.io.File.*;

public class HelperBase {
    WebDriver wd;
    //sozdaem konstruktor: pravaya knopka+generate+constructor+ok

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }


    public void type(By locator, String text) {
        //doljni proverit na null, potomu chto nam ne nujen element null, mi ne budem zahodit tuda, poetomu mi proverim vnachale esli est null ili net
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);

        }
    }

    //napishem eshe odin vspamagatelniy metod,mkot-y postaoyanno povtoriaetsia v nashih klassah
    //metod click ponadobitsia dlia raznig szenariev i on budet bazovim dlia kajdogo helpera --> perenestsia v helperBase
    public void click(By locator) {
        wd.findElement(locator).click();
    }

    //metod boolean ponadobitsia dlia raznig szenariev i on budet bazovim dlia kajdogo helpera--> perenestsia v helperBase
    public boolean isElementPresent(By locator) {//vajno chtob mne vernuli true/false
        return wd.findElements(locator).size() > 0;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis); //metod sleep trebuet brosit exception ili try catch
            //lucheshe try catch, potomu chto exception mi doljni budem dobavit vezde v proekte
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenShot(String pathToFile){
        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);

        File screenshot = new File(pathToFile);

        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//
//    public void openLoginRegistrationForm() {
//        click(By.cssSelector("[href='/login']")); //
//    }
//
//    public void fillLoginRegistrationForm(String email, String password) {
//        type(By.xpath("//input[1]"), email); //fill email
//        type(By.xpath("//input[2]"), password);//fill password
//    }
//
//    public void fillLoginRegistrationForm(User user) {
//        type(By.xpath("//input[1]"), user.getEmail());
//        type(By.xpath("//input[2]"), user.getPassword());
//    }
//
//    public void submitLogin() {
//        click(By.xpath("//*[text()=' Login']"));//By.xpath("//*[text()=' Login']")
//    }
//}