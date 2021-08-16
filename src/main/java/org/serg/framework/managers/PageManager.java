package org.serg.framework.managers;

import org.serg.framework.pages.*;

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


}


