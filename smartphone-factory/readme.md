# Smartphone Factory
Этот проект представляет собой приложение для управления заказами на смартфоны с использованием паттернов проектирования, таких как Builder и Observer. Пользователь может создать заказ, выбрать тип смартфона, а затем система обрабатывает заказ с помощью нескольких потоков.

## Описание
Программа позволяет пользователям:
- Создавать заказы на смартфоны разных ценовых категорий (бюджетные, средние и дорогие).
- Обрабатывать заказы с использованием многозадачности через `ExecutorService`.
- Отслеживать статус заказов через механизм наблюдателей (`Observer`).
- Логировать выполнение заказов в файл.

### Основные классы

- **Application**: Главный класс программы, запускающий процесс создания заказов и обрабатывающий пользовательский ввод.
- **Order**: Класс, представляющий заказ на смартфоны. Содержит информацию о модели, количестве и статусе заказа.
- **SmartphoneFactory**: Фабрика смартфонов, которая обрабатывает заказы, используя многозадачность.
- **Smartphone**: Абстрактный класс для всех моделей смартфонов.
- **SmartphoneDirector**: Класс, использующий паттерн Builder для создания смартфонов.
- **FileSearching**: Класс для поиска файлов и загрузки классов смартфонов по ценовым категориям.
- **OrderHistoryWriter**: Класс для записи истории выполненных заказов в файл.
- **Annotations**: Аннотации для обозначения различных типов смартфонов (BudgetSmartphone, FlagshipSmartphone, MidTierSmartphone).

### Паттерны проектирования

- **Builder**: Используется для создания объектов смартфонов с различными характеристиками.
- **Observer**: Применяется для уведомления наблюдателей (например, для логирования выполнения заказов).

### Аннотации

В проекте используются аннотации для указания ценовых категорий смартфонов:

- `@BudgetSmartphone`: Для бюджетных смартфонов.
- `@MidTierSmartphone`: Для средних смартфонов.
- `@FlagshipSmartphone`: Для флагманских смартфонов.