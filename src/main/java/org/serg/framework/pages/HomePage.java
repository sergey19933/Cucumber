package org.serg.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.serg.framework.base.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@class='kitt-cookie-warning__close']")
    private WebElement cookiesBtnClose;

    @FindBy(xpath = "//li[contains(@class,'kitt-top-menu__item_first')]/a[@role or @aria-expanded]")
    private List<WebElement> listMainMenu;

    @FindBy(xpath = "//a[@data-cga_click_top_menu]")
    private List<WebElement> listSubMenu;


    public HomePage closeCookiesDialog() {
        waitUtilElementToBeClickable(cookiesBtnClose).click();
        return this;
    }


    public HomePage selectBaseMenu(String nameMainMenu) {
        for (WebElement menuChoice : listMainMenu) {
            if (menuChoice.getText().trim().equalsIgnoreCase(nameMainMenu)) {
                waitUtilElementToBeClickable(menuChoice).click();
                return this;
            }
        }
        Assertions.fail("Меню '" + nameMainMenu + "' не найдено");
        return this;
    }


    public MortgageForSecondaryHousing selectSubMenu(String nameSubMenu) {
        for (WebElement menuChoice : listSubMenu) {
            if (menuChoice.getText().equalsIgnoreCase(nameSubMenu)) {
                waitUtilElementToBeClickable(menuChoice).click();
                return pageManager.getMortgageForSecondaryHousingPage();
            }
        }
        Assertions.fail("Подменю '" + nameSubMenu + "' не найдено");
        return pageManager.getMortgageForSecondaryHousingPage();
    }


}
