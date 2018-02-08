**Zadanie z dockera (do 14.01.2018)**

Żeby przećwiczyć używanie dockera w praktyce oraz ułatwić używanie go w praktce.
Składa się z kilku zadań, większosć zakładam że *bardzo szybka do przerobienia*. Powodzenia!

#### Zad 0. 
Przeczytaj 3 tutoriale na temat dockera:
- Częsć 1 (Czas czytania: 4min) - https://docs.docker.com/get-started/
- Częsć 2 (Czas czytania: 13min) - https://docs.docker.com/get-started/part2/ 
- Częsć 3 (Czas czytania: 8min) - https://docs.docker.com/get-started/part3/

-----

W katalogu `/09-docker/` są pliki:
- `config/`
- `docker-compose.yml`
- `Dockerfile`

Jest to konfiguracja kontenera mysql oraz wilfgly wraz z konfiguracją.

*Odpowiedzi wyslij na slacku.*

#### Zad 1. 
Przejrzyj / Przeanalizuj zawartosć plików.

#### Zad 2. 
Wymień miejsce w którym jest definiowane w `docker-composer.yml`:
- Nazwa bazy danych
- Nazwa datasource

#### Zad 3. 
Wymień miejsce w którym jest definiowane w `Dockerfile`:
- Nazwa WAR do deploymentu. W którym katalogu powinien być plik?

#### Zad 4. 
Wymień miejsca w którym jest konfigurowane w `config/execute.sh`:
- Dodanie datasoure
- Dodanie connectora MySQL
- Stworzenie użytkownika wildfly
- Deployment aplikacji

#### Zad 5. 
Uruchomienie własnej aplikacji
a) Zbuduj WARa ze swojej aplikacji
    **Takiej w której nie ma security domain - bo to nie jest skonfigurowane w naszych dockerach. Jeszcze.**
b) Skopiuj je w odpowiednie miejsce
c) Zmień nazwę `datasource` w miejscu z zad 2

#### Zad 6.
a) Uruchom dockera z przygotowanym obrazem. Przydatne komendy:
- `docker-compose up`
- `docker-compose down`
- W przypadku gdy cos pójdzie krytycznie źle. Można zrobić reset wszystkich obrazków dockerowych: `docker system prune -a` 

b) Uruchom w przeglądarce http://localhost:8081/ i http://localhost:9991/
- Widzisz swoją aplikację?
- W panelu admina, zaloguj się (to swieży wildfly - skąd wziąć dane?)

c) Zrób screena:
- Swojej aplikacji na podanym porcie
- Konfiguracji ekranu z *datasource*

#### Zad 7. 
- Zrób małą ale widoczną zmianę w aplikacji
- przebuduj ją i przekopiuj do katalogu z dockerem
- Uruchom obraz dockera jeszcze raz

Czy zmiana została zaaplikowana? 
Odpowiedź: Tak / Nie.
Dodatkowe: Uzasadnij.