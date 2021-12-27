package tests;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataProviderUtils;
import java.util.Map;
public final class CheckoutCompleteTest extends BaseTest{
    private CheckoutCompleteTest(){
    }
    @Test(dataProvider="getData",dataProviderClass = DataProviderUtils.class)
    public void completeCheckoutTest(Map<String,String> data){
        new LoginPage().performLogin(data.get("UserName"),data.get("Password"))
                .addToCartByProductName(data.get("ProductName"))
                .clickOnCartIcon()
                .clickOnCheckOutBtn()
                .completePersonalInfo(data.get("FirstName"),data.get("LastName"),data.get("Postcode"))
                .clickOnContinueButton()
                .clickOnFinish()
                .clickOnBackToHome();
    }

}
