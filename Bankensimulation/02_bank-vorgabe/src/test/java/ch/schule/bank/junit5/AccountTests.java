package ch.schule.bank.junit5;

import ch.schule.Account;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
public class AccountTests {

    /**
     * Testet die Initialisierung eines Kontos.
     */
    @Test
    public void testInit() {
        Account account = new Account("12345") {};
        assertEquals("12345", account.getId());
        assertEquals(0, account.getBalance());
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        Account account = new Account("12345") {};

        // Test valid deposit
        assertTrue(account.deposit(20231125, 5000));
        assertEquals(5000, account.getBalance());

        // Test negative deposit (invalid)
        assertFalse(account.deposit(20231125, -1000));
        assertEquals(5000, account.getBalance());

        // Test deposit with invalid date
        assertFalse(account.deposit(20221125, 1000));
        assertEquals(5000, account.getBalance());
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        Account account = new Account("12345") {};

        // Add initial balance
        assertTrue(account.deposit(20231125, 5000));

        // Test valid withdrawal
        assertTrue(account.withdraw(20231126, 2000));
        assertEquals(3000, account.getBalance());

        // Test withdrawal with negative amount (invalid)
        assertFalse(account.withdraw(20231127, -1000));
        assertEquals(3000, account.getBalance());

        // Test withdrawal with invalid date
        assertFalse(account.withdraw(20221125, 1000));
        assertEquals(3000, account.getBalance());

        // Test withdrawal exceeding balance (invalid)
        assertFalse(account.withdraw(20231128, 4000));
        assertEquals(3000, account.getBalance());
    }

    /**
     * Tests the reference from SavingsAccount.
     */
    @Test
    public void testReferences() {
        Account savingsAccount = new Account("67890") {};

        // Check initial setup
        assertEquals("67890", savingsAccount.getId());
        assertEquals(0, savingsAccount.getBalance());
    }

    /**
     * Testet die canTransact-Methode.
     */
    @Test
    public void testCanTransact() {
        Account account = new Account("12345") {};

        // No bookings, transactions should be allowed
        assertTrue(account.canTransact(20231125));

        // Add a booking and test transaction dates
        account.deposit(20231125, 5000);
        assertTrue(account.canTransact(20231125)); // Same day
        assertTrue(account.canTransact(20231126)); // Future date
        assertFalse(account.canTransact(20221125)); // Past date
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Account account = new Account("12345") {};

        // Add transactions
        account.deposit(20231125, 5000);
        account.withdraw(20231126, 2000);

        // Capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        account.print();

        // Validate the printed output
        String output = outContent.toString();
        assertTrue(output.contains("Kontoauszug '12345'"));
        assertTrue(output.contains("Datum"));
        assertTrue(output.contains("5000"));
        assertTrue(output.contains("-2000"));
        assertTrue(output.contains("3000"));
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testMonthlyPrint() {
        Account account = new Account("12345") {};

        // Add transactions for different months
        account.deposit(20231001, 5000); // October
        account.withdraw(20231101, 2000); // November
        account.deposit(20231115, 3000); // November

        // Capture printed output for November
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        account.print(2023, 11);

        // Validate the printed output
        String output = outContent.toString();
        assertTrue(output.contains("Monat: 11.2023"));
        assertTrue(output.contains("-2000"));
        assertTrue(output.contains("3000"));
        assertFalse(output.contains("5000")); // October transaction shouldn't appear
    }
}
