package pages.auth;

import config.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeAuthProvider implements  AuthProvider{

    private DatabaseConnector databaseConnector;

    public EmployeeAuthProvider(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public User authenticate(String username, String password) {
        Employee employee = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = databaseConnector.getConnection(); // Get the database connection

            // Prepare the SQL statement to retrieve the user object
            String sql = "SELECT * FROM employee WHERE username = ? AND password = ?";
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
                employee = new Employee(id, username,password,email, fullName, dateOfBirth, gender, salary, accessLevel);

            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            databaseConnector.closeResources(resultSet, statement, connection);
        }

        return employee;
    }


    public User signupEmployee(String username, char[] password, String email, String fullName, String dateOfBirth, String gender, int salary, int role) {
        Employee employee = null;

        // Establish a database connection
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        System.out.println("Override implementation of method2");
        try {
            connection = databaseConnector.getConnection(); // Get the database connection

            String sql = "INSERT INTO employee (username, password, email, fullName, dateOfBirth, gender, salary, accessLevel) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, String.valueOf(password));
            statement.setString(3, email);
            statement.setString(4, fullName);
            statement.setString(5, dateOfBirth);
            statement.setString(6, gender);
            statement.setInt(7, salary);
            statement.setInt(8, role);


            int insertCon = statement.executeUpdate();
            if (insertCon > 0){
                employee = (Employee) authenticate(username,String.valueOf(password));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            databaseConnector.closeResources(resultSet, statement, connection);
        }

        return employee; // Return the user object if authentication succeeds, otherwise null
    }
}
