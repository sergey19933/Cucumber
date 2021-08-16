package org.serg.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.*;
import org.serg.framework.managers.PageManager;

public class MortgageForSecondaryHousingSteps {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Проверяем что открылась страница 'Ипотека'$")
    public void checkMortgageForSecondaryHousingPage() {
        pageManager.getMortgageForSecondaryHousingPage().checkMortgageForSecondaryHousingPage();
        //Скролл до калькулятор
        pageManager.getMortgageForSecondaryHousingPage().scrollBeforeCalculatorPage();
        //Переключаемся на frame
        pageManager.getMortgageForSecondaryHousingPage().framePage();
    }

//
//    @И("Скролл до калькулятор")
//    public void scrollBeforeCalculatorPage() {
//        pageManager.getMortgageForSecondaryHousingPage().scrollBeforeCalculatorPage();
//    }

//    @И("^Переключаемся на frame$")
//    public void framePage() {
//        pageManager.getMortgageForSecondaryHousingPage().framePage();
//    }

    @И("^Заполняем поля формы:$")
    public void fillFieldPage(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getMortgageForSecondaryHousingPage().fillFieldPage((String) key, (String) value));
        pageManager.getMortgageForSecondaryHousingPage().scrollBeforeLifePage();
    }

//    @И("^Скролл до страхования жизни$")
//    public void scrollBeforeLifePage() {
//        pageManager.getMortgageForSecondaryHousingPage().scrollBeforeLifePage();
//    }

    @И("^\"(Отключить|Включить)\" чек бокс \"(.+)\"$")
    public void clickCheckboxPage(String nameBox, String offOn) {
        pageManager.getMortgageForSecondaryHousingPage().clickCheckboxPage(offOn, nameBox);
        //отключаем фрейм
        pageManager.getMortgageForSecondaryHousingPage().frameDisablePage();
        //Скролл до результата
        pageManager.getMortgageForSecondaryHousingPage().scrollBeforeResultPage();
        //Включить фрейм
        pageManager.getMortgageForSecondaryHousingPage().frameReturnPage();
    }

//    @И("^Отключаем фрейм$")
//    public void frameDisablePage() {
//        pageManager.getMortgageForSecondaryHousingPage().frameDisablePage();
//    }

//    @И("^Скролл до результата$")
//    public void scrollBeforeResultPage() {
//        pageManager.getMortgageForSecondaryHousingPage().scrollBeforeResultPage();
//    }

//    @И("^Включить фрейм$")
//    public void frameReturnPage() {
//        pageManager.getMortgageForSecondaryHousingPage().frameReturnPage();
//    }

    @И("^Проверка поля \"(.+)\" со значением \"(.+)\"$")
    public void checkFieldPage(String nameField, String value) {
        pageManager.getMortgageForSecondaryHousingPage().checkFieldPage(nameField, value);
    }


//    @И("^Проверка поля суммы кредита со значением \"(.+)\"$")
//    public void checkFieldCreditSumPage(String value) {
//        pageManager.getMortgageForSecondaryHousingPage().checkFieldCreditSumPage(value);
//    }
//
//    @И("^Проверка поля суммы необходимый доход со значением \"(.+)\"$")
//    public void checkFieldRequiredIncomePage(String value) {
//        pageManager.getMortgageForSecondaryHousingPage().checkFieldRequiredIncomePage(value);
//    }
//
//    @И("^Проверка что присутствует ошибка со значением \"(.+)\" 'Проверка ошибки процентной ставки было не пройдено'$")
//    public void checkErrorMessageAlert(String errorMessage) {
//        pageManager.getMortgageForSecondaryHousingPage().checkErrorMessageAlert(errorMessage);
//    }


}
