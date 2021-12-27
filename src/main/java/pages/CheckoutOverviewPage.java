package pages;
import enums.WaitStratergy;
import org.openqa.selenium.By;
public final class CheckoutOverviewPage extends BasePage{
    private final By btnFinish= By.id("finish");
    public CheckoutCompletePage clickOnFinish(){
        userDefinedClick(btnFinish, WaitStratergy.CLICKABLE,"Finish");
        return new CheckoutCompletePage();
    }
}
