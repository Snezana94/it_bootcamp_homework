package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBox {
    private WebDriver wd;
    public TextBox(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

    @FindBy(xpath = "//input[@id='userName']")
    WebElement username;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement email;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement address1;

    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    WebElement address2;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement btn;

    @FindBy(xpath = "//*[@id=\"output\"]/div")
    WebElement assDiv;

    public boolean aBoolean() {
        return assDiv.isDisplayed();
    }

    public void textBox(String username, String email, String addr1, String addr2) {
        this.username.sendKeys(username);
        this.email.sendKeys(email);
        this.address1.sendKeys(addr1);
        this.address2.sendKeys(addr2);
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", btn);
        this.btn.click();
    }
}
