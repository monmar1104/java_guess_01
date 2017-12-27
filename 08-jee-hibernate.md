**Zadanie 1.** do 30.12.2017 (3pkt)

- Dodawanie użytkownika w 3 krokach. 
- Zgodnie z [zadaniem z prezentacji](https://github.com/infoshareacademy/jjdz4-materialy/blob/master/slides/2017-12-02_JEE-Advanced.pdf) 
    - Dokończyć to co zaczęliśmy na zajęciach - Zadanie 13
    
**Zadanie 2.** do 06.01.2018 (7pkt)

- Skonfigurować Security Domain. 
- Stworzyć możliwość logowania oraz wylogowywania. 
- Zapewnić kawałek kodu prezentującego aktualny stan zalogowania. 
- Wszystkie zadania w dziale nr 10. Rozwijamy security.
    - Skorzystaj z [filmików nagranych przez Rafała Misiaka](https://drive.google.com/drive/folders/1SRDSy2p-7EDWL5OGfUF2iugbRbO5DhqS) (dostęp do 14.01.2018).
    
**Zadanie 3.** (dla chętnych) (3pkt)

Zrealizować edycję danych użytkownika - również w trzech krokach. Może powstać do tego celu nowy servlet ale nie pliki jsp - proszę wykorzystać pliki jsp które zawierają formularz dodawania.

Wskazówki:
- Edycja użytkownika może mieć url `/edit-user?id=10` <- w momencie kiedy podajecie ID użytkownika, jesteście w stanie na tej podstawie znaleźć jego dane i w servlecie przekazać je do widoków JSP
- Formularze w HTML, a dokładnie pola formularzy mają atrybut `value`, który ustawiony podmienia pustą wartość pola tekstowego na tekst przekazany właśnie tym atrybutem

**Zadanie 4.** do 13.01.2018 (5pkt)

- Przejrzeć [wykład z Hibernate](https://github.com/infoshareacademy/jjdz4-materialy/blob/master/slides/2017-12-17_hibernate.pdf) do końca
- Dokończyć ćwiczenie 2.2 (Strona 97 z wykładu)
    - Migracja StatisticsRepository and UsersRepository do Hibernate
- Przerobić ćwiczenie 2.3 (Strona 105) 
    - Custom validators
- (dla chętnych) Dodanie encji Satistic i połączenie jej ze StatisticRepository
    - Wskazówka: bedzie miala relacje @OneToOne z Userem    
