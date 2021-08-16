package org.serg.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//span[@data-e2e-id='mland-calculator/medium-result-monthly-payment']")
    private WebElement checkFieldMonthlyPayment;

    @FindBy(xpath = "//span[@data-e2e-id='mland-calculator/mobile-result-credit-sum']")
    private WebElement checkFieldCreditSum;

    @FindBy(xpath = "//span[@data-e2e-id='mland-calculator/result-required-income']")
    private WebElement checkFieldRequiredIncome;

    @FindBy(xpath = "//span[@data-e2e-id='mland-calculator/medium-result-credit-rate']")
    private WebElement errorMessageS;

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
        fillInputField(nameField, value);
        return this;
    }


    //  @Step("Скролл до Страхования жи")
    public MortgageForSecondaryHousing scrollBeforeLifePage() {
        scrollToElementJs(scrollBeforeLife);
        waitUtilElementToBeVisible(scrollBeforeLife);
        return this;
    }


    //   @Step("Отключаем страхование жизни")
    public MortgageForSecondaryHousing clickCheckboxPage() {
        clickCheckbox.click();
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
    public MortgageForSecondaryHousing checkFieldMonthlyPaymentPage(String value) {
        actions.pause(1500).perform();
        Assertions.assertEquals(checkFieldMonthlyPayment.getAttribute("innerText")
                .replaceAll("\\D*", ""), value, "Не совпадает");
        return this;
    }

    //   @Step("Проверка поля суммы кредита")
    public MortgageForSecondaryHousing checkFieldCreditSumPage(String value) {
        actions.pause(1000).perform();
        Assertions.assertEquals(checkFieldCreditSum.getAttribute("innerText")
                .replaceAll("\\D*", ""), value, "Не совпадает");
        return this;
    }

    //  @Step("Проверка поля суммы необходимый доход")
    public MortgageForSecondaryHousing checkFieldRequiredIncomePage(String value) {
        Assertions.assertEquals(checkFieldRequiredIncome.getAttribute("innerText")
                .replaceAll("\\D*", ""), value, "Не совпадает");
        return this;
    }


    /**
     * Проверка ошибки ставки
     */
    // @Step("Проверяем что присутствует общая ошибка с текстом '{errMessage}'")
    public MortgageForSecondaryHousing checkErrorMessageAlert(String errorMessage) {
        Assertions.assertEquals(errorMessageS.getAttribute("innerText"), errorMessage, "Проверка ошибки процентной ставки " +
                " было не пройдено");
        return this;
    }


//------------------------------------


    /**
     * @param nameField название поля
     * @param value     заполняемое значение
     */
    public void fillInputField(String nameField, String value) {
        String xPath = "//div[@class='dc-input__label-4-9-1'][contains(text(),'" + nameField + "')]/following-sibling::*";
        WebElement webElement = DriverManager.getDriverManager().getDriver().findElement(By.xpath(xPath));
        waitUtilElementToBeVisible(webElement);
        waitUtilElementToBeClickable(webElement);
        actions.click(webElement)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(value)
                .pause(1000)
                .build()
                .perform();

        Assertions.assertEquals(webElement.getAttribute("defaultValue")
                .replaceAll("\\D*", ""), value, "Поле введено не верно");
    }


}
