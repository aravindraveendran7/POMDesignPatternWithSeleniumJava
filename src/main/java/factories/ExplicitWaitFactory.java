package factories;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStratergy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ExplicitWaitFactory {
    public static WebElement performExplicitWait(WaitStratergy waitstratergy, By by) {
        WebElement element = null;
        if (waitstratergy== WaitStratergy.PRESENCE) {
            element=new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait()).until(ExpectedConditions.presenceOfElementLocated(by));
        }else if (waitstratergy==WaitStratergy.CLICKABLE) {
            element=new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitWait()).until(ExpectedConditions.elementToBeClickable(by));
        }else if(waitstratergy==WaitStratergy.VISIBLE){
            element=new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitWait()).until(ExpectedConditions.presenceOfElementLocated(by));
        }else if(waitstratergy== WaitStratergy.NONE){
            element=DriverManager.getDriver().findElement(by);
        }
        return element;
    }

}
