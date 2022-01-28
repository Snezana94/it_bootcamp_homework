package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TextBox;

import java.io.IOException;
import java.time.Duration;

public class TestTextBox {
    private WebDriver wd;
    private Faker faker;

    @Test (dataProvider = "dp")
    public void testTextBox(String name, String email, String addr1, String addr2) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.get("https://demoqa.com/text-box");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.manage().window().maximize();

        TextBox textBox = new TextBox(wd);
        textBox.textBox(name, email, addr1, addr2);
        Assert.assertTrue(textBox.aBoolean());

        wd.quit();
    }

    @DataProvider (name = "dp")
    public Object[][] textB() {
        faker = new Faker();
        Object[][] randomUsers = new Object[][] {
                {faker.name().firstName(), "email1@example.com", faker.address().cityName(), faker.address().cityName()},
                {faker.name().firstName(), "email2@example.com", faker.address().cityName(), faker.address().cityName()}
        };

        return randomUsers;

    }

}
