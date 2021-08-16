package org.serg.framework.utils;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.serg.framework.base.BasePage;
import org.serg.framework.managers.DriverManager;

import static org.serg.framework.managers.DriverManager.getDriver;

public class MethodsUtils extends BasePage {

    /**
     *
     * @param nameBox название чекбокса
     */
    public void choiceChekBox(String nameBox,String offOn) {
        String xPath = "//span[text()='" + nameBox + "']//../..//input[@class='switch-input-3-1-2']";
        DriverManager.getDriverManager();
        WebElement webElement = getDriver().findElement(By.xpath(xPath));
        if(webElement.getAttribute("ariaChecked").equalsIgnoreCase("true")
                || offOn.equalsIgnoreCase("Выключить")){
            webElement.click();
        }
    }


    /**
     *
     * @param nameField название поля
     * @param value значение для проверки
     */
    public void checkField(String nameField, String value) {
        String xPath = "//span[contains(text(),'" + nameField + "')]//..//span[contains(@data-e2e-id,'mland-calculator')]";
        WebElement webElement = getDriver().findElement(By.xpath(xPath));

        actions.pause(1500).perform();
        Assertions.assertEquals(webElement.getAttribute("innerText")
                .replaceAll("[^0-9,]", ""), value, "Не совпадает");
    }


    /**
     * @param nameField название поля
     * @param value     заполняемое значение
     */
    public void fillInputField(String nameField, String value) {
        String xPath = "//div[@class='dc-input__label-4-9-1'][contains(text(),'" + nameField + "')]/following-sibling::*";
        WebElement webElement = getDriver().findElement(By.xpath(xPath));
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
