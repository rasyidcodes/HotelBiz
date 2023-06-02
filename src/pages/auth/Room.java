package pages.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DatabaseConnector;

public class Room {
      // mengacu pada tabel roomType
      private String roomName; 
      private String bedType; 
      private Double price;

      // constructor
      Room(int roomtype){
            // parameter roomtype -> nilai roomtype_id pada tabel roomtype. duluxe 1. premium 2. standard 3. 
            DatabaseConnector databaseConnector = new DatabaseConnector();
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                  connection = databaseConnector.getConnection(); // Get the database connection
                  String sql = "SELECT * FROM roomtype where roomtype_id = " + roomtype;
                  statement = connection.prepareStatement(sql);
                  resultSet = statement.executeQuery();
                  if (resultSet.next()){
                        this.roomName = resultSet.getString("roomName");
                        this.bedType = resultSet.getString("bedType"); 
                        this.price = resultSet.getDouble("price"); 
                  }
                  
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close the database resources
                databaseConnector.closeResources(resultSet, statement, connection);
            }
        }

      public String getRoomName() {
            return roomName;
      }

      public void setRoomName(String roomName) {
            this.roomName = roomName;
      }

      public String getBedType() {
            return bedType;
      }

      public void setBedType(String bedType) {
            this.bedType = bedType;
      }

      public Double getPrice() {
            return price;
      }

      public void setPrice(Double price) {
            this.price = price;
      }

      
}
