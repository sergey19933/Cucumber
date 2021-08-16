package org.serg.framework.managers;

import org.serg.framework.utils.TestPropertis;

import java.util.concurrent.TimeUnit;



public class InitManager {

    /**
     * Менеджер properties
     *
     * @see TestPropertis#getTestPropertis()
     */
    private static final TestPropertis props = TestPropertis.getTestPropertis();

    /**
     * Менеджер WebDriver
     *
     * @see DriverManager#getDriverManager()
     */
    private static final DriverManager driverManager = DriverManager.getDriverManager();

    /**
     * Инициализация framework и запуск браузера со страницей приложения
     *
     * @see DriverManager
     * @see TestPropertis#getProperty(String)
     * @see io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm
     */
    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driverManager.getDriver().get("https://www.sberbank.ru/ru/person");
    }

    /**
     * Завершения работы framework - гасит драйвер и закрывает сессию с браузером
     *
     * @see DriverManager#quitDriver()
     */
    public static void quitFramework() {
        driverManager.quitDriver();
    }
}