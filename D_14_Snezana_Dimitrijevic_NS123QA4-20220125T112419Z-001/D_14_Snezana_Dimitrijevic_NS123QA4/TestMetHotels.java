package domaci;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.PropReader;

import java.io.IOException;
import java.time.Duration;

public class TestMetHotels {
    private WebDriver wd;

    @BeforeClass
    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver", PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));
        wd = new ChromeDriver();
        wd.get("https://it-255-dz-06-andjela-bojic3972.vercel.app/");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.manage().window().maximize();
    }

    @AfterClass
    public void exit() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");  //korisno staviti uz wd.close(), gasi sve zaostale prozore;
        wd.close();
    }

    @Test
    public void izmeni() throws InterruptedException {
        MetHotels metHotels = new MetHotels(wd);
        metHotels.izmeni();
        Assert.assertTrue(metHotels.getAssertNaziv());
    }
}
