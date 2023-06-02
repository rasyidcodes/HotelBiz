package pages.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DatabaseConnector;

public class RoomPremium extends RoomStandard {
      
      // megacu pada tabel StandardRoom 
      private boolean television; 
      private boolean fitnessCenter; 
      private boolean minibar; 
      
      @Override
      public void retrieveDataFromDB(int roomNumber) {
            DatabaseConnector databaseConnector = new DatabaseConnector();
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
        
            try {
                  connection = databaseConnector.getConnection(); // Get the database connection
                  String sql = "SELECT * FROM roomtype where roomtype_id = 2"; 
                  statement = connection.prepareStatement(sql);
                  resultSet = statement.executeQuery();
                  if (resultSet.next()){
                        setRoomName( resultSet.getString("roomName"));
                        setBedType(resultSet.getString("bedType"));
                        setPrice(resultSet.getDouble("price"));
                  }

                  statement.close();
                  resultSet.close();

                  String sql2 = "SELECT * FROM premiumroom where roomNumber = " + roomNumber ; 
                  statement = connection.prepareStatement(sql2); 
                  resultSet = statement.executeQuery();
                  if (resultSet.next()){
                        setId(resultSet.getInt("id"));
                        setRoomTypeId(resultSet.getInt("roomtype_id"));
                        setRoomNumber(resultSet.getInt("roomNumber"));
                        setAvailability(resultSet.getBoolean("availability"));
                        setFreeSnack(resultSet.getBoolean("freeSnack"));
                        setWifi(resultSet.getBoolean("wifi"));
                        this.television = resultSet.getBoolean("television"); 
                        this.fitnessCenter = resultSet.getBoolean("fitnessCenter"); 
                        this.minibar = resultSet.getBoolean("minibar");
                  }
                  
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close the database resources
                databaseConnector.closeResources(resultSet, statement, connection);
            }
        }

        @Override
        public void display(){
            System.out.println("Room Name " + getRoomName());
            System.out.println("Bed Type : " + getBedType());
            System.out.println("Price : " + getPrice());
            
            System.out.println(getRoomName() + " Room Id : " + getId());
            System.out.println("Room Type : " + getRoomTypeId());
            System.out.println("Room Number : " + getRoomNumber());
            System.out.println("Room Availability : " +isAvailability());
            System.out.println("Snack : " + isFreeSnack());
            System.out.println("Wifi : " + isWifi());

            System.out.println("Telivision : " + isTelevision());
            System.out.println("Fitness Center : " + isFitnessCenter());
            System.out.println("Minibar : " + isMinibar());
      }


      public boolean isTelevision() {
            return television;
      }

      public void setTelevision(boolean television) {
            this.television = television;
      }

      public boolean isFitnessCenter() {
            return fitnessCenter;
      }

      public void setFitnessCenter(boolean fitnessCenter) {
            this.fitnessCenter = fitnessCenter;
      }

      public boolean isMinibar() {
            return minibar;
      }

      public void setMinibar(boolean minibar) {
            this.minibar = minibar;
      }




}
