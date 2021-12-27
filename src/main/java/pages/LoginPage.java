package pages;
import enums.WaitStratergy;
import org.openqa.selenium.By;
public final class LoginPage extends BasePage{
    private final By textboxUserName=By.id("user-name");
    private final By textboxPassword=By.id("password");
    private final By btnLogin=By.id("login-button");
    private LoginPage enterUserName(String username){
        userDefinedEnterText(textboxUserName,username,WaitStratergy.PRESENCE,"usernamefield");
        return this;
    }
    private LoginPage enterPassword(String password){
        userDefinedEnterText(textboxPassword,password,WaitStratergy.PRESENCE,"passwordfield");
        return this;
    }
    private ProductsPage clickLoginBtn(){
        userDefinedClick(btnLogin,WaitStratergy.CLICKABLE,"loginbutton");
        return new ProductsPage();
    }
    public ProductsPage performLogin(String username,String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginBtn();
        return new ProductsPage();
    }

}

