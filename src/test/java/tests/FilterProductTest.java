package tests;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataProviderUtils;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public final class FilterProductTest extends BaseTest{
    private FilterProductTest(){}
    @Test(dataProvider="getData",dataProviderClass = DataProviderUtils.class)
    public void filterProductByNameTest(Map<String,String> data){
        Boolean isSortedByName=new LoginPage().performLogin(data.get("UserName"),data.get("Password"))
                .filterProductsByName(data.get("FilterCriteria"));
        assertThat(isSortedByName).isTrue();
    }
    @Test(dataProvider="getData",dataProviderClass = DataProviderUtils.class)
    public void filterProductByPriceTest(Map<String,String> data){
        Boolean isSortedByPrice=new LoginPage().performLogin(data.get("UserName"),data.get("Password"))
                .filterProductsByPrice(data.get("FilterCriteria"));
        assertThat(isSortedByPrice).isTrue();
    }
}
