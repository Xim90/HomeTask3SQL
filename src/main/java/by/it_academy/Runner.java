package by.it_academy;
import by.it_academy.constants.*;
import by.it_academy.constants.ErrorMessage;
import by.it_academy.exception.AppException;
import by.it_academy.service.MenuCommand;
import by.it_academy.util.DriverJDBCRegistrar;

import java.sql.*;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        if (DriverJDBCRegistrar.registerDriverJDBC()) {
            try (Connection connection = DriverManager.getConnection(Path.FULL_PATH_BANK_ACCOUNTS_BASE)) {
                String input;
                do {
                    MenuCommand.printMenu();
                    Scanner scanner = new Scanner(System.in);
                    input = scanner.next();
                    switch (input) {
                        case ("1") -> MenuCommand.registerNewUser(connection, scanner);
                        case ("2") -> MenuCommand.createUserAccount(connection, scanner);
                        case ("3") -> MenuCommand.replenishAccount(connection, scanner);
                        case ("4") -> MenuCommand.withdrawFundsFromAccount(connection, scanner);
                        case ("5") -> System.out.println(MenuMessage.THANKS_FOR_USING_THE_PROGRAM);
                        default -> System.out.println(ErrorMessage.INCORRECT_INPUT);
                    }
                }
                while (!input.equals("5"));
            } catch (SQLException e) {
                throw new AppException(ErrorMessage.CANNOT_CREATE_CONNECTION);
            }
        }
    }

}
