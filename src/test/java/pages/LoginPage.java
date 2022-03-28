package pages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverManager {

    @FindBy(id="username")
    private WebElement userNameInputText;

    @FindBy(id="login_button")
    private WebElement loginButton;

    @FindBy(id = "Password")
    private WebElement passwordInputText;

    @FindBy(id="username-helper-text")
    private WebElement errorMarker;

    public boolean userNameVisible(){
       return userNameInputText.isDisplayed();
    }

    public boolean loginButtonDisplayed() {
      return loginButton.isDisplayed();
    }

    public void enterWrongUserName() {
        waitUntilElementIsClickable(userNameInputText);
        userNameInputText.sendKeys("kevinPatel");
    }

    public void enterPassword() {
        waitUntilElementIsClickable(passwordInputText);
        passwordInputText.sendKeys("pa55word@");
    }

    public void clickLoginInButton() {
        waitUntilElementIsClickable(loginButton);
        loginButton.click();
    }

    public boolean errorMarker() {
        return errorMarker.isDisplayed();
    }

    public void correctUserName() {
       userNameInputText.sendKeys("pa55word");
    }


}
