package pages;

import enums.WaitStratergy;
import org.openqa.selenium.By;

public final class CheckoutCompletePage extends BasePage{
    private final By btnBackToHome= By.id("back-to-products");
    public ProductsPage clickOnBackToHome(){
        userDefinedClick(btnBackToHome, WaitStratergy.CLICKABLE,"BackToHome");
        return new ProductsPage();
    }
}
