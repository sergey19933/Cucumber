#language: ru

@all
Функционал: Сбербанк

  @smoke
  @firstTest
  Сценарий:  Проверка
    * Закрытия сообщения cookies
    * Выбираем "Ипотека" в главном меню
    * Выбираем "Ипотека на вторичное жильё" в подменю главного меню
    * Проверяем что открылась страница 'Ипотека'
    * Заполняем поля формы:
      | Стоимость недвижимости | 5180000 |
      | Первоначальный взнос   | 3058000 |
      | Срок кредита           | 30      |
    * "Отключить" чек бокс "Страхование жизни и здоровья"
    * Проверка поля "Ежемесячный платеж" со значением "16618"
    * Проверка поля "Сумма кредита" со значением "2122000"
    * Проверка поля "Необходимый доход" со значением "21393"
    * Проверка поля "Процентная ставка" со значением "11"


