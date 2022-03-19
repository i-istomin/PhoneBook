package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperuser;


    public void init() {
        wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/home/i-istomin/TelRan/SYSTEMS/Qa32_StartSelenium/chromedriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//LONG TIME, TIMEUNIT
//delaem vremia tak kak internet stranichki mogut gruzitsia a web driver uje zashel i togda on mjet ne neiyti nujniy emu element
        //esli v techeni 10 sec ne naydet, to viydet exception
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        helperuser = new HelperUser(wd);//inizializirovali i napisali chemu in raven

    }

    public void stop() {
      //  wd.quit();//zakrivaem browser

    }

    //pravaya knopka+generate+getter+helper+ok
    public HelperUser getHelperuser() {
        return helperuser;
        //potom idem v testbase i udaliaem webdriver
    }
}