package pages;
import enums.WaitStratergy;
import org.openqa.selenium.By;
import utils.DynamicXpathUtils;
public final class YourCartPage extends BasePage {
    private final By btnCheckout=By.id("checkout");
    private final   By inventoryName=By.xpath("//div[@class='inventory_item_name']");
    private String removeButton="//*[contains(text(),'%s')]/../../child::div[2]/child::div/following-sibling::button";
    public String validateProductName(){
        return userDefinedGetText(inventoryName,WaitStratergy.VISIBLE,"inventoryName");
    }
    public YourCartPage removeProductFromCartByName(String productName){
        String newXpath=DynamicXpathUtils.constructXpath(removeButton,productName);
        userDefinedClick(By.xpath(newXpath),WaitStratergy.PRESENCE,productName);
        return this;
    }
    public CheckoutPage clickOnCheckOutBtn(){
        userDefinedClick(btnCheckout,WaitStratergy.PRESENCE,"Checkout");
        return new CheckoutPage();
    }

}
