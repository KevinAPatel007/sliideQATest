package driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DriverManager {

     public static WebDriver driver;
     String browser="chrome";

    public DriverManager(){
        PageFactory.initElements(driver,this);
    }

     public void runOnLocalBrowser() throws IllegalAccessException {
          switch (browser){
               case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
               case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;
              case "safari":
                  driver= new SafariDriver();
                  break;
              case "firefox":
                  WebDriverManager.firefoxdriver().setup();
                  driver=new FirefoxDriver();
                  break;
               default:
                    throw new IllegalAccessException("Unexpected browser");
          }
     }

    public void maxBrowser(){
        driver.manage().window().maximize();
    }

    public void applyImlicitWait(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void sleepBrowser(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    public void goToUrl(){
        driver.get("http://localhost:3000/");
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public WebElement waitUntilElementIsClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,30);
        return     wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void takeElementscreenshot(WebElement element, String fileName)  {
        File scnFile =element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scnFile, new File("./target/screenshots/" +fileName+ ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(Scenario scenario){

        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot, "image/png");
        //take a screenshot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("/Users/kevin/Desktop/screanshotTests/Error.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int generateRandomNumber(){
        Random random = new Random();
        // Obtain a number between [0 - 49].
        return random.nextInt(50);
    }

}
