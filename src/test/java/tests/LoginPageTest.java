package tests;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataProviderUtils;
import java.util.Map;
public final class LoginPageTest extends BaseTest {
    private LoginPageTest(){}
    @Test(dataProvider="getData",dataProviderClass = DataProviderUtils.class)
    public void  loginLogoutTest(Map<String,String> data) {
        new LoginPage().performLogin(data.get("UserName"),data.get("Password")).clickOnHamburgerIcon().clickOnLogOut("Logout");
    }
}

