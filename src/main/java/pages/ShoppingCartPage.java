package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    @FindBy(xpath = "//button[@class='faux-link' and contains(@aria-label,'Remove')]")
    private List<WebElement> removeProductButtonList;


    @FindBy(xpath = "//*[contains(@id,'dropdown')]")
    private WebElement quantityProductItem;


    @FindBy(xpath = "//span[contains(@class,'icon--confirmation')]")
    private WebElement offerAppliedIcon;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


    public void clickRemoveFirsProduct() {
        removeProductButtonList.get(0).click();
    }

    public void setQuantityProductItem(String quantity) {

        quantityProductItem.sendKeys(quantity);


    }

    public WebElement getQuantityProductItem() {
        return quantityProductItem;
    }


}
