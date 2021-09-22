package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdvancedSearchPage extends BasePage{
    @FindBy(xpath = "//input[@aria-labelledby='kw_lengend']")
    private WebElement advancedSearchField;

    @FindBy(xpath = " //input[@id='_ex_kw']")
    private WebElement extendsSearchField;


    @FindBy(xpath = "//div[contains(@class,'space-top')]//button[@class='btn btn-prim']")
    private WebElement topSearchButton;


    @FindBy(xpath = "//select[@id='e1-1' and @name= '_sacat']")
    private WebElement categorySelectorItem;


    @FindBy(xpath = "//option[@value='550']")
    private WebElement categoryArt;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickTopSearchButton() {
        topSearchButton.click();
    }

    public void clickArtCategory() {
        categoryArt.click();
    }

    public void clickCategorySelectorItem() {

        Select se = new Select(categorySelectorItem);

        se.selectByValue("550");

    }


    public void enterKeywordToSearchField(String keyword) {
        advancedSearchField.clear();
        advancedSearchField.sendKeys(keyword);
    }


    public WebElement getCategorySelectorItem() {
        return categorySelectorItem;
    }

    public WebElement getArtCategory() {
        return categoryArt;
    }

    public void enterExtendsSearchField(String extendsKeyword) {
        extendsSearchField.clear();
        extendsSearchField.sendKeys(extendsKeyword);
    }

}

