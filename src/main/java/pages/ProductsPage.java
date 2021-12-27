package pages;

import enums.WaitStratergy;
import org.openqa.selenium.By;
import utils.DynamicXpathUtils;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
public final class ProductsPage extends BasePage {
    private String btnAddToCart="//*[contains(text(),'%s')]/../../following-sibling::div[1]/child::button";
    private  final By hamBurgerIcon= By.xpath("//div[@class='bm-burger-button']/child::button");
    private final By cartIcon=By.xpath("//a[@class='shopping_cart_link']");
    private final By productSort=By.xpath("//select[@class='product_sort_container']");
    private final By inventoryList=By.xpath("//div[@class='inventory_item_name']/parent::a");
    private final By inventoryItemPrice=By.xpath("//div[@class='inventory_item_price']");
    public MenuPage clickOnHamburgerIcon(){
        userDefinedClick(hamBurgerIcon,WaitStratergy.CLICKABLE,"HamburgerIcon");
        return new MenuPage();
    }
    public YourCartPage clickOnCartIcon(){
        userDefinedClick(cartIcon,WaitStratergy.CLICKABLE,"cartIcon");
        return new YourCartPage();
    }
    public ProductsPage addToCartByProductName(String productName){
        String newXpath= DynamicXpathUtils.constructXpath(btnAddToCart,productName);
        userDefinedClick(By.xpath(newXpath), WaitStratergy.CLICKABLE,"AddToCart");
        return this;
    }
    public boolean filterProductsByName(String order){
        List<String>listBeforeFilter=userDefinedGetListOfValues(inventoryList,WaitStratergy.PRESENCE,"InventoryListBeforeSort");
        userDefinedSelectValue(productSort,WaitStratergy.PRESENCE,order,order);
        List<String>lisftAfterFilter=userDefinedGetListOfValues(inventoryList,WaitStratergy.PRESENCE,"InventoryListAfterSort");
        if (order.equalsIgnoreCase("az")){
            Collections.sort(listBeforeFilter);
        }else {
            Collections.sort(listBeforeFilter,Collections.reverseOrder());
        }
        if (listBeforeFilter.equals(lisftAfterFilter)) {
            return true;
        }else{
            return false;
        }
    }
    public boolean filterProductsByPrice(String order){
        List<Double>listBeforeFilter=(userDefinedGetListOfValues(inventoryItemPrice,WaitStratergy.PRESENCE,"InventoryPriceBeforeSort"))
                                    .stream().map(Double::parseDouble).collect(Collectors.toList());
        userDefinedSelectValue(productSort,WaitStratergy.PRESENCE,order,order);
        List<Double>lisftAfterFilter=userDefinedGetListOfValues(inventoryItemPrice,WaitStratergy.PRESENCE,"InventoryPriceAfterSort")
                                    .stream().map(Double::parseDouble).collect(Collectors.toList());
        if (order.equalsIgnoreCase("lohi")){
            Collections.sort(listBeforeFilter);
        }else {
            Collections.sort(listBeforeFilter,Collections.reverseOrder());
        }
        if (listBeforeFilter.equals(lisftAfterFilter)) {
            return true;
        }else{
            return false;
        }
    }
}
