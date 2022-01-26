package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Comparison;
import utils.PropReader;

import java.io.IOException;
import java.time.Duration;

public class TestComparison {
    private WebDriver wd;

    @BeforeClass
    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver", PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php?");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.manage().window().maximize();
    }

    @AfterClass
    public void exit() {
        wd.quit();
    }

    @Test
    public void copmarisonHappyPath() throws InterruptedException {
        Comparison comparison = new Comparison(wd);
        comparison.getDress();
        comparison.compare();
        Assert.assertTrue(wd.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=products-comparison&compare_product_list"), "The current url should be http://automationpractice.com/index.php?controller=products-comparison&compare_product_list");
        Assert.assertEquals(comparison.getBrDress(), comparison.numberOfDress(), "Error, the number of dress is wrong");
    }
}
