### Aufgabe 1

In der Informatik gibt es verschiedene Testformen wie Unit-Tests, Integrationstests und Systemtests. Unit-Tests prüfen einzelne Programmteile auf korrekte Funktion und werden während der Entwicklung durchgeführt. Integrationstests prüfen das Zusammenspiel verschiedener Module in einer Testumgebung. Systemtests testen das gesamte System unter realistischen Bedingungen, um sicherzustellen, dass es den Anforderungen entspricht.

### Aufgabe 2

Ein Software-Fehler ist ein Defekt im Code, der dazu führt, dass die Software nicht wie erwartet funktioniert. Ein Beispiel wäre ein Programmabsturz durch eine unvorhergesehene Eingabe. Ein Software-Mangel ist hingegen eine Abweichung von den Anforderungen oder Erwartungen, z. B. eine fehlende Funktion. Ein Beispiel für hohen Schaden durch einen Software-Fehler ist der Fehler in der Steuerungssoftware der Ariane-5-Rakete, der 1996 zu deren Absturz und dem Verlust von über 370 Millionen Dollar führte.

### Aufgabe 3
javac PriceCalculation.java
javac PriceCalculationTest.java
java PriceCalculationTest

Fehler in der Logik des Codes: 

if (extras >= 3)
    addon_discount = 10;
else if (extras >= 5)
    addon_discount = 15;
else
    addon_discount = 0;

ist falsch, weil es immer Rabatt von 3+ nehmen wird und nicht 5+.
Korrektur: 

if (extras >= 5)
    addon_discount = 15;
else if (extras >= 3)
    addon_discount = 10;
else
    addon_discount = 0;


(Angepasst in unserem Code)