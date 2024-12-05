# Dokumentation zur Funktionsweise und Zusammenhängen der Software

## Überblick
Die Software ist ein Banken-Simulationssystem, das es ermöglicht, verschiedene Arten von Bankkonten zu erstellen, Einzahlungen und Abhebungen durchzuführen sowie Berichte über Transaktionen und Kontenstände zu erstellen. Die Struktur basiert auf einer OOP-Architektur mit klar definierten Klassen für Bankoperationen.

---

## Klassenübersicht

### 1. **`Bank`**
- **Aufgabe**: Verwaltung mehrerer Konten und Bereitstellung von Bankoperationen.
- **Methoden**:
    - `createSavingsAccount()`: Erstellt ein neues Sparkonto (`S-xxxx`).
    - `createPromoYouthSavingsAccount()`: Erstellt ein Promo-Jugendkonto (`Y-xxxx`).
    - `createSalaryAccount(creditLimit)`: Erstellt ein Gehaltskonto (`P-xxxx`) mit negativem Kreditlimit.
    - `deposit(accountId, date, amount)`: Führt eine Einzahlung auf ein Konto durch.
    - `withdraw(accountId, date, amount)`: Führt eine Abhebung von einem Konto durch.
    - `getBalance(accountId)`: Gibt den aktuellen Kontostand eines Kontos zurück.
    - `print(accountId)`: Gibt die Transaktionen eines Kontos aus.
    - `print(accountId, year, month)`: Gibt Transaktionen eines Kontos für einen bestimmten Monat aus.
    - `printTop5()`: Gibt die Top 5 Konten mit den höchsten Guthaben aus.
    - `printBottom5()`: Gibt die 5 Konten mit den niedrigsten Guthaben aus.

---

### 2. **`Account`**
- **Aufgabe**: Abstrakte Basisklasse für Bankkonten.
- **Attribute**:
    - `id`: Konto-ID.
    - `balance`: Kontostand.
- **Methoden**:
    - `deposit(date, amount)`: Führt eine Einzahlung durch.
    - `withdraw(date, amount)`: Führt eine Abhebung durch.
    - `canTransact(date)`: Prüft, ob Transaktionen an einem bestimmten Datum erlaubt sind.
    - `print()`: Gibt Transaktionen aus.
    - `print(year, month)`: Gibt monatliche Transaktionen aus.

---

### 3. **`SavingsAccount`**
- **Erbt von**: `Account`.
- **Zusatzfunktionalität**:
    - Standard-Sparkonto ohne spezielle Einschränkungen.

---

### 4. **`PromoYouthSavingsAccount`**
- **Erbt von**: `Account`.
- **Zusatzfunktionalität**:
    - Begrenzungen und Werbeaktionen für jugendliche Nutzer.

---

### 5. **`SalaryAccount`**
- **Erbt von**: `Account`.
- **Zusatzfunktionalität**:
    - Ermöglicht das Festlegen eines negativen Kreditlimits.

---

### 6. **`Booking`**
- **Aufgabe**: Repräsentiert einzelne Transaktionen auf einem Konto.
- **Attribute**:
    - `date`: Transaktionsdatum.
    - `amount`: Betrag der Transaktion.
- **Methoden**:
    - `print()`: Gibt die Transaktionsdetails aus.

---

## Test-Klassenübersicht
Unit-Tests prüfen die Funktionalität der einzelnen Klassen:

### `AccountTests`
- Testet Initialisierung, Ein- und Auszahlungen, Transaktionslimits und Druckfunktionen.

### `BankTests`
- Prüft Kontoerstellung, Ein- und Auszahlungen, Berichte und Top/Bottom 5 Funktionalitäten.

### `BookingTests`
- Soll die Erzeugung und Ausgabe von Transaktionen testen (TODO markiert).

### `PromoYouthSavingsAccountTests`
- TODO: Testet spezielle Funktionalitäten des Promo-Jugendkontos.

### `SalaryAccountTests`
- TODO: Testet negative Kreditlimits und spezifische Regeln des Gehaltskontos.

### `SavingsAccountTests`
- TODO: Prüft die Standard-Funktionen des Sparkontos.

---

## Hauptprogramm `TestBank`

### **Ablauf**:
1. **Bank erstellen**: Erstellt eine Instanz der `Bank`-Klasse.
2. **Konten erstellen**: Erstellt verschiedene Kontotypen (Sparkonto, Jugendkonto, etc.).
3. **Einzahlungen/Abhebungen**: Führt Einzahlungen und Abhebungen auf verschiedenen Konten durch.
4. **Berichte**:
    - Druck der Top 5 und Bottom 5 Konten.
    - Ausgabe von Transaktionsdetails und Salden.
5. **Mehrere Banken**: Simulation verschiedener Banken (z. B. UBS, Migros).

---

## Abhängigkeiten und Zusammenhänge
- **`Bank` verwaltet Konten**: Die Klasse `Bank` ruft Methoden der `Account`-Klassen auf, um Operationen durchzuführen.
- **`Account` speichert Buchungen**: Jede Instanz eines `Account` speichert `Booking`-Objekte, die Transaktionen repräsentieren.
- **Polymorphie bei Konten**: Verschiedene Konto-Typen erben von der Basisklasse `Account` und implementieren spezifische Logik.
- **Tests prüfen Integration**: Test-Klassen prüfen sowohl einzelne Module als auch das Zusammenspiel zwischen `Bank`, `Account` und `Booking`.

---

## TODOs
- Implementierung fehlender Tests (`BookingTests`, `PromoYouthSavingsAccountTests`, etc.).
- Eventuell Validierung der Eingaben (z. B. Negativbeträge).
- Verbesserung der Transaktionsberichte (z. B. Filter und Sortierung).
