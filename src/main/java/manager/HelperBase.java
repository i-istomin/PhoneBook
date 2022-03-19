package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}