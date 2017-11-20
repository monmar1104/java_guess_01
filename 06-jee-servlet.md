

## Java EE

Zadanie 1.

W ramach aplikacji tworzonej na zajęciach:
- Dokonaj refaktoryzacji kodu. Jedyne pakiety jakie powinny istnieć w aplikacji to:
  - `com.infoshareacademy.searchengine.domain`
  - `com.infoshareacademy.searchengine.dao`
  - `com.infoshareacademy.searchengine.servlets`
  - `com.infoshareacademy.searchengine.repository`
            
- W pakiecie `com.infoshareacademy.searchengine.servlets` utwórz servlet `AddUserServlet` oraz zaimplementuj dodawanie użytkowników do repozytorium.

- Koniecznie wykorzystaj EJB do zarządzania użytkownikami, stworzone na zajęciach.

- Dodanie użytkownika powinno zostać zrealizowane po przesłaniu kompletu parametrów w urlu, z wykorzystaniem komunikacji GET. 
`http://127.0.0.1:8080/AddUserServlet?id=1&name=Jan&surname=Kowalski&age=23&login=jako`

- Nie pozwól na nadpisanie użytkownika z tym samym ID. Jeśli użytkownik o zadanym ID istnieje, należy zwrócić błąd w postaci kodu HTTP 409 Conflict.
- Jesli dane w requeście są niekompletnie, zwróć błąd w postaci kodu HTTP 400 Bad Request.