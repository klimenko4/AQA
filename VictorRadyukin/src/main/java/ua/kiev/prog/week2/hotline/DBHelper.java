package ua.kiev.prog.week2.hotline;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Zver on 15.04.2017.
 */
public class DBHelper {

    private static final String CONNECTION = "jdbc:mysql://127.0.0.1:3306/db_user?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(CONNECTION, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection to Database Failed!");
        }
        return  connection;
    }

    public Boolean createTable() {
        String createTableSQLQuery = "CREATE TABLE IF NOT EXISTS new_user_data (" +
                "   id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY," +
                "    email VARCHAR(50)," +
                "    nick VARCHAR(50)," +
                "    pass VARCHAR(50)," +
                "    email_err_message VARCHAR(50)," +
                "    nick_err_message VARCHAR(50)," +
                "    pass_err_message VARCHAR(50)" +
                ") COLLATE utf8_general_ci," +
                "  CHARACTER SET utf8";
        try {
            Connection connection = getConnection();
            connection.createStatement()
                      .execute(createTableSQLQuery);
        } catch (SQLException e) {
            System.out.println("Creating Statement failed!");
            return false;
        }
        return true;
    }


    public Boolean insertRecordIntoTable(String email, String nick, String pass,
                                      String emailErrMessage, String nickErrMessage,
                                      String passErrMessage) {
        String insertRowSQLQuery = "INSERT INTO new_user_data " +
                "(email, nick, pass, email_err_message, nick_err_message, pass_err_message) " +
                "VALUES ('" + email + "', '" + nick +"', '" + pass + "', '"
                           + emailErrMessage + "', '" + nickErrMessage + "', '" + passErrMessage + "')";
        try {
            Connection connection = getConnection();
            connection.createStatement()
                      .executeUpdate(insertRowSQLQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return true;
    }

    public Iterator<Object[]> getAllNewUserData() {
        Connection connection = null;
        Statement statement = null;
        String[] columns = new String[6];
        ArrayList<Object[]> rows = new ArrayList<>();
        String selectUserDataSQLQuery = "SELECT email, nick, pass, " +
                 "email_err_message, nick_err_message, pass_err_message" +
                " from new_user_data";
        try {
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectUserDataSQLQuery);
            while (rs.next()) {
                for (int i = 1; i <= 6; i++) {
                    columns[i - 1] = rs.getString(i);
                }
                rows.add(columns);
            }
            for (Object[] row: rows) {
                for (Object column: row) {
                    System.out.println(column + "/");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rows.iterator();
    }
}
