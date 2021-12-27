package tests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.YourCartPage;
import utils.DataProviderUtils;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public final class AddToCartTest extends BaseTest{
    private AddToCartTest(){}
    @Test(dataProvider="getData",dataProviderClass = DataProviderUtils.class)
    public void addToCartByProductNameTest(Map<String,String> data){
        String produtName=new LoginPage().performLogin(data.get("UserName"),data.get("Password"))
                       .addToCartByProductName(data.get("ProductName"))
                       .clickOnCartIcon()
                       .validateProductName();
       assertThat(produtName).isEqualTo(data.get("ProductName"));
       new YourCartPage().removeProductFromCartByName(data.get("ProductName"));
    }
    @Test(dataProvider="getData",dataProviderClass = DataProviderUtils.class)
    public void removeProductFromCartTest(Map<String,String> data){
            new LoginPage().performLogin(data.get("UserName"),data.get("Password"))
                .addToCartByProductName(data.get("ProductName"))
                .clickOnCartIcon()
                .removeProductFromCartByName(data.get("ProductName"));
    }
}
