package com.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static Map<String, Integer> createAccount(String name){
        Map<String, Integer> account = new HashMap<String, Integer>();
        account.put(name, 0);
        return account;
    }
    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {

            if (amount < 0){
                return accounts;
            }
            if (accounts.containsKey(account)) {
                accounts.put(account, accounts.get(account) + amount);
            }

        return accounts;
    }
      public static Map<String, Integer> withdraw(Map<String, Integer> accounts, String account, int amount) {

            if (amount < 0){
                return accounts;
            }
            if (accounts.containsKey(account)) {
                if (accounts.get(account) - amount < 0) {
                    return accounts;
                }
                accounts.put(account, accounts.get(account) - amount);
            }
        return accounts;
    }
     public static Map<String, Integer> transfer(Map<String, Integer> accounts, String fromAccount, String toAccount, int amount) {
        if (fromAccount.equals(toAccount)) {
            System.out.println("No se puede transferir entre la misma cuenta.");
            return accounts;
        }
        if (amount < 0) {
            System.out.println("No se puede realizar una transferencia negativa.");
            return accounts;
        }
        if (!accounts.containsKey(fromAccount) || !accounts.containsKey(toAccount)) {
            System.out.println("Una o ambas cuentas no existen.");
            return accounts;
        }
        if (accounts.get(fromAccount) < amount) {
            System.out.println("No hay suficiente saldo en la cuenta de origen.");
            return accounts;
        }
        accounts.put(fromAccount, accounts.get(fromAccount) - amount);
        accounts.put(toAccount, accounts.get(toAccount) + amount);
        System.out.println("Transferencia realizada con éxito.");
        return accounts;
    }


}
