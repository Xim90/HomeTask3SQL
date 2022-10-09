package by.it_academy.util;

import by.it_academy.constants.ErrorMessage;
import by.it_academy.constants.Path;

public class DriverJDBCRegistrar {

    private DriverJDBCRegistrar() {
    }

    public static boolean registerDriverJDBC() {
        try {
            Class.forName(Path.JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(ErrorMessage.JDBC_DRIVER_NOT_FOUND);
            return false;
        }
        return true;
    }
}
