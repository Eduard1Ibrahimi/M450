# Gängige JUnit-Features

JUnit ist ein weit verbreitetes Framework zum Testen von Java-Anwendungen. Hier sind die wichtigsten und am häufigsten genutzten Features:

## 1. **Annotations**
JUnit-Annotations helfen, Testfälle klar zu definieren und zu organisieren:
- `@Test`: Markiert eine Methode als Testfall.
- `@BeforeEach`: Führt Code vor jedem Test aus.
- `@AfterEach`: Führt Code nach jedem Test aus.
- `@BeforeAll`: Führt Code einmal vor allen Tests aus.
- `@AfterAll`: Führt Code einmal nach allen Tests aus.
- `@Disabled`: Deaktiviert einen Test.

## 2. **Assertions**
Assertions prüfen, ob Testbedingungen erfüllt sind:
- `assertEquals(expected, actual)`: Überprüft, ob zwei Werte gleich sind.
- `assertTrue(condition)`: Überprüft, ob eine Bedingung wahr ist.
- `assertThrows(exceptionType, executable)`: Erwartet, dass eine bestimmte Ausnahme auftritt.

## 3. **Parameterized Tests**
Ermöglicht das Ausführen eines Tests mit verschiedenen Eingabewerten:
```java
@ParameterizedTest
@ValueSource(ints = {1, 2, 3})
void testWithParameters(int number) {
    assertTrue(number > 0);
}
```

## 4. **Assertions mit Zeitlimit**
Überprüft, ob ein Test innerhalb eines bestimmten Zeitrahmens ausgeführt wird:
```java
@Test
void testTimeout() {
    assertTimeout(Duration.ofSeconds(2), () -> {
        // Testlogik
    });
}
```

## 4. **Test Suites**
Gruppiert mehrere Testklassen in einer Suite:
```java
@Suite
@SelectClasses({TestClass1.class, TestClass2.class})
class AllTestsSuite {}

```
Referenzseite:
junit.org

