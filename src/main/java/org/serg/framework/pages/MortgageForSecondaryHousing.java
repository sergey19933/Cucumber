package org.serg.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.serg.framework.base.BasePage;
import org.serg.framework.managers.DriverManager;

import java.util.concurrent.TimeUnit;

public class MortgageForSecondaryHousing extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement title;


    @FindBy(xpath = "//h2[contains(text(),'Рассчитайте ипотеку')]")
    private WebElement scrollBeforeCalculator;

    @FindBy(id = "iFrameResizer0")
    private WebElement frameSwitch;

    @FindBy(xpath = "//div[contains(text(),'Услуги, снижающие ставку по кредиту')]")
    private WebElement scrollBeforeLife;

    @FindBy(xpath = "//span[text()='Страхование жизни и здоровья']//../..//input[@class='switch-input-3-1-2']")
    private WebElement clickCheckbox;

    @FindBy(id = "iFrameResizer0")
    private WebElement scrollBeforeResult;

    @FindBy(xpath = "//h2[contains(text(),'Рассчитайте ипотеку')]")
    private WebElement scrollResult;


    //  @Step("Проверяем что открылась страница 'Ипотека'")
    public MortgageForSecondaryHousing checkMortgageForSecondaryHousingPage() {
        Assertions.assertEquals("Ипотека от 7,7%* на готовые квартиры", title.getAttribute("innerText"));
        return this;
    }


    // @Step("Скролл до калькулятор")
    public MortgageForSecondaryHousing scrollBeforeCalculatorPage() {
        scrollToElementJs(scrollBeforeCalculator);
        waitUtilElementToBeVisible(scrollBeforeCalculator);
        return this;
    }


    public MortgageForSecondaryHousing framePage() {
        DriverManager.getDriverManager().getDriver().manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        DriverManager.getDriverManager().getDriver().switchTo().frame("iFrameResizer0");
        // driver.switchTo().defaultContent();
        return this;
    }


    /**
     * Метод заполнения полей
     *
     * @param nameField - имя веб элемента, поля ввода
     * @param value     - значение вводимое в поле
     */
    // @Step("Заполняем поле '{nameField}' значением '{value}'")
    public MortgageForSecondaryHousing fillFieldPage(String nameField, String value) {
        pageManager.getMethodsUtilsPage().fillInputField(nameField, value);
        return this;
    }


    //  @Step("Скролл до Страхования жи")
    public MortgageForSecondaryHousing scrollBeforeLifePage() {
        scrollToElementJs(scrollBeforeLife);
        waitUtilElementToBeVisible(scrollBeforeLife);
        return this;
    }


    //   @Step("Отключаем страхование жизни")
    public MortgageForSecondaryHousing clickCheckboxPage(String nameBox,String offOn) {
        pageManager.getMethodsUtilsPage().choiceChekBox(nameBox,offOn);
        return this;
    }


    public MortgageForSecondaryHousing frameDisablePage() {
//        DriverManager.getDriverManager().getDriver().manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
//        DriverManager.getDriverManager().getDriver().switchTo().frame("iFrameResizer0");
        DriverManager.getDriverManager().getDriver().switchTo().defaultContent();
        return this;
    }


    //  @Step("Скролл до результат вычислений")
    public MortgageForSecondaryHousing scrollBeforeResultPage() {
        scrollToElementJs(scrollResult);
        return this;
    }


    public MortgageForSecondaryHousing frameReturnPage() {
        DriverManager.getDriverManager().getDriver().manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        DriverManager.getDriverManager().getDriver().switchTo().frame("iFrameResizer0");
        //   DriverManager.getDriverManager().getDriver().switchTo().defaultContent();
        return this;
    }


    // @Step("Проверка поля ежем плат")
    public MortgageForSecondaryHousing checkFieldPage(String nameField,String value) {
        pageManager.getMethodsUtilsPage().checkField(nameField,value);
        return this;
    }




}
