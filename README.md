# vk_widget
 Вывод в виджет сообщества информации о активных серверах с автообновлением (50сек). Пока что, сервера берутся из json файла
 [java 8]
 
Файл GroupToken.properties можно отредактировать блокнотом.
- GroupId=ID группы
- GroupToken=Токен управления виджетом (Управление - работа с API)
- URL=http://185.241.192.136/api/servers (Тут все ясно)

Пока, при смене параметров(добавления новых/удаления/изменения названий старых) прога будет падать. 
Если надумаете что-нибудь менять, то сообщите. Попозже вставлю защиту с игнором новых параметров.

Запуск jar:
- java -jar /home/user/jar_name.jar - для Linux
- java -jar C:\Users\user\jar_name.jar - для Windows

Команды управления:
- e [Запуск по дефолту. Обновление раз в 50 секунд]
- q [Завершение работы программы]
- pause [Пауза]
- restart [Снятие с паузы]
- timer X [Выставить время обновления и запустить]
- safe X - Где X true or false. Сэйф мод, который не выводит сервера на которых меньше двух человек (помимо официальных)

Алгоритм -> Сервера берутся из get запроса, создаётся список объектов через objectMapper, проводится сортировка по игрокам и статусу сервера, формируется запрос для vk, используя заготовленный шаблон и данные из объектов -> данные отправляются и выводится ответ на консоль. Повторяем через n секунд.

 На данный момент нужно переписать формирование запроса на обновление виджета. Простите за это :'(

 ![Image alt](Screenshot_429.png)
