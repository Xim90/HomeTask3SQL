package by.it_academy.constants;

public class Path {
    public static final String JDBC_DRIVER = "org.sqlite.JDBC";
    public static final String USER_DIR = "user.dir";
    public static final String PATH_FROM_CONTENT_ROOT_TO_BANK_ACCOUNTS_BASE =
            "\\src\\main\\resources\\BankAccountsBase.db";
    public static final String JDBC_SQLITE = "jdbc:sqlite:";
    public static final String FULL_PATH_BANK_ACCOUNTS_BASE = JDBC_SQLITE +
            System.getProperty(USER_DIR) + PATH_FROM_CONTENT_ROOT_TO_BANK_ACCOUNTS_BASE;

    private Path() {
    }
}
