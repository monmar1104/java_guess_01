**Zadanie z budowanie klienta API (do 01.03.2018)**

Bazując na zadaniach z [warsztatu API](https://github.com/infoshareacademy/jjdz4-materialy-api-rest-soap/) (projekt google-client),
napisz klienta dla serwisu [restcountries.eu](https://restcountries.eu/)

Otwórz projekt **10-api-client** jako nowy moduł oraz uzupełnij klasy oraz testy tak, by przechodziły.

Testy do uruchomienia:
- `RestCountriesClientTest`
  - shouldHandleFailure
  - shouldGenerateUrl
- `RestCountriesHomeworkTest`
  - shouldFindSingleCountry
  - shouldFindPolandForPlnCurrency
  - shouldFindCountriesByUsdCurrency
  - findStateNeighbours
  - findCommonStateNeighbours

Klasy do (dowolnej) modyfikacji w paczce `com.infoshareacademy.restcountries`.

Podpowiedzi:
- Sprawdźcie dokładnie response zwracany przez restcountries,
np. Zwraca listę czy pojedynczy obiekt
- [Jak zmapować listę obiektów z odpowiedzi](https://codereview.stackexchange.com/questions/60782/resteasy-client-that-should-use-generics)
- Odpowiedź ma mnóstwo pól do zaimplementowania, zajrzyjcie do dokumentacji: 
    - [jak zrobić żeby odpowiedź zwracała tylko te pola które potrzebujemy?](https://restcountries.eu/#filter-response)
    - Zaimplementujcie w pierwszej kolejności metody z `RestCountriesClientTest`