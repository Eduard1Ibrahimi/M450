package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the class 'Bank'.
 *
 * @version 1.0
 */
public class BankTests {

    /**
     * Tests creating new accounts.
     */
    @Test
    public void testCreate() {
        Bank bank = new Bank();

        // Test creating a savings account
        String savingsAccountId = bank.createSavingsAccount();
        assertNotNull(savingsAccountId);
        assertTrue(savingsAccountId.startsWith("S-"));

        // Test creating a promo youth savings account
        String youthSavingsAccountId = bank.createPromoYouthSavingsAccount();
        assertNotNull(youthSavingsAccountId);
        assertTrue(youthSavingsAccountId.startsWith("Y-"));

        // Test creating a salary account
        String salaryAccountId = bank.createSalaryAccount(-5000); // Negative credit limit
        assertNotNull(salaryAccountId);
        assertTrue(salaryAccountId.startsWith("P-"));

        // Test invalid salary account (positive credit limit)
        String invalidAccountId = bank.createSalaryAccount(5000);
        assertNull(invalidAccountId);
    }

    /**
     * Tests depositing money into accounts.
     */
    @Test
    public void testDeposit() {
        Bank bank = new Bank();

        String accountId = bank.createSavingsAccount();

        // Test valid deposit
        assertTrue(bank.deposit(accountId, 20231125, 5000));
        assertEquals(-5000, bank.getBalance(accountId));

        // Test invalid deposit (negative amount)
        assertFalse(bank.deposit(accountId, 20231125, -1000));
        assertEquals(-5000, bank.getBalance(accountId));

        // Test invalid deposit (non-existent account)
        assertFalse(bank.deposit("INVALID", 20231125, 1000));
    }

    /**
     * Tests withdrawing money from accounts.
     */
    @Test
    public void testWithdraw() {
        Bank bank = new Bank();

        String accountId = bank.createSavingsAccount();

        // Deposit some money first
        bank.deposit(accountId, 20231125, 5000);

        // Test valid withdrawal
        assertTrue(bank.withdraw(accountId, 20231126, 2000));
        assertEquals(-3000, bank.getBalance(accountId));

        // Test invalid withdrawal (non-existent account)
        assertFalse(bank.withdraw("INVALID", 20231125, 1000));

        // Test invalid withdrawal (negative amount)
        assertFalse(bank.withdraw(accountId, 20231127, -1000));

        // Test invalid withdrawal (exceeding balance)
        assertFalse(bank.withdraw(accountId, 20231128, 4000));
    }

    /**
     * Tests printing an account's statement.
     */
    @Test
    public void testPrint() {
        Bank bank = new Bank();

        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 20231125, 5000);
        bank.withdraw(accountId, 20231126, 2000);

        // Redirect output to capture the print statements
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bank.print(accountId);

        // Validate the printed output
        String output = outContent.toString();
        assertTrue(output.contains("Kontoauszug '" + accountId + "'"));
        assertTrue(output.contains("5000"));
        assertTrue(output.contains("-2000"));
    }

    /**
     * Tests printing an account's statement for a specific month.
     */
    @Test
    public void testMonthlyPrint() {
        Bank bank = new Bank();

        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 20231001, 5000); // October
        bank.withdraw(accountId, 20231101, 2000); // November
        bank.deposit(accountId, 20231115, 3000); // November

        // Redirect output to capture the print statements
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bank.print(accountId, 2023, 11); // Print for November 2023

        // Validate the printed output
        String output = outContent.toString();
        assertTrue(output.contains("Monat: 11.2023"));
        assertTrue(output.contains("-2000"));
        assertTrue(output.contains("3000"));
        assertFalse(output.contains("5000")); // October transaction shouldn't appear
    }

    /**
     * Tests the total balance of the bank.
     */
    @Test
    public void testBalance() {
        Bank bank = new Bank();

        String account1 = bank.createSavingsAccount();
        String account2 = bank.createPromoYouthSavingsAccount();

        bank.deposit(account1, 20231125, 5000);
        bank.deposit(account2, 20231125, 7000);

        assertEquals(-12000, bank.getBalance()); // Negative because balance is decreased in getBalance()
    }

    /**
     * Tests printing the "top 5" accounts by balance.
     */
    @Test
    public void testTop5() {
        Bank bank = new Bank();

        for (int i = 0; i < 6; i++) {
            String accountId = bank.createSavingsAccount();
            bank.deposit(accountId, 20231125, (i + 1) * 1000);
        }

        // Redirect output to capture the print statements
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bank.printTop5();

        // Validate the printed output
        String output = outContent.toString();
        assertTrue(output.contains("S-1005")); // Highest balance
        assertTrue(output.contains("S-1004")); // Second highest balance
        assertFalse(output.contains("S-1000")); // Lowest balance shouldn't appear in top 5
    }

    /**
     * Tests printing the "bottom 5" accounts by balance.
     */
    @Test
    public void testBottom5() {
        Bank bank = new Bank();

        for (int i = 0; i < 6; i++) {
            String accountId = bank.createSavingsAccount();
            bank.deposit(accountId, 20231125, (i + 1) * 1000);
        }

        // Redirect output to capture the print statements
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bank.printBottom5();

        // Validate the printed output
        String output = outContent.toString();
        assertTrue(output.contains("S-1000")); // Lowest balance
        assertTrue(output.contains("S-1001")); // Second lowest balance
        assertFalse(output.contains("S-1005")); // Highest balance shouldn't appear in bottom 5
    }
}
