package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd; // vmesto  WebDriver wd razmestili EventFiringWebDriver

    HelperUser helperuser;
    ContactHelper contact;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);


    public void init() {
        wd = new EventFiringWebDriver(new ChromeDriver());//vmesto new ChromeDriver(); sozdali EventFiringWebDriver
        logger.info("All tests start in ChromeDriver");
        System.setProperty("webdriver.chrome.driver", "/home/i-istomin/TelRan/SYSTEMS/Qa32_StartSelenium/chromedriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//LONG TIME, TIMEUNIT
        //delaem vremia tak kak internet stranichki mogut gruzitsia a web driver uje zashel i togda on mjet ne neiyti nujniy emu element
        //esli v techeni 10 sec ne naydet, to viydet exception
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        helperuser = new HelperUser(wd);//inizializirovali i napisali chemu in raven
        contact = new ContactHelper(wd);

        wd.register(new MyListener());
    }

    public void stop() {
        //  wd.quit();//zakrivaem browser
    }

    //pravaya knopka+generate+getter+helper+ok
    public HelperUser getHelperuser() {
        return helperuser;
        //potom idem v testbase i udaliaem webdriver
    }

    public ContactHelper getContact() {
        return contact;
    }


}