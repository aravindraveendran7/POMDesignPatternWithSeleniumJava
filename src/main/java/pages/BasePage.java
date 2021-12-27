package pages;

import enums.WaitStratergy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import reports.ExtentLogger;
import java.util.ArrayList;
import java.util.List;
public class BasePage {
    protected void userDefinedClick(By by, WaitStratergy waitstratergy, String elementName) {
        ExplicitWaitFactory.performExplicitWait(waitstratergy, by).click();
        try {
             ExtentLogger.pass(elementName+" is clicked ",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void userDefinedEnterText(By by,String value,WaitStratergy waitstratergy,String elementname) {
        ExplicitWaitFactory.performExplicitWait(waitstratergy, by).sendKeys(value);
        try {
            ExtentLogger.pass(value+" is entered successfully in "+elementname,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected String userDefinedGetText(By by,WaitStratergy waitstratergy,String elementname) {
        String capturedText=ExplicitWaitFactory.performExplicitWait(waitstratergy, by).getText().trim();
        try {
            ExtentLogger.pass(capturedText+" is capture successfully "+elementname,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return capturedText;
    }
    protected void userDefinedSelectValue(By by,WaitStratergy waitstratergy,String value,String elementname) {
        Select order=new Select(ExplicitWaitFactory.performExplicitWait(waitstratergy, by));
        order.selectByValue(value);
        try {
            ExtentLogger.pass(value+" is selected successfully "+elementname,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected List<String> userDefinedGetListOfValues(By by, WaitStratergy waitstratergy, String elementname) {
        List<WebElement>listoElements= ExplicitWaitFactory.performExplicitWait(waitstratergy, by).findElements(by);
        List<String>listOfValues=new ArrayList<>();
        for (WebElement e:listoElements) {
            listOfValues.add(e.getText().replace("$",""));
        }
        try {
            ExtentLogger.pass(listOfValues+" is captured successfully "+elementname,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfValues;
    }


}
