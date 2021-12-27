package pages;
import enums.WaitStratergy;
import org.openqa.selenium.By;
public final class CheckoutPage extends BasePage{
    private final By textBoxfirstName=By.id("first-name");
    private final By textBoxlastName=By.id("last-name");
    private final By textBoxPinCode=By.id("postal-code");
    private final By btnContinueButton=By.id("continue");
    private CheckoutPage inputFirstName(String reqFirstName){
        userDefinedEnterText(textBoxfirstName,reqFirstName,WaitStratergy.PRESENCE,"firsName");
        return this;
    }
    private CheckoutPage inputlastName(String reqLastName){
        userDefinedEnterText(textBoxlastName,reqLastName,WaitStratergy.PRESENCE,"lastName");
        return this;
    }
    private CheckoutPage inputPincode(String reqPinCode){
        userDefinedEnterText(textBoxPinCode,reqPinCode,WaitStratergy.PRESENCE,"pinCode");
        return this;
    }
    public CheckoutPage completePersonalInfo(String firstName,String lastName,String pinCode){
      inputFirstName(firstName);
      inputlastName(lastName);
      inputPincode(pinCode);
      return  this;
    }
    public CheckoutOverviewPage clickOnContinueButton( ){
         userDefinedClick(btnContinueButton,WaitStratergy.CLICKABLE,"ContinueButton");
         return new CheckoutOverviewPage();
    }
}
