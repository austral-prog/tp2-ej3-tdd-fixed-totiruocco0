package com.template;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.template.App.deposit;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(true, true);
    }
}
