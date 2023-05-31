package auth;

import config.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class GuestAuthProvider implements AuthProvider {
    private DatabaseConnector databaseConnector;

    public GuestAuthProvider(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public User authenticate(String username, String password) {
        // Implement your authentication logic here for the guest
        // For example, check against a database or a predefined list of credentials
        // You can replace this with your own authentication mechanism

        // Create an instance of the User class
        Guest guest = null;

        // Establish a database connection
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = databaseConnector.getConnection(); // Get the database connection

            // Prepare the SQL statement to retrieve the user object
            String sql = "SELECT * FROM guest WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute the query
            resultSet = statement.executeQuery();

            // Check if the user exists in the database
            if (resultSet.next()) {
                // Retrieve user attributes from the result set
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String fullName = resultSet.getString("fullName");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String gender = resultSet.getString("gender");
                String NIK = resultSet.getString("NIK");
                String address = resultSet.getString("address");
                int age = resultSet.getInt("age");
                String phoneNumber = resultSet.getString("phoneNumber");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                String guestType = resultSet.getString("guestType");

                // Create a User object
                guest = new Guest(id, username,password,email, fullName, dateOfBirth, gender, NIK, address, age, phoneNumber,
                        country, city, guestType);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            databaseConnector.closeResources(resultSet, statement, connection);
        }

        return guest; // Return the user object if authentication succeeds, otherwise null
    }
}