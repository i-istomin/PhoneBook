package tests;

import manager.TestNgListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestNgListener.class)
public class OpenWiki {

    WebDriver wd;//delaem otdelniy webdriver

    @Test
    public void openWikipedia(){
        wd=new ChromeDriver();
        wd.get("https://ru.wikipedia.org/");
    }
}
