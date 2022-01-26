package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Comparison {
    private WebDriver driver;
    private int brDress = 0;

    public int getBrDress() {
        return brDress;
    }

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
    WebElement dressBtn;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")
    WebElement dress1;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[3]/div[2]")
    WebElement comp1;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]/div[2]/h5[1]/a[1]")
    WebElement dress2;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]/div[3]/div[2]/a[1]")
    WebElement comp2;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[2]/h5[1]/a[1]")
    WebElement dress3;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[3]/div[2]")
    WebElement comp3;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/form[1]/button[1]/span[1]")
    WebElement compareBtn;

    @FindBy(xpath = "//tbody/tr[1]")
    WebElement trElement;


    public Comparison(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    public void getDress() throws InterruptedException {
        Actions actions = new Actions(driver);
        dressBtn.click();
        actions.moveToElement(dress1).perform();
        clickBtnComp(comp1);
        Thread.sleep(2000);
        actions.moveToElement(dress2).perform();
        clickBtnComp(comp2);
        Thread.sleep(2000);
        actions.moveToElement(dress3).perform();
        clickBtnComp(comp3);
    }

    public void compare() {
        compareBtn.click();
    }

    public int numberOfDress() {
        List<WebElement> tdElements = trElement.findElements(By.tagName("td"));
        return tdElements.size() - 1;
    }

    private void clickBtnComp(WebElement comp) {
        comp.click();
        brDress++;
    }
}
