### Процедура запуска авто-тестов
1. Запустить в терминале контейнеры с СУБД и симулятором командой docker-compose up
2. Запустить в терминале jar файл с приложением командой:
* Для mysql: java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
* Для postgresql: java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar

4. Запустить авто-тесты
