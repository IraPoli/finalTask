package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;


public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    SignInPage signInPage;
    PageFactoryManager pageFactoryManager;
    ShopCategoryPage shopCategoryPage;
    AdvancedSearchPage advancedSearchPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }


    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {

        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickSearchButton();
    }

    @And("User click BuyItNow button")
    public void clickClickBuyItNowButton() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickBuyItNowButton();
    }

    @And("User clicks first product")
    public void userClicksFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);


        searchResultsPage.selectFirstProduct();
    }

    @And("User clicks add to Cart button")
    public void userClicksAddToCartButton() {

        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartButton());

        productPage.clickAddToCartButton();
    }

    @Then("User checks that amount of products in Cart are {string}")
    public void userChecksThatAmountOfProductsInCartAreAmountOfProducts(final String expectedAmount)  {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCartListProductsCount());
        String str = homePage.getAmountOfProductsInCartList();
        assertEquals(str, expectedAmount);

    }


    @And("User checks header visibility")
    public void userChecksHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks footer visibility")
    public void userChecksFooterVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isFooterVisible();
    }

    @After
    public void tearDown() {
        driver.close();
    }


    @And("User checks cart visibility")
    public void userChecksCartVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isCartIconVisible();
    }

    @And("User checks register button visibility")
    public void userChecksRegisterButtonVisibility() {
        homePage.isRegisterButtonVisible();

    }

    @And("User checks sign in button visibility")
    public void userChecksSignInButtonVisibility() {
        homePage.isSignInVisible();
    }

    @And("User select category button visibility")
    public void userSelectCategoryButtonVisibility() {
        homePage.isCategoryButtonVisible();
    }


    @And("User set minimum price {string}")
    public void userSetMinimumPriceLowPrice(final String minPrice) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.setMinimumPriceLimit(minPrice);
    }

    @And("User set high limit price {string}")
    public void userSetHighLimitPriceMaxPrice(final String maxPrice) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.setMaxPriceLimit(maxPrice);
    }


    @And("User checks product {string}")
    public void userChecksProductProductAmount(final String productAmount) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getPriceRangeButton());
        int ans = searchResultsPage.getProductListLength();
        assertEquals(Integer.toString(ans), productAmount);
    }

    @And("User submit price range")
    public void userSubmitPriceRange() {
        searchResultsPage.clickSubmitPriceRangeButton();
    }

    @And("User click Shop category button")
    public void userClickShopCategoryButton() {
        homePage.clickCategoryButton();
    }


    @And("User click Ice Skating button")
    public void userClickIceSkatingButton() {
        shopCategoryPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shopCategoryPage.getIceSkatingCategoryButton());
        shopCategoryPage.clickIceSkatingCategoryButton();
    }

    @And("User click Sporting Goods Category button")
    public void userClickSportingGoodsCategoryButton() {
        homePage.clickSportingGoodsCategoryButton();
    }

    @And("User click Winter Sport Category button")
    public void userClickWinterSportCategoryButton() {
        shopCategoryPage = pageFactoryManager.getShopCategoryPage();
        shopCategoryPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shopCategoryPage.getWinterSportCategoryButton());
        shopCategoryPage.clickSportingGoodsCategoryButton();

    }

    @And("User check selected product contains {string}")
    public void userCheckSelectedProductContainsCategoryName(final String name) {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        String productTitle = productPage.getTitleText();
        assertTrue(productTitle.contains(name));
    }

    @And("User click Sign In Button")
    public void userClickSignInButton() throws InterruptedException {
        sleep(2000);//to escape CAPTCHA
        homePage.clickSignInButton();
    }


    @And("User input {string} into User Name filed")
    public void userInputUserNameIntoUserNameFiled(final String userName) {

        signInPage = pageFactoryManager.getSignInPage();


        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getUserNameItem());
        signInPage.enterUserNameItem(userName);
    }

    @And("User click Continue button")
    public void userClickContinueButton() throws InterruptedException {
        sleep(4100);//to escape CAPTCHA
        signInPage.clickContinueButton();
    }

    @And("User input {string} into Password filed")
    public void userInputPasswordIntoPasswordFiled(final String password) {
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getPasswordItem());
        signInPage.enterPasswordItem(password);

    }

    @And("User click Sign In")
    public void userClickSignIn() throws InterruptedException {
        sleep(3400);//to escape CAPTCHA
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.clickSingInButton();
    }

    @And("User click maybe later button")
    public void userClickMaybeLaterButton() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.clickMaybeLaterButton();
    }

    @And("User click Advanced Search button")
    public void userClickAdvancedSearchButton() {
        homePage.clickAdvancedSearchButton();
    }

    @When("User enter {string} for advanced search")
    public void userEnterKeywordForAdvancedSearch(final String keyword) {
        advancedSearchPage = pageFactoryManager.getAdvancedSearchPage();
        advancedSearchPage.enterKeywordToSearchField(keyword);
    }


    @And("User select Travel category")
    public void userSelectTravelCategory() {
        advancedSearchPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, advancedSearchPage.getCategorySelectorItem());
        advancedSearchPage.clickCategorySelectorItem();
    }


    @When("User enter extends {string} in search")
    public void userEnterExtendsExtendsKeywordInSearch(final String extendsKeyword) {
        advancedSearchPage.enterExtendsSearchField(extendsKeyword);
    }

    @And("User click search button")
    public void userClickSearchButton() {
        advancedSearchPage.clickTopSearchButton();
        advancedSearchPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, advancedSearchPage.getArtCategory());

        advancedSearchPage.clickArtCategory();
    }

    @And("User clicks Cart button")
    public void userClicksCartButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickCartIconCount();
    }

    @And("User remove first product from basket")
    public void userRemoveFirstProductFromBasket() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.clickRemoveFirsProduct();
    }

    @When("User set quantity of selected product {string}")
    public void userSetQuantityOfSelectedProductQuantityProduct(final String quantity) {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getQuantityProductItem());
        shoppingCartPage.setQuantityProductItem(quantity);

    }

    @And("User click Like button for first product")
    public void userClickLikeButtonForFirstProduct() {
        shopCategoryPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shopCategoryPage.getLkePlacidButtonButton());
        shopCategoryPage.clickLkePlacidButtonButton();
    }

    @And("User check firs product selected as Like")
    public void userCheckFirsProductSelectedAsLike() {
        shopCategoryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(shopCategoryPage.isWatchingForItem());
    }

    @And("User click Lake Placid button")
    public void userClickLakePlacidButton() {
        shopCategoryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shopCategoryPage.clickLakePlacidButton();
    }

    @And("User clicks eBay Sites")
    public void userClicksEBaySites() {
        homePage.clickEBaySites();
    }

    @And("User clicks Polish Sites")
    public void userClicksPolishSites() {
        homePage.clickPolishSites();
    }


    @And("User verify URL contains {string}")
    public void userVerifyURLContainsSites(final String sites) {
        assertTrue(homePage.isURSContains(sites));

    }

    @And("User set invalid amount")
    public void userSetInvalidAmount() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        productPage.setProductQuantityItem("2");
    }


    @And("User select highest First Button")
    public void userSelectHighestFirstButton() {
        searchResultsPage.clickHighestFirstButton();
    }

    @And("User select filter sort by")
    public void userSelectFilterSortBy() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getFilerButton());
        searchResultsPage.clickFilterButton();
    }

    @And("User check product selected by first high price")
    public void userCheckProductSelectedByFirstHighPrice() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.isPriseSorted());
    }
}
