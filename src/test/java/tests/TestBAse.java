package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBAse {
    WebDriver wd;

    @BeforeMethod
    public void init() { //browser+https
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//LONG TIME, TIMEUNIT
//delaem vremia tak kak internet stranichki mogut gruzitsia a web driver uje zashel i togda on mjet ne neiyti nujniy emu element
        //esli v techeni 10 sec ne naydet, to viydet exception
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");

    }

    @AfterMethod
    public void tearDown(){ //zakrivae, stranizu
        wd.quit();
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
    public void click(By locator){
        wd.findElement(locator).click();
    }


    public boolean isElementPresent(By locator){//vajno chtob mne vernuli true/false
        return wd.findElements(locator).size()>0;
    }

}



//HOMEWORK
// OPEN NEW PROJJECT WITH THE SAME STEPS https://ilcarro.xyz/