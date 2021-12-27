package pages;
import enums.WaitStratergy;
import org.openqa.selenium.By;
import utils.DynamicXpathUtils;
public final class MenuPage extends BasePage {
    private String leftMenu= "//*[contains(text(),'%s')]";
    public LoginPage clickOnLogOut(String menuName){
        String newXpath= DynamicXpathUtils.constructXpath(leftMenu  ,menuName);
        userDefinedClick(By.xpath( newXpath), WaitStratergy.CLICKABLE,menuName);
        return new LoginPage();
    }

}

