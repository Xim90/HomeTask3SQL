package by.it_academy.service;

import by.it_academy.constants.MenuMessage;

import java.sql.Connection;
import java.util.Scanner;

public class MenuCommand {

    private MenuCommand() {
    }

    public static void printMenu() {
        System.out.println(MenuMessage.MENU_OPTIONS);
    }

    public static void registerNewUser(Connection connection, Scanner scanner) {
        System.out.println(MenuMessage.ENTER_USER_NAME);
        String name = scanner.next();
        System.out.println(MenuMessage.ENTER_USER_ADDRESS);
        String address = scanner.next();
        QueryExecutor.registerNewUserSQL(connection, name, address);
        System.out.println(MenuMessage.USER_SUCCESSFULLY_REGISTERED);
    }

    public static void createUserAccount(Connection connection, Scanner scanner) {
        System.out.println(MenuMessage.ENTER_USER_ID);
        int userId = scanner.nextInt();
        System.out.println(MenuMessage.ENTER_CURRENCY);
        String currency = scanner.next();
        QueryExecutor.createUserAccountSQL(connection, userId, currency);
        System.out.println(MenuMessage.ACCOUNT_CREATED_SUCCESSFULLY);
    }

    public static void replenishAccount(Connection connection, Scanner scanner) {
        System.out.println(MenuMessage.ENTER_ACCOUNT_ID);
        int accountId = scanner.nextInt();
        System.out.println(MenuMessage.ENTER_AMOUNT);
        int amount = scanner.nextInt();
        QueryExecutor.replenishAccountSQL(connection, accountId, amount);
        System.out.println(MenuMessage.ACCOUNT_SUCCESSFULLY_REPLENISHED);
    }

    public static void withdrawFundsFromAccount(Connection connection, Scanner scanner) {
        System.out.println(MenuMessage.ENTER_ACCOUNT_ID);
        int accountId = scanner.nextInt();
        System.out.println(MenuMessage.ENTER_AMOUNT);
        int amount = scanner.nextInt();
        QueryExecutor.withdrawFundsFromAccountSQL(connection, accountId, amount);
        System.out.println(MenuMessage.FUNDS_SUCCESSFULLY_WITHDRAWN_FROM_ACCOUNT);
    }
}
