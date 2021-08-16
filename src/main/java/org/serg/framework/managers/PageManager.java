package org.serg.framework.managers;

import org.serg.framework.pages.*;
import org.serg.framework.utils.MethodsUtils;

public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private HomePage homePage;

    /**
     * Страничка с ипотекой на готовые квартиры
     */
    private MortgageForSecondaryHousing mortgageForSecondaryHousing;


    /**
     * Страничка с утилитарными методами
     */
    private MethodsUtils methodsUtils;



    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link HomePage}
     *
     * @return homePage
     */
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    /**
     * Ленивая инициализация {@link MortgageForSecondaryHousing}
     *
     * @return laptopPage
     */
    public MortgageForSecondaryHousing getMortgageForSecondaryHousingPage() {
        if (mortgageForSecondaryHousing == null) {
            mortgageForSecondaryHousing = new MortgageForSecondaryHousing();
        }
        return mortgageForSecondaryHousing;
    }

    /**
     * Ленивая инициализация {@link MethodsUtils}
     *
     * @return methodsUtils
     */
    public MethodsUtils getMethodsUtilsPage() {
        if (methodsUtils == null) {
            methodsUtils = new MethodsUtils();
        }
        return methodsUtils;
    }

    /**
     * Сброс менеджера страничек
     */
    public static void disableManagerPages() {
        pageManager = null;
    }

}


