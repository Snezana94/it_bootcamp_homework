import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public class DomaciWikipedia {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));
        WebDriver wd = new ChromeDriver();
        wd.get("https://www.wikipedia.org/");
        wd.manage().window().maximize();

        Thread.sleep(2000);

        WebElement languageSearch = wd.findElement(By.xpath("//select[@id='searchLanguage']"));
        languageSearch.click();

        WebElement language = wd.findElement(By.xpath("//option[contains(text(),'Српски / Srpski')]"));
        language.click();

        WebElement input = wd.findElement(By.xpath("//input[@id='searchInput']"));
        input.sendKeys("java");

        Thread.sleep(2000);

        WebElement java = wd.findElement(By.xpath("//*[@id=\"typeahead-suggestions\"]/div/a[2]/div[1]/h3"));
        java.click();

        Thread.sleep(2000);

        WebElement heading = wd.findElement(By.xpath("//h1[@id='firstHeading']"));
        if (heading.getText().contains("Java (програмски језик)")) {
            System.out.println("Naslov je odgovarajuci");
        } else {
            System.out.println("Pogresan naslov");
        }

        Thread.sleep(2000);

        wd.close();


    }
}
