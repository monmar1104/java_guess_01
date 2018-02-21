**Zadanie z dockera (do 01.03.2018)**

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