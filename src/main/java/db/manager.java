package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class manager {

    private static final String URL = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Dhoufv3865";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Підключення до бази даних успішне!");
        } catch (SQLException e) {
            System.out.println("Помилка підключення до БД");
            e.printStackTrace();
        }
    }
}
