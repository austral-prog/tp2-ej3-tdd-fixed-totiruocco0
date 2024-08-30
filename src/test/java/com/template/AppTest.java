package com.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testCreateAccount(){
        String testSubject = "toto";
        Map<String, Integer> account = createAccount(testSubject);
        assertEquals(true, account.containsKey("toto"));


    }
    @Test
    void testCreateAccountIsEqualToZero(){
        String testSubject = "toto";
        Map<String, Integer> account = createAccount(testSubject);
        assertEquals(true, account.get("toto").equals(0));
    }

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
        Map<String, Integer> updatedAccounts1 = deposit(accounts, "jaun", -1);
        assertEquals(accounts, updatedAccounts1);
        Map<String, Integer> updatedAccounts2 = deposit(accounts, "juan", 2);
        assertEquals(accounts, updatedAccounts2);
    }
    @Test
    void testWithdraw() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("jaun", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 5);
        assertEquals(5, updatedAccounts.get("mati"));
        Map<String, Integer> updatedAccounts1 = withdraw(accounts, "jaun", -1);
        assertEquals(accounts, updatedAccounts1);
        Map<String, Integer> updatedAccounts2 = withdraw(accounts, "juan", 2);
        assertEquals(accounts, updatedAccounts2);
        Map<String, Integer> updatedAccounts3 = withdraw(accounts, "juan", 100);
        assertEquals(accounts, updatedAccounts3);
    }



    @Test
    void testTransferSuccessful() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Alice", 100);
        accounts.put("Bob", 50);
        Map<String, Integer> result = App.transfer(accounts, "Alice", "Bob", 50);
        assertEquals(50, result.get("Alice"));
        assertEquals(100, result.get("Bob"));
    }

    @Test
    void testTransferInsufficientFunds() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Alice", 100);
        accounts.put("Bob", 50);
        Map<String, Integer> result = App.transfer(accounts, "Bob", "Alice", 100);
        assertEquals(50, result.get("Bob"));
        assertEquals(100, result.get("Alice"));
    }

    @Test
    void testTransferSameAccount() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Alice", 100);
        accounts.put("Bob", 50);
        Map<String, Integer> result = App.transfer(accounts, "Alice", "Alice", 50);
        assertEquals(100, result.get("Alice")); // El saldo no debe cambiar
    }

    @Test
    void testTransferNegativeAmount() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Alice", 100);
        accounts.put("Bob", 50);
        Map<String, Integer> result = App.transfer(accounts, "Alice", "Bob", -50);
        assertEquals(100, result.get("Alice")); // El saldo de Alice no debe cambiar
        assertEquals(50, result.get("Bob")); // El saldo de Bob no debe cambiar
    }

    @Test
    void testTransferFromNonExistingAccount() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Alice", 100);
        accounts.put("Bob", 50);
        Map<String, Integer> result = App.transfer(accounts, "Charlie", "Bob", 50);
        assertEquals(50, result.get("Bob")); // El saldo de Bob no debe cambiar
    }

    @Test
    void testTransferToNonExistingAccount() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Alice", 100);
        accounts.put("Bob", 50);
        Map<String, Integer> result = App.transfer(accounts, "Alice", "Charlie", 50);
        assertEquals(100, result.get("Alice")); // El saldo de Alice no debe cambiar
    }
}
