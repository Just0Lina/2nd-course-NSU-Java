## Веб-сервер на спринге

---

`Для каких нужд этот сервер создается пока останется тайной, но я очень постараюсь`
### Используемые зависимости:
#### Базы данных:
	База данных postgres связана с ООП при помощи фреймворка Hibirnate 
#### Безопасность авторизации:
	 Фреймворк Spring Security предоставляет механизм аунтификации и авторизации
### На данный момент
	Появилась нужда изменить классы шаблонов на freemarker, пришлось пушить...
    Шаблоны добавила, теперь еще можно пользователю с ролью Админа 
    посмотреть на список всех пользователей и поменять им роли
    Хотя ролей только две)) 
    Еще при подписке на тег можно загрузить картиночку, но это чисто чтобы я с этой технологией разобралась)
    Добавила навигационную панель вверху страницы, скринов не будет (пока не доделаю)
    Добавила рассылку писем на email (Я убила на это пару дней и испробовала целых 3 почтовых сервера!
    И, к счастью, я не запушила свои данные в application.props 
    Теперь еще админ может удалять учетки (А то с этими почтами я их знатно наплодила)
    Еще добавила миграции для таблиц
    И профиль можно теперь редактировать и заново подтверждать почту!
    Сейчас делается шифрование паролей, шифровать то шифрует, а вот кто обратно их распаковывать будет непонятно...
    Скринов не будет, дизайн упал, когда разберусь со static поговорим


