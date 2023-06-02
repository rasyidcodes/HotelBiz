package pages.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DatabaseConnector;

public class RoomDeluxe extends RoomPremium {

      // megacu pada tabel DuluxeRoom 
      private boolean inRoomBreakfastService;
      private boolean laundry; 
      private boolean dailyHouseKeeping;
      private boolean privateSwimming; 
      private boolean luxuryBathub; 

      @Override
      public void retrieveDataFromDB(int roomNumber) {
            DatabaseConnector databaseConnector = new DatabaseConnector();
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
        
            try {
                  connection = databaseConnector.getConnection(); // Get the database connection
                  String sql = "SELECT * FROM roomtype where roomtype_id = 1"; 
                  statement = connection.prepareStatement(sql);
                  resultSet = statement.executeQuery();
                  if (resultSet.next()){
                        setRoomName( resultSet.getString("roomName"));
                        setBedType(resultSet.getString("bedType"));
                        setPrice(resultSet.getDouble("price"));
                  }

                  statement.close();
                  resultSet.close();

                  String sql2 = "SELECT * FROM deluxeroom where roomNumber = " + roomNumber ; 
                  statement = connection.prepareStatement(sql2); 
                  resultSet = statement.executeQuery();
                  if (resultSet.next()){
                        setId(resultSet.getInt("id"));
                        setRoomTypeId(resultSet.getInt("roomtype_id"));
                        setRoomNumber(resultSet.getInt("roomNumber"));
                        setAvailability(resultSet.getBoolean("availability"));
                        setFreeSnack(resultSet.getBoolean("freeSnack"));
                        setWifi(resultSet.getBoolean("wifi"));
                        setTelevision(resultSet.getBoolean("television"));
                        setFitnessCenter(resultSet.getBoolean("fitnessCenter"));
                        setMinibar(resultSet.getBoolean("minibar"));
                        this.inRoomBreakfastService = resultSet.getBoolean("inRoomBreakfastService");
                        this.laundry = resultSet.getBoolean("laundry"); 
                        this.dailyHouseKeeping = resultSet.getBoolean("dailyHouseKeeping"); 
                        this.privateSwimming = resultSet.getBoolean("privateSwimming"); 
                        this.luxuryBathub = resultSet.getBoolean("luxuryBathub");
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
            System.out.println("Room Name : " + getRoomName());
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

            System.out.println("In Room Breakfast Service : " + isInRoomBreakfastService());
            System.out.println("Laundry : " + isLaundry());
            System.out.println("Daily House Keeping Service : " + isDailyHouseKeeping());
            System.out.println("Private Swimming : " + isPrivateSwimming());
            System.out.println("Luxry Bathub : " + isLuxuryBathub());
      }


      public boolean isInRoomBreakfastService() {
            return inRoomBreakfastService;
      }


      public void setInRoomBreakfastService(boolean inRoomBreakfastService) {
            this.inRoomBreakfastService = inRoomBreakfastService;
      }


      public boolean isLaundry() {
            return laundry;
      }


      public void setLaundry(boolean laundry) {
            this.laundry = laundry;
      }


      public boolean isDailyHouseKeeping() {
            return dailyHouseKeeping;
      }


      public void setDailyHouseKeeping(boolean dailyHouseKeeping) {
            this.dailyHouseKeeping = dailyHouseKeeping;
      }


      public boolean isPrivateSwimming() {
            return privateSwimming;
      }


      public void setPrivateSwimming(boolean privateSwimming) {
            this.privateSwimming = privateSwimming;
      }


      public boolean isLuxuryBathub() {
            return luxuryBathub;
      }


      public void setLuxuryBathub(boolean luxuryBathub) {
            this.luxuryBathub = luxuryBathub;
      }


      
}
