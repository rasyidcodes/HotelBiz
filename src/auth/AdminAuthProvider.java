package auth;

import config.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminAuthProvider  implements  AuthProvider{

    private DatabaseConnector databaseConnector;

    public AdminAuthProvider(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public User authenticate(String username, String password) {
        Admin admin = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = databaseConnector.getConnection(); // Get the database connection

            // Prepare the SQL statement to retrieve the user object
            String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute the query
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve user attributes from the result set
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String fullName = resultSet.getString("fullName");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                int accessLevel =  resultSet.getInt("accessLevel");

                // Create a User object
                admin = new Admin(id, username,password,email, fullName, dateOfBirth, gender, salary, accessLevel);

            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            databaseConnector.closeResources(resultSet, statement, connection);
        }

        return admin;
    }
}
