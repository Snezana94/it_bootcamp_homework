package domaci;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class MetHotels {
    private WebDriver driver;

    public MetHotels(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[1]/div[1]/div[1]/div[1]/a[1]")
    WebElement zutoIzmeni;

    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[1]/div[1]/form-dodaj-smestaj[1]/form[1]/div[1]/input[1]")
    WebElement naziv;

    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[1]/div[1]/form-dodaj-smestaj[1]/form[1]/div[2]/input[1]")
    WebElement adresa;

    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[1]/div[1]/form-dodaj-smestaj[1]/form[1]/div[3]/input[1]")
    WebElement cena;

    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[1]/div[1]/form-dodaj-smestaj[1]/form[1]/div[4]/input[1]")
    WebElement slika;

    @FindBy(xpath = "//button[contains(text(),'Izmeni')]")
    WebElement plavoIzmeni;

    @FindBy(xpath = "/html/body/app-root/div/div/div[2]/lista-smestaja-component/div/smestaj-component[1]/div/div/h5[1]")
    WebElement assertNaziv;

    public Boolean getAssertNaziv() {
        return assertNaziv.getText().contains("Naziv izmenjen");
    }

    public void izmeni() throws InterruptedException {
        zutoIzmeni.click();
        naziv.sendKeys("Naziv izmenjen");
        adresa.sendKeys("Adresa izmenjena");
        cena.sendKeys("1500");
        slika.sendKeys("https://www.campusedgeraleigh.com/img/cache/p71/c3224/155725/2d9fc1f59b87a5e2a29372fcdc072143/Campus-Edge-Raleigh-Apartments-Near-NC-State-University-Fully-Furnished-Living-Room.jpeg");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        Thread.sleep(10000);
        plavoIzmeni.click();
    }
}
