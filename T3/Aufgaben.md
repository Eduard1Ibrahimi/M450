# Zusammenfassung der Aufgaben

## Aufgabe 1
**Was wird wie in unserer Firma getestet?**

### 1. Mit welchen Test Levels hatten wir bereits zu tun?
In unserer Firma haben wir schon mit verschiedenen Test Levels gearbeitet, um sicherzustellen, dass unsere Software am Ende gut funktioniert:

- **Unit Tests**: Die schreiben meistens die Entwickler selbst, um zu testen, ob einzelne Funktionen oder Methoden so arbeiten, wie sie sollen. Dafür benutzen wir Tools wie JUnit.
- **Integration Tests**: Hier prüfen wir, ob verschiedene Teile unserer Software auch gut miteinander klarkommen, zum Beispiel wenn unsere Services miteinander reden müssen.
- **System Tests**: Das machen wir, um sicherzugehen, dass alles zusammenpasst, bevor es an die Kunden geht. Wir testen das in einer Umgebung, die so ähnlich ist wie unsere echte Umgebung.
- **User Acceptance Tests (UAT)**: Diese Tests führen wir meistens mit ein paar echten Nutzern durch, um zu sehen, ob alles so funktioniert, wie es gedacht ist, und ob die Nutzer damit klarkommen.

### 2. Wann werden die Tests durchgeführt?
- **Unit und Integration Tests** laufen automatisch, jedes Mal, wenn jemand den Code ändert und speichert. Das geht über unsere CI-Pipeline (Continuous Integration).
- **System Tests** machen wir, bevor eine neue Version veröffentlicht wird, also meistens kurz vor einem Release.
- **User Acceptance Tests** finden eher zum Schluss statt, damit wir sicher sind, dass unsere Nutzer zufrieden sind, bevor die neue Version rausgeht.

### 3. Haben wir ein eigenes Testing- oder QA-Team?
Leider nicht. Die Entwickler schreiben und testen selbst. Manchmal lässt man einen Kollegen ausserhalb des Projet-Teams testen.

### 4. Wie sieht unser Testing Life Cycle aus?
So läuft das Testen bei uns in der Firma ab:

1. **Testplanung**: Zuerst überlegen wir uns, wie wir testen wollen und welche Tools wir dafür brauchen.
2. **Testdesign**: Dann schreiben wir die Testfälle und Testscripts, basierend auf dem, was die Software können soll.
3. **Testdurchführung**: Jetzt führen wir die Tests aus, sowohl automatisch als auch manuell.
4. **Fehlerberichterstattung**: Wenn wir Fehler finden, tragen wir die in unser System (z.B. Jira) ein.
5. **Regressionstests**: Wenn die Fehler behoben sind, testen wir nochmal alles, um sicherzugehen, dass nichts anderes kaputt gegangen ist.
6. **Abschluss und Freigabe**: Wenn alle Tests bestanden sind, geht die Software raus an die Kunden.

---

## Aufgabe 2
**Einordnung und Erklärung der Begriffe**

1. **Testing Approach**:
   - Der Testing Approach beschreibt, wie wir generell testen wollen, z.B. ob wir **manuell** oder **automatisch** testen oder ob wir **Black-Box** oder **White-Box** Testing verwenden. Das hängt davon ab, was gerade besser passt und welche Ressourcen wir haben.

2. **Testing Levels**:
   - Das sind die verschiedenen Stufen, auf denen wir testen:
     - **Unit Testing**: Einzelne Funktionen oder Methoden testen.
     - **Integration Testing**: Schauen, ob die verschiedenen Module gut zusammenarbeiten.
     - **System Testing**: Die komplette Software in einer Testumgebung testen.
     - **Acceptance Testing**: Prüfen, ob alles so funktioniert, wie es der Kunde möchte.

3. **Testing Types, Techniques und Tactics**:
   - **Testing Types** sind verschiedene Arten von Tests, z.B. **funktionale Tests**, **Performance-Tests** oder **Regressionstests**.
   - **Testing Techniques** sind Methoden, wie wir Testfälle erstellen, z.B. **Grenzwertanalyse** oder **Äquivalenzklassen**.
   - **Testing Tactics** sind bestimmte Vorgehensweisen, um unsere Tests zu verbessern, wie z.B. **Mocks**, **Stubs** oder das Bereitstellen von speziellen Testdaten.

---

