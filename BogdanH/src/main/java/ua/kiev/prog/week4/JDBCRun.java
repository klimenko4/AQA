package ua.kiev.prog.week4;

import ua.kiev.prog.week4.entity.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBCRun {


    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    private static final String QUERY = "select * from movies";

    public static void main(String[] args) {


        List<Movie> movies = new ArrayList<>();

        Statement statement = null;
        Connection connection = null;

        try {
            // STEP 1 - create the connection to your DB
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            //STEP 2 - execute the query
            statement = connection.createStatement();

            //STEP 3 - extract the result from the result set
            ResultSet resultSet = statement.executeQuery(QUERY);

            while (resultSet.next()) {
                int mID = resultSet.getInt("mID");
                String title = resultSet.getString("title");

                System.out.println("mID:" + mID + "title" + title);
                movies.add(new Movie(mID, title));
            }

        } catch (SQLException e) {
            System.err.print(e.getMessage());
        } finally {
            //finally block used to close resources
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                System.err.print(e.getMessage());
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println(movies);
        System.out.println(movies.size());
    }
}

