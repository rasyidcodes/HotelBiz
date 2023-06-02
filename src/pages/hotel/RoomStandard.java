package pages.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DatabaseConnector;

public class RoomStandard extends Room{

      // mengacu pada tabel standard room
      private int id; // primary key tabel standard room
      private int roomTypeId; // foreign key tabel standard room refer to id dari tabel roomType
      private int roomNumber; // nomor kamar 
      private boolean availability;
      private boolean freeSnack; 
      private boolean wifi;

      public RoomStandard() {
            super(3);
      }

      protected RoomStandard(int roomType) {
            super(roomType);
      }

      public void retrieveDataFromDB(int roomNumber) {
            DatabaseConnector databaseConnector = new DatabaseConnector();
            Connection connection = null;

            PreparedStatement statement = null;
            ResultSet resultSet = null;
        
            try {
                  connection = databaseConnector.getConnection(); // Get the database connection
                  String sql = "SELECT * FROM standardroom where roomNumber = " + roomNumber; 
                  statement = connection.prepareStatement(sql); 
                  resultSet = statement.executeQuery();
                  if (resultSet.next()){
                        this.id = resultSet.getInt("id"); 
                        this.roomTypeId = resultSet.getInt("roomtype_id"); 
                        this.roomNumber = resultSet.getInt("roomNumber"); 
                        this.availability = resultSet.getBoolean("availability"); 
                        this.freeSnack = resultSet.getBoolean("freeSnack");
                        this.wifi = resultSet.getBoolean("wifi"); 
                  } 
                  
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close the database resources
                databaseConnector.closeResources(resultSet, statement, connection);
            }
        }

      public void display(){
            System.out.println("Room Name : " + getRoomName());
            System.out.println("Bed Type : " + getBedType());
            System.out.println("Price : " + getPrice());

            System.out.println(getRoomName() + " Room Id : " + getId());
            System.out.println("Room Type : " + getRoomTypeId());
            System.out.println("Room Number : " + getRoomNumber());
            System.out.println("Room Availability : " +isAvailability());
            System.out.println("Snack : " + isFreeSnack());
            System.out.println("Wifi : " + isWifi());
      }


      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public int getRoomTypeId() {
            return roomTypeId;
      }

      public void setRoomTypeId(int roomTypeId) {
            this.roomTypeId = roomTypeId;
      }

      public int getRoomNumber() {
            return roomNumber;
      }

      public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
      }

      public boolean isAvailability() {
            return availability;
      }

      public void setAvailability(boolean availability) {
            this.availability = availability;
      }

      public boolean isFreeSnack() {
            return freeSnack;
      }

      public void setFreeSnack(boolean freeSnack) {
            this.freeSnack = freeSnack;
      }

      public boolean isWifi() {
            return wifi;
      }

      public void setWifi(boolean wifi) {
            this.wifi = wifi;
      }
      
}

