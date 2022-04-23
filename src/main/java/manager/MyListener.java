package manager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//listener-slovo iz seleniuma, nelzia prosto tak vziat i nazvat
public class MyListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener() {
        super();
    }
    //code->generate->ovveride method-> before find by+after find by+on exception

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start find element--->>>" + by);//pridet locator po kot-mu
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("The element with locator--->>>" + by + "<----was found");//chto nashlos
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("We have a 'throwable'--->>>" + throwable.getMessage());
        logger.info("We have a 'fill In Stack Trace'--->>>" + throwable.fillInStackTrace());//v console ukazivaet method iz za kot-go mi upali
        //Метод fillInStackTrace(), реализованный в классе Throwable позволяет получить объект типа Throwable.
        // Этот метод записывает в этот объект Throwable информацию о текущем состоянии кадров стека для текущего потока.
        //*********************
        // getStackTrace() - Предоставляет программный доступ к информации о трассировке стека, напечатанной функцией printStackTrace().
        //Как правило, это точка, в которой этот метательный объект был создан и брошен.

        int index=(int)(System.currentTimeMillis()/1000)%3600;
        HelperBase helperBase=new HelperBase(driver);
        helperBase.takeScreenShot("src/test/screenshots/screen-"+index+".png");

        logger.info("This is the link to screen with problem-->src/test/screenshots/screen-"+index+".png" );


    }
}
