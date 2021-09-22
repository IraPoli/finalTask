package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopCategoryPage extends BasePage {


    @FindBy(xpath = "//div[@class='b-visualnav__title' and text()='Winter Sports']")
    private WebElement winterSportCategoryButton;

    @FindBy(xpath = "//a[contains(@class,'b-guidancecard') and contains(@href,'Ice-Skating')]")
    private WebElement iceSkatingCategoryButton;


    @FindBy(xpath = "//button[contains(@class,'watchheart')]")
    private List<WebElement> watchHeartsButton;

    @FindBy(xpath = "//li[contains(@class,'snap-point')]/a[contains(@href,'Lake-Placid')]")
    private WebElement lakePlacidButton;

    public ShopCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickSportingGoodsCategoryButton() {
        winterSportCategoryButton.click();
    }

    public void clickIceSkatingCategoryButton() {
        iceSkatingCategoryButton.click();
    }

    public void clickLakePlacidButton() {
        lakePlacidButton.click();
    }

    public void clickLkePlacidButtonButton() {
        watchHeartsButton.get(0).click();
    }

    public WebElement getWinterSportCategoryButton() {
        return winterSportCategoryButton;
    }

    public WebElement getIceSkatingCategoryButton() {
        return iceSkatingCategoryButton;
    }

    public WebElement getLkePlacidButtonButton() {
        return watchHeartsButton.get(0);
    }

    public boolean isWatchingForItem() {
        String ariaLabel = watchHeartsButton.get(0).getAttribute("aria-label");
        return (ariaLabel.contains("watching"));
    }
}
