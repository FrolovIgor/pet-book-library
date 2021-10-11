## Pet-spring-project

### Тестовый проект на Spring с использованием Kafka и PostgreSQL

#### Порядок запуска
- собрать образ с приложением запустив `build.sh` в корне проекта
- перейти в папку `example`
- запустить `docker-compose`


### API
#### BooksLibrary (localhost:28877)
**Path**           | **Method** | **Response**         | **Comment**
 ---               | ---       | ---                | ---
`/book`   | GET       | List<Book>  | Список всех книг в библиотеке
`/book`   | POST       | Book  | Добавляет книгу в хранилище
`/book/{id}`   | GET       | Book   | Возвращает книгу по id
`/book/{id}`   | DELETE       | void    | Удаляет книгу с заданным id
`/actuator/health`   | GET       | Health    | Информация о работоспособности

#### BooksLibrary (localhost:28877)
**Path**           | **Method** | **Response**         | **Comment**
 ---               | ---       | ---                | ---
`/download/{id}`   | GET       | void | Запускает загрузку книги
`/actuator/health`   | GET       | Health    | Информация о работоспособности

