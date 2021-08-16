//package org.serg.tests;
//
//import org.junit.jupiter.api.Test;
//import org.serg.tests.base.BaseTests;
//
//
//public class OrdinaryTest extends BaseTests {
//    /**
//     * Заходим на страницу "ипотека"
//     * Проверить что находимся именно на этой странице
//     */
//
//    @Test
//    public void testScenario() {
//
//        /**
//         * Подтверждения города
//         */
//
//        app.getHomePage().closeCookiesDialog()
//                .selectBaseMenu("Ипотека")
//                .selectSubMenu("Ипотека на вторичное жильё")
//                .checkMortgageForSecondaryHousingPage()
//                .scrollBeforeСalculatorPage().framePage()
//                .fillFieldPage("Стоимость недвижимости","5180000")
//                .fillFieldPage("Первоначальный взнос","3058000")
//                .fillFieldPage("Срок кредита","30")
//                .scrollBeforeLifePage()
//                .clickCheckboxPage()
//                .checkFieldCreditSumPage("2122000")
//                .checkFieldMonthlyPaymentPage("16618")
//                .checkFieldRequiredIncomePage("21393")
//                .checkErrorMessageAlert("11%");
//
//    }
//}
