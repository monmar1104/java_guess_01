## Gra w zgadywanie

Sposób na przećwiczenie waszych umiejętności z pętli oraz komunikacji z użytkownikiem za pomocą konsoli.

Zasady gry:

- Użytkownik podaje przedział w którym liczba zostanie wylosowana
- Program losuje liczbę nie wyświetlając jej użytkownikowi
- Użytkownik za pomocą kilku prób, próuje zgadnąć co wylosował komputer

Kryteria akceptacji:

- Użytkownik definiuje maksymalny przedział
- Ustalona maksymalna ilość prób (lub podana przez użytkownika)
- Obsługa porażki i zwycięstwa (stosownym komunikatem)

Przykład działania: Poprawne odgadnięcie

```
Wylosuj liczbę z przedziału od 1 do ?
> 5
Wylosowano liczbę. Zgadnij która. Masz 3 próby.

Podejście #1
> 3
Podejście #2
> 2
Super, udało Ci się!
```

Przykład działania: Limit prób wyczerpany
```
Wylosuj liczbę z przedziału od 1 do ?
> 250
Wylosowano liczbę. Zgadnij która. Masz 3 próby.
Podejście #1
> 2
Podejście #2
> 3
Podejście #3
> 1
Niestety. Poprawna liczba to była: 170

```

## Jak oddać pracę domową?

- Sklonuj to repozytorium
- Stwórz swojego brancha w formacie imie.nazwisko
- Stwórz nowy projekt o nazwie `01-java-guess`
- Gdy zrobisz, zacommitujesz - daj mi znać na slacku.