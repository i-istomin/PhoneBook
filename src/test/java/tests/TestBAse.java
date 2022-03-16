package tests;
//optimizirovat code posle ogo kak perenesem vse metodi v helperbase
import manager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBAse {
    //udaliaem webdriver i vmesto nego pishem :
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() { //browser+https
        //udaliaem ves method i vse chto bilo vbutri klassa wb/maximize
        //pereeimenovivaem  ethod  public void init() { v  public void setUp() {

        app.init();

    }

    @AfterMethod
    public void tearDown() { //zakrivae, stranizu
        //wd.quit();-> udaliaem
        app.stop();
    }
//======================================================================================================================
//metod type ponadobitsia dlia raznig szenariev i on budet bazovim dlia kajdogo helpera --> perenestsia v helperBase
//    public void type(By locator, String text) {
//        //doljni proverit na null, potomu chto nam ne nujen element null, mi ne budem zahodit tuda, poetomu mi proverim vnachale esli est null ili net
//        if (text != null) {
//            WebElement element = wd.findElement(locator);
//            element.click();
//            element.clear();
//            element.sendKeys(text);
//
//        }
//    }
//
//    //napishem eshe odin vspamagatelniy metod,mkot-y postaoyanno povtoriaetsia v nashih klassah
//    //metod click ponadobitsia dlia raznig szenariev i on budet bazovim dlia kajdogo helpera --> perenestsia v helperBase
//    public void click(By locator) {
//        wd.findElement(locator).click();
//    }
//
//    //metod boolean ponadobitsia dlia raznig szenariev i on budet bazovim dlia kajdogo helpera--> perenestsia v helperBase
//    public boolean isElementPresent(By locator) {//vajno chtob mne vernuli true/false
//        return wd.findElements(locator).size() > 0;
//    }
    //====================================================================================================================

}


//HOMEWORK1
// OPEN NEW PROJJECT WITH THE SAME STEPS https://ilcarro.xyz/

//HOMEWORK2: MADE ARCHITECTURE ON THE https://ilcarro.xyz/