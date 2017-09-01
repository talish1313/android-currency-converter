# Тестовое задание Currency-converter (android)

---

На экране пользователю доступы следующие поля:
- Ввод суммы в исходной валюте;
- Выбор исходной валюты (например: Доллар США);
- Выбор конечной валюты.

По нажатию на кнопку выводится сумма в конечной валюте.
Курсы валют брать отсюда: http://www.cbr.ru/scripts/XML_daily.asp

При каждом входе в приложении следует пытаться загрузить по сети курсы валют и (в случае их доступности) сохранять их локально (кэшировать следует безусловно, не нужно проверять, отличаются ли загруженные курсы от закэшированных). В случае, если загрузить не удалось / не успели, следует использовать закэшированные курсы.

Обязательные требования:
- Код пишется только на Java. Kotlin/Scala/Brainfuck и т.п. использовать нельзя.
- Из библиотек использовать можно только библиотеки Android Support и SimpleXML.
- Проект располагается в доступном открытом Git репозитории

Будет плюсом:
- В проекте имеется выверенная архитектура с четким разделением обязанностей по слоям. Какой мета-­паттерн (MVC, MVP, MVVM) и какие паттерны проектирования использовать, – всё это остается на усмотрение автора.
- Модель защищена юнит-­тестами на уровне method coverage (branch coverage – это плюс, но необязательный).
- Приложение оформлено в Material Design.
