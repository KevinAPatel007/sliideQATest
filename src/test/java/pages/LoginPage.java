package pages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverManager {

    @FindBy(id="password")
    private WebElement PasswordinputText;

    @FindBy(id="login_button")
    private WebElement loginButton;

    @FindBy(id = "username")
    private WebElement UserInputText;

    @FindBy(id="username-helper-text")
    private WebElement errorMarker;

    public boolean userNameVisible(){
       return UserInputText.isDisplayed();
    }

    public boolean loginButtonDisplayed() {
      return loginButton.isDisplayed();
    }

    public void enterWrongUserName() {
        waitUntilElementIsClickable(UserInputText);
        UserInputText.sendKeys("kevinPatel");
    }

    public void enterPassword() {
        waitUntilElementIsClickable(PasswordinputText);
        PasswordinputText.sendKeys("pa55word@");
    }

    public void clickLoginInButton() {
        waitUntilElementIsClickable(loginButton);
        loginButton.click();
    }

    public boolean errorMarker() {
        return errorMarker.isDisplayed();
    }

    public void correctUserPassword() {
       PasswordinputText.sendKeys("pa55word");
    }


}
