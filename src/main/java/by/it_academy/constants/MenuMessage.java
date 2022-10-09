package by.it_academy.constants;

public class MenuMessage {
    public static final String MENU_OPTIONS = """
            Enter:
            1 - new user registration
            2 - add an account to the new user
            3 - replenish the user's account
            4 - withdraw funds from the user's account
            5- finish program""";
    public static final String ENTER_USER_NAME = "Enter user's name";
    public static final String ENTER_USER_ADDRESS = "Enter user's address";
    public static final String ENTER_USER_ID = "Enter user's ID";
    public static final String ENTER_ACCOUNT_ID = "Enter account ID";
    public static final String ENTER_CURRENCY = "Enter currency";
    public static final String ENTER_AMOUNT = "Enter amount";
    public static final String THANKS_FOR_USING_THE_PROGRAM = "Thanks for using the program!";
    public static final String USER_SUCCESSFULLY_REGISTERED = "User successfully registered";
    public static final String ACCOUNT_CREATED_SUCCESSFULLY = "Account created successfully";
    public static final String ACCOUNT_SUCCESSFULLY_REPLENISHED = "Account successfully replenished";
    public static final String FUNDS_SUCCESSFULLY_WITHDRAWN_FROM_ACCOUNT =
            "Funds have been successfully withdrawn from the account";

    private MenuMessage() {
    }
}
