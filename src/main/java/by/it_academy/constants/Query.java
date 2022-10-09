package by.it_academy.constants;

import static by.it_academy.constants.ColumnLabelSQL.*;

public class Query {
    public static final String REGISTER_USER = "INSERT INTO Users(" + NAME + "," + ADDRESS + ") VALUES(?,?)";
    public static final String CREATE_NEW_ACCOUNT = "INSERT INTO Accounts" +
            "(" + USER_ID + "," + BALANCE + "," + CURRENCY + ") VALUES(?,?,?)";
    public static final String GET_ACCOUNT_BALANCE = "SELECT balance FROM Accounts WHERE " + ACCOUNT_ID + " = ?";
    public static final String UPDATE_ACCOUNT_BALANCE = "UPDATE Accounts SET " + BALANCE + " = ? " +
            "WHERE " + ACCOUNT_ID + " = ?";
    public static final String CREATE_NEW_TRANSACTION = "INSERT INTO Transactions" +
            "(" + ACCOUNT_ID + "," + AMOUNT + ") VALUES(?,?)";
    public static final String SELECT_CURRENCY_FROM_ACCOUNTS_WHERE_USERID =
            "SELECT currency FROM Accounts WHERE userId = ?";

    private Query() {
    }
}
