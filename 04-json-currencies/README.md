## Parsowanie JSON oraz konwersja walut

1. Stwórz nowy moduł maven `04-json-currencies`.
1. Program powinien zawierać tekstowe menu do wyboru jednej z dwóch dostępnych funkcjonalności.
1. Pierwszą funkcjonalnością jest możliwość załadowania dowolnego pliku w formacie json, zawierającego notowania walut. 
   Przykładowy plik znajduje się w repozytorium pod nazwą [currencies.json](./currencies.json) 
   (tip: użyj gotowych rozwiązań do parsowania plików json, tj. [Google gson](https://github.com/google/gson)
   lub [Java8 JSON API](http://www.oracle.com/technetwork/articles/java/json-1973242.html)).
   Wyświetl wszystkie waluty i ich notowania.
1. Drugą funkcjonalnością jest możliwość przeliczenia wskazanej kwoty pomiędzy walutami, podając: kwotę wraz z walutą bazową oraz walutę docelową. Jako wynik otrzymujemy kwotę w walucie docelowej.

Punktacja: 10pkt

Po zakończonej pracy, dajcie mi znać na slacku.