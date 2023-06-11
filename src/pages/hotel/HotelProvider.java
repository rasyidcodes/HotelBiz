package pages.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DatabaseConnector;

public class Hotel implements HotelInterface {

      // Show preview 
      public void showRoom() {}


      // check availability
      public boolean roomAvailability(int roomtype, int roomNumber) {
            // parameter roomType -> tipe 1 duluxe 2 premiun 3 standard 
            // parameter roomNumber -> nomor kamar 
            DatabaseConnector databaseConnector = new DatabaseConnector();
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            String sql = null;
            boolean isAvail = false;
        
            try {
                connection = databaseConnector.getConnection(); // Get the database connection
                switch (roomtype) {
                    case 1:
                        sql = "SELECT availability FROM deluxeRoom where roomumber = " + roomNumber;
                        break;
                    case 2:
                        sql = "SELECT availability FROM premiumRoom where roomumber = " + roomNumber;
                        break;
                    case 3:
                        sql = "SELECT availability FROM standardroom where roomNumber = " + roomNumber;
                        break;
                }
        
                // Prepare the SQL statement to retrieve the user object
                statement = connection.prepareStatement(sql);
                // Execute the query
                resultSet = statement.executeQuery();
                  if (resultSet.next()){
                        isAvail = resultSet.getBoolean("availability");
                  }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close the database resources
                databaseConnector.closeResources(resultSet, statement, connection);
            }
            return isAvail;
        }

        

        


}

      

