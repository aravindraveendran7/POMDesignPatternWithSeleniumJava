package driver;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.ReadPropertyFile;

import java.util.Objects;

public final class Driver {
    private Driver(){}
    static WebDriver driver;
    public static void initDriver(String browser) throws Exception {
        if (Objects.isNull(DriverManager.getDriver())){
            if (browser.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
            }else if (browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
            }else if (browser.equalsIgnoreCase("safari")){
                WebDriverManager.safaridriver().setup();
                DriverManager.setDriver(new SafariDriver());
            }
            DriverManager.getDriver().get(ReadPropertyFile.get(ConfigProperties.URL));
            DriverManager.getDriver().manage().window().maximize();
        }
    }
    public  static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unLoad();
        }
    }
}
