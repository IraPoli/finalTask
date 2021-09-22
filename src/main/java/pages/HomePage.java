package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//a[contains(@class, 'cart-count')]")
    private WebElement cartIconCount;

    @FindBy(xpath = "//a[@class = 'gh-eb-li-a gh-rvi-menu' and contains(@href,'pay')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//span[@id='gh-ug']//a[contains(@href, 'signin.ebay')]")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains(@href, 'reg.ebay')]")
    private WebElement registerButton;


    @FindBy(xpath = "//button[@class='gh-control']")
    private WebElement categoryButton;


    @FindBy(xpath = "//select[contains(@name,'_sacat')]")
    private WebElement selectCategoryForSearchButton;


    @FindBy(xpath = "//input[contains(@class,'input')]")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id='gh-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//h3[@class='gh-sbc-parent']//a[contains(@href,'Sporting-Goods')]")
    private WebElement sportingGoodsCategoryButton;


    @FindBy(xpath = "//a[@aria-label='Advanced Search']")
    private WebElement advancedSearchButton;


    @FindBy(xpath = "//a[contains(@aria-label,'eBay sites')]")
    private WebElement eBaySites;


    @FindBy(xpath = "//b[@class='flpl gf-if gspr']")
    private WebElement polishSites;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }


    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickCategoryButton() {
        categoryButton.click();
    }

    public void clickSportingGoodsCategoryButton() {
        sportingGoodsCategoryButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickCartIconCount() {
        cartIconCount.click();
    }

    public void clickAdvancedSearchButton() {
        advancedSearchButton.click();
    }


    public void clickEBaySites() {
        eBaySites.click();
    }

    public void clickPolishSites() {
        polishSites.click();
    }


    public String getAmountOfProductsInCartList() {
        return cartIconCount.getText();
    }


    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isCartIconVisible() {
        cartIcon.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void isRegisterButtonVisible() {
        registerButton.isDisplayed();
    }

    public void isSignInVisible() {
        signInButton.isDisplayed();
    }

    public void isCategoryButtonVisible() {
        categoryButton.isDisplayed();
    }

    public boolean isURSContains(String sites) {
        return driver.getCurrentUrl().contains(sites);
    }

    public WebElement getCartListProductsCount() {
        return cartIconCount;
    }


}
