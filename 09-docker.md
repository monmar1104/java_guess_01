**Zadanie z dockera (do 15.02.2018)**

Żeby przećwiczyć używanie dockera w praktyce oraz ułatwić używanie go w praktce.
Składa się z kilku zadań, większosć zakładam że *bardzo szybka do przerobienia*. Powodzenia!

#### Krok 0. 
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

#### Krok 1. 
Przejrzyj / Przeanalizuj zawartosć plików.

#### Krok 2. 
Wymień miejsce w którym jest definiowane w `docker-composer.yml`:
- Nazwa bazy danych: services/jjdz4-db:/environment: - MYSQL_DATABASE=jjdz4-db
- Nazwa datasource: services/jjdz4-web-app:/environment: - DATASOURCE_NAME=java:/SimpleDS

#### Krok 3. 
Wymień miejsce w którym jest definiowane w `Dockerfile`:
- Nazwa WAR do deploymentu: COPY web-app.war 
W którym katalogu powinien być plik?: podajemy ścieżkę pliku w kontekście polecenia build

#### Krok 4. 
Wymień miejsca w którym jest konfigurowany Wildfly w `config/execute.sh`:
- Dodanie datasoure: data-source add --name=mysqlDS --driver-name=mysql --jndi-name=$DATASOURCE_NAME
- Dodanie connectora MySQL: module add --name=com.mysql --resources=/opt/jboss/wildfly/config/mysql-connector-java-6.0.6.jar
- Stworzenie użytkownika wildfly: /opt/jboss/wildfly/bin/add-user.sh admin abcd1234 --silent
- Deployment aplikacji: cp /opt/jboss/wildfly/config/*.war $JBOSS_HOME/$JBOSS_MODE/deployments/

#### Krok 5. 
Uruchomienie własnej aplikacji

a) Zbuduj WARa ze swojej aplikacji
    **Takiej w której nie ma security domain - bo to nie jest skonfigurowane w naszych dockerach. Jeszcze.**

b) Skopiuj je w odpowiednie miejsce

c) Zmień nazwę `datasource` w miejscu z zad 2

#### Krok 6.

a) Plik `config/execute.sh` musi byc wykonywalny. Zrob go przez polecenie `chmod +x config/execute.sh` Jako potwierdzenie, sprawdz jego status w `ls -la`.

b) Uruchom dockera z przygotowanym obrazem. Przydatne komendy:
- `docker-compose up`
- `docker-compose down`
- W przypadku gdy cos pójdzie krytycznie źle. Można zrobić reset obrazu dockerowego: `docker-compose build` 

Zakończyło się sukcesem czy jest błąd?

c) Uruchom w przeglądarce http://localhost:8081/ i http://localhost:9991/
- Widzisz swoją aplikację?
- W panelu admina, zaloguj się (to swieży wildfly - skąd wziąć dane?)

d) Zrób screena:
- Swojej aplikacji na podanym porcie
- Konfiguracji ekranu z *datasource*

#### Krok 7. 
- Zrób małą ale widoczną zmianę w aplikacji
- przebuduj ją i przekopiuj do katalogu z dockerem
- Uruchom obraz dockera jeszcze raz

Czy zmiana została zaaplikowana? 
Odpowiedź: Tak / Nie.
Dodatkowe: Uzasadnij.
