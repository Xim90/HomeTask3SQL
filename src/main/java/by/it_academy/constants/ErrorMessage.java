package by.it_academy.constants;

public class ErrorMessage {
    public static final String JDBC_DRIVER_NOT_FOUND = "JDBC driver not found";
    public static final String CANNOT_CREATE_CONNECTION = "Cannot create a connection";
    public static final String INCORRECT_INPUT = "Incorrect input!";
    public static final String CANNOT_UPDATE_BALANCE = "Cannot update balance";
    public static final String CANNOT_CHECK_BALANCE = "Cannot check balance";
    public static final String CANNOT_WITHDRAW_FUNDS_FROM_ACCOUNT = "Cannot withdraw funds from account";
    public static final String CANNOT_TOP_UP_ACCOUNT = "Cannot top up account";
    public static final String CANNOT_CREATE_AN_ACCOUNT = "Cannot create an account";
    public static final String CANNOT_REGISTER_USER = "Cannot register user";
    public static final String CANNOT_CHECK_USER_ACCOUNTS = "Cannot check user's accounts";
    public static final String ACCOUNT_IN_THIS_CURRENCY_ALREADY_EXISTS = "An account in this currency already exists";
    public static final String BALANCE_CANNOT_BE_LESS_THAN_0 = "Balance cannot be less than 0";
    public static final String BALANCE_CANNOT_BE_MORE_THAN_LIMIT = "Balance cannot be more than " +
            AccountInfo.BALANCE_LIMIT;
    public static final String TRANSACTION_CANNOT_BE_MORE_THAN_LIMIT = "Transaction cannot be more than " +
            AccountInfo.AMOUNT_LIMIT;

    private ErrorMessage() {
    }
}
