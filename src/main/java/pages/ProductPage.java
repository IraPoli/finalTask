package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='itemTitle']")
    private WebElement productTitleItem;


    @FindBy(xpath = "//*[@id='qtyTextBox']")
    private WebElement productQuantityItem;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public String getTitleText() {
        return productTitleItem.getText();
    }

    public void setProductQuantityItem(final String quantity) {

        productQuantityItem.sendKeys("2");
    }

}
