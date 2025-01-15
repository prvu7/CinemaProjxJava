package org.example.dataBase;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.*;

public class CinemaDB {

    //connectivity db tools
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet resultSet = null;

    public CinemaDB() {
        Credentials credentials = loadCredentials();
        String url = credentials.getUrl();
        String user = credentials.getUser();
        String password = credentials.getPassword();

        try {
            conn = DriverManager.getConnection(url, user, password);
            //System.out.println("Connected to database successfully.");
        } catch (SQLException e) {
            System.err.println("Error connection: " + e.getMessage());
        }
    }
    private Credentials loadCredentials() {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("src/main/resources/credentials.json");

        try {
            return objectMapper.readValue(jsonFile, Credentials.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed: " + e.getMessage());
        }
    }
    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public void executeSelectMovies(String query, ArrayList<Movies> movies) {
        try {
            if(!movies.isEmpty()) {
                return;
            }
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
            while(resultSet.next()) {
                int idMovie = resultSet.getInt("id_film");
                String title = resultSet.getString("titlu");
                String genre = resultSet.getString("gen");
                int duration = resultSet.getInt("durata");

                Movies movie = new Movies(idMovie, title, genre, duration);
                movies.add(movie);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void executeInsertCustomers(String query, Customers customer) {
        try {
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, customer.GetName());
            pstmt.setInt(2, customer.GetAge());
            pstmt.setString(3, customer.GetPhoneNumber());

            pstmt.executeUpdate();
            System.out.println("\n~Your data has been saved successfully!~\n");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void executeRestartCustomers() {
        try {
            stmt = conn.createStatement();
            String query = "DELETE FROM clienti";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
