## Übung 1

### Abstrakte Testfälle

| ID | Bedingung (Beschreibung)                           | Erwartetes Ergebnis     |
|----|----------------------------------------------------|-------------------------|
| 1  | Kaufpreis < 15'000 CHF                             | Kein Rabatt             |
| 2  | 15'000 CHF ≤ Kaufpreis < 20'000 CHF                | 5% Rabatt               |
| 3  | 20'000 CHF ≤ Kaufpreis < 25'000 CHF                | 7% Rabatt               |
| 4  | Kaufpreis ≥ 25'000 CHF                             | 8,5% Rabatt             |



### Konkrete Testfälle
| ID | Kaufpreis (CHF) | Erwarteter Rabatt (%) | Erwartetes Ergebnis (CHF) |
|----|-----------------|-----------------------|---------------------------|
| 1  | 10'000         | 0%                    | 10'000                    |
| 2  | 17'000         | 5%                    | 16'150                    |
| 3  | 22'000         | 7%                    | 20'460                    |
| 4  | 30'000         | 8.5%                  | 27'450                    |

## Übung 2
# Funktionale Black-Box-Testfälle für Autovermietungs-Webseite

| ID  | Beschreibung                                      | Erwartetes Resultat                                      | Effektives Resultat | Status     | Mögliche Ursache                       |
|-----|---------------------------------------------------|----------------------------------------------------------|---------------------|------------|---------------------------------------|
| 1   | Registrierung erfolgreich                          | Nach dem Registirieren wird der User auf die Hauptseite weitergeleitet | Erfolgreich         | Bestanden  | -                                     |
| 2   | Benutzer kann sich erfolgreich einloggen          | Nach Eingabe von Benutzername und Passwort erscheint das Dashboard | Erfolgreich         | Bestanden  | -                                     |
| 3   | Mehr Details                | Nach Klicken der "Mehr Details"- Taste, werden mehr Details zum Fahrzeug angegeben.    | Erfolgreich         | Bestanden  | -                                     |
| 4   | Suche nach verfügbaren Fahrzeugen                 | Nach Eingabe von Suchkriterien werden verfügbare Fahrzeuge angezeigt | Erfolgreich         | Bestanden  | -                                     |
| 5   | Email-Bestätigung nach Registration                   | Um die Registration erfolgreich abzuschliessen, muss zuerst die angegebene Email bestätigt werden.   | Erfolgreich         | Bestanden  | -                                     |


## Übung 3

# Übung 3: Testfälle und Verbesserungsvorschläge

## Black-Box Testfälle
| **Test Case ID** | **Beschreibung** | **Eingabe** | **Erwartete Ausgabe** |
|------------------|------------------|-------------|-----------------------|
| TC1              | Erstelle ein neues Konto | Name: "Doe", Währung: USD, Guthaben: 1000 | Konto mit ID 1 erstellt |
| TC2              | Einzahlung auf ein Konto | Konto ID: 1, Betrag: 500 | Guthaben auf 1500 aktualisiert |
| TC3              | Abheben von einem Konto mit ausreichendem Guthaben | Konto ID: 1, Betrag: 300 | Guthaben auf 1200 aktualisiert |
| TC4              | Abheben von einem Konto mit unzureichendem Guthaben | Konto ID: 1, Betrag: 2000 | Abhebung fehlgeschlagen |
| TC5              | Konto löschen | Konto ID: 1 | Konto gelöscht |
| TC6              | Abfrage des Wechselkurses | Von: EUR, Nach: CHF | Wechselkurs als `double` zurückgegeben |
| TC7              | Beenden der Anwendung | Eingabe: 0 | Anwendung wird beendet |

## White-Box Testfälle
| **Test Case ID** | **Methode** | **Beschreibung** | **Erwartete Ausgabe** |
|------------------|-------------|------------------|-----------------------|
| WTC1             | `Account.deposit()` | Teste Einzahlung eines positiven Betrags | Guthaben erhöht sich um den angegebenen Betrag |
| WTC2             | `Account.withdraw()` | Teste Abheben eines Betrags kleiner als das Guthaben | Gibt `true` zurück und aktualisiert Guthaben |
| WTC3             | `Account.withdraw()` | Teste Abheben eines Betrags größer als das Guthaben | Gibt `false` zurück, keine Änderung am Guthaben |
| WTC4             | `Bank.getAccount()` | Vorhandenes Konto abrufen | Gibt das `Account`-Objekt zurück |
| WTC5             | `Bank.getAccount()` | Nicht vorhandenes Konto abrufen | Gibt `null` zurück |
| WTC6             | `ExchangeRateOkhttp.getRate()` | Abrufen eines gültigen Wechselkurses | Gibt einen gültigen `double`-Wert zurück |
| WTC7             | `ExchangeRateOkhttp.getRate()` | Netzwerkfehler beim Abrufen des Wechselkurses | Gibt `0.0` zurück und protokolliert Fehler |

## Mögliche Code-Improvements
- pseudoDeleteAccount-Funktion ist unnötig, besser einfach die  Funktion von Bank.java verwenden, damit nicht leere Objekte in der Liste bestehen.

- Kommentieren der Regex in der Counter.java Klasse.

- In der Main-Methode ist es sehr unglaubwürdig, dass der Bank-Account von Bezos nur 100.50 CHF hat. 
