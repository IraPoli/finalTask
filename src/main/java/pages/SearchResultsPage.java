package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigInteger;
import java.util.List;

public class SearchResultsPage extends BasePage {


    @FindBy(xpath = "//ul[contains(@class,'fake-tabs')]//a[contains(@href,'BIN=1')]")
    private WebElement buyItNowButton;

    @FindBy(xpath = "//img[contains(@class,'s-item')]")
    private List<WebElement> productList;

    @FindBy(xpath = "//input[@aria-label='Minimum Value in $']")
    private WebElement minimumPriceLimit;
    @FindBy(xpath = "//input[@aria-label='Maximum Value in $']")
    private WebElement maxPriceLimit;

    @FindBy(xpath = "//a[@_sp='p2351460.m43632.l8566']")
    private WebElement priceRangeButton;

    @FindBy(xpath = "//button[@aria-label='Submit price range']")
    private WebElement submitPriceRangeButton;


    @FindBy(xpath = "//button[contains(@aria-label,'Best Match')]")
    private WebElement filerButton;


  //  @FindBy(xpath = "//*[@id='s0-14-11-5-2[0]-37-0-content-menu']/li[5]/a/span")

    @FindBy(xpath = "//span[text()='Price + Shipping: highest first']")
    private WebElement highestFirstButton;


    @FindBy(xpath = " //span[@class='s-item__price']")
    private List<WebElement> productPriceList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickBuyItNowButton() {
        buyItNowButton.click();
    }

    public void clickSubmitPriceRangeButton() {
        submitPriceRangeButton.click();
    }

    public void selectFirstProduct() {
        productList.get(0).click();
    }


    public void setMinimumPriceLimit(final String minimumPrice) {
        minimumPriceLimit.clear();
        minimumPriceLimit.sendKeys(minimumPrice);
    }

    public void setMaxPriceLimit(final String maxPrice) {
        maxPriceLimit.clear();
        maxPriceLimit.sendKeys(maxPrice);
    }


    public int getProductListLength() {
        return productList.size();
    }

    public WebElement getPriceRangeButton() {
        return priceRangeButton;
    }

    public WebElement getFilerButton() {
        return filerButton;
    }

    public void clickFilterButton() {
        filerButton.click();
    }

    public void clickHighestFirstButton() {
        highestFirstButton.click();
    }

    public boolean isPriseSorted() {

        String maxPrice = productPriceList.get(0).getText().replaceAll("[$|.|,]", "");


        BigInteger mPrice = new BigInteger(maxPrice);
        for (int i = 1; i < productPriceList.size(); i++) {

            String prom = productPriceList.get(i).getText().replaceAll("[$|.|,]", "");
            BigInteger pr = new BigInteger(prom);

            if (pr.compareTo(mPrice) > 0) {
                return false;
            }
        }
        return true;
    }


}

