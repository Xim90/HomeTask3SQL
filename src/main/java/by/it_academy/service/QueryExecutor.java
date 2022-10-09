package by.it_academy.service;

import by.it_academy.constants.AccountInfo;
import by.it_academy.constants.ColumnLabelSQL;
import by.it_academy.constants.ErrorMessage;
import by.it_academy.constants.Query;
import by.it_academy.exception.AppException;

import java.sql.*;

public class QueryExecutor {

    private QueryExecutor() {
    }

    public static void registerNewUserSQL(Connection connection, String name, String address) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Query.REGISTER_USER)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(ErrorMessage.CANNOT_REGISTER_USER);
        }
    }

    public static void createUserAccountSQL(Connection connection, int userId, String currency) {
        checkUserAccountsSQL(connection, userId, currency);
        try (PreparedStatement preparedStatement = connection.prepareStatement(Query.CREATE_NEW_ACCOUNT)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, 0);
            preparedStatement.setString(3, currency);
            preparedStatement.executeUpdate();
        } catch (SQLException y) {
            System.out.println(ErrorMessage.CANNOT_CREATE_AN_ACCOUNT);
        }
    }

    private static void checkUserAccountsSQL(Connection connection, int userId, String currency) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(Query.SELECT_CURRENCY_FROM_ACCOUNTS_WHERE_USERID)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString(ColumnLabelSQL.CURRENCY).equals(currency)) {
                    resultSet.close();
                    throw new AppException(ErrorMessage.ACCOUNT_IN_THIS_CURRENCY_ALREADY_EXISTS);
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(ErrorMessage.CANNOT_CHECK_USER_ACCOUNTS);
        }
    }

    public static void replenishAccountSQL(Connection connection, int accountId, int amount) {
        if (amount > AccountInfo.AMOUNT_LIMIT) {
            throw new AppException(ErrorMessage.TRANSACTION_CANNOT_BE_MORE_THAN_LIMIT);
        }
        updateBalanceSQL(connection, Query.CREATE_NEW_TRANSACTION, accountId, amount,
                ErrorMessage.CANNOT_TOP_UP_ACCOUNT);
        int balance = getAccountBalanceSQL(connection, accountId) + amount;
        if (balance > AccountInfo.BALANCE_LIMIT) {
            throw new AppException(ErrorMessage.BALANCE_CANNOT_BE_MORE_THAN_LIMIT);
        }
        updateBalanceSQL(connection, Query.UPDATE_ACCOUNT_BALANCE, balance, accountId,
                ErrorMessage.CANNOT_UPDATE_BALANCE);
    }

    public static void withdrawFundsFromAccountSQL(Connection connection, int accountId, int amount) {
        if (amount > AccountInfo.AMOUNT_LIMIT) {
            throw new AppException(ErrorMessage.TRANSACTION_CANNOT_BE_MORE_THAN_LIMIT);
        }
        updateBalanceSQL(connection, Query.CREATE_NEW_TRANSACTION, accountId, amount * (-1),
                ErrorMessage.CANNOT_WITHDRAW_FUNDS_FROM_ACCOUNT);
        int balance = getAccountBalanceSQL(connection, accountId) - amount;
        if (balance < 0) {
            throw new AppException(ErrorMessage.BALANCE_CANNOT_BE_LESS_THAN_0);
        }
        updateBalanceSQL(connection, Query.UPDATE_ACCOUNT_BALANCE, balance, accountId,
                ErrorMessage.CANNOT_UPDATE_BALANCE);
    }

    private static int getAccountBalanceSQL(Connection connection, int accountId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Query.GET_ACCOUNT_BALANCE)) {
            preparedStatement.setInt(1, accountId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            int balance = resultSet.getInt(ColumnLabelSQL.BALANCE);
            resultSet.close();
            return balance;
        } catch (SQLException e) {
            throw new AppException(ErrorMessage.CANNOT_CHECK_BALANCE);
        }
    }

    private static void updateBalanceSQL(Connection connection, String sql, int balance, int accountId,
                                         String errorMessage) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, balance);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(errorMessage);
        }
    }
}
