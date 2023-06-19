package pages.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseConnector;

public class HotelProvider implements HotelService {

    @Override
    public List<Room> getRoomAvailable(int roomType) {
        List<Room> rooms = new ArrayList<>();
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = null;

        switch (roomType) {
        case 3:
            try {
                connection = databaseConnector.getConnection(); // Get the database connectioN
                sql = "SELECT * FROM deluxeroom where availability = 1";  
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();   

                while(resultSet.next()){
                    int roomNumber = resultSet.getInt("roomNumber"); 
                    RoomDeluxe obj = new RoomDeluxe(roomType, null, null, null, 0, roomNumber, "Available", null, null, null, null, null, null, null, null, null, null);

                    rooms.add(obj);
                }
            } catch (Exception e) {
                 e.printStackTrace();
            } finally {
                databaseConnector.closeResources(resultSet, statement, connection);
            }
            break;


        case 2:
            try {
                connection = databaseConnector.getConnection(); // Get the database connectioN
                sql = "SELECT * FROM premiumroom where availability = 1";  
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();   

                while(resultSet.next()){
                    int roomNumber = resultSet.getInt("roomNumber"); 
                    RoomPremium obj = new RoomPremium(roomType, null, null, null, 0, roomNumber, "Available", null, null, null, null, null) ;
                    
                    rooms.add(obj);
                }
            } catch (Exception e) {
                 e.printStackTrace();
            } finally {
                databaseConnector.closeResources(resultSet, statement, connection);
            }
            break;


        case 1:
            try {
                connection = databaseConnector.getConnection(); // Get the database connectioN
                sql = "SELECT * FROM standardroom where availability = 1";  
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();   

                while(resultSet.next()){
                    int roomNumber = resultSet.getInt("roomNumber"); 
                    RoomStandard obj= new RoomStandard(roomType, null, null, null, 0, roomNumber, "Available", null, null);
                    rooms.add(obj);
                }
            } catch (Exception e) {
                 e.printStackTrace();
            } finally {
                databaseConnector.closeResources(resultSet, statement, connection);
            }
            break;
    }
        return rooms;
    }


    // Show info of all room types
    @Override
    public List<Room> showRoomType() {
        List<Room> rooms = new ArrayList<>();

        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = null;

        try {
            connection = databaseConnector.getConnection(); // Get the database connectioN
            sql = "SELECT * FROM roomType";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int roomt = resultSet.getInt("roomtype_id"); 
                String roomnm = resultSet.getString(("roomName"));
                String bedT = resultSet.getString("bedType"); 
                Double price = resultSet.getDouble("price");

                RoomType a = new RoomType(roomt, roomnm, bedT, price);
                rooms.add(a); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            databaseConnector.closeResources(resultSet, statement, connection);
        }
        return rooms;
    }


    @Override
    public boolean updateRoomAvailability(int roomType, int roomNumber, boolean Availability){

        PreparedStatement statement = null;
        String roomName = null; 

            switch (roomType) {
        case 1:
            roomName = "standaRdroom";
            break;
        case 2:
            roomName = "premiumRoom";
            break;
        case 3:
            roomName = "deluxeRoom";
            break;
        }

        // tipe 3 = deluxe, database roomType_id = 3
        // tipe 2 = premium, database roomType_id = 2
        // tipe 1 = standard, database roomType_id = 1

        // 1 -> Available 
        // 0 -> Not Available 

            try {

            DatabaseConnector connect = new DatabaseConnector();
            Connection conn = connect.getConnection();

            String sql = "UPDATE " + roomName + " SET availability = " + Availability + " WHERE roomNumber = " + roomNumber;

            // String sql = "UPDATE " + roomName + " SET availability = ? WHERE roomNumber = ?";
            // statement = conn.prepareStatement(sql);
            // statement.setBoolean(1, Availability);
            // statement.setInt(2, roomNumber);

            statement = conn.prepareStatement(sql);
            int insertCon = statement.executeUpdate();

            if (insertCon > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("err" + e.getMessage());
        }
        return false;
    }

    

    @Override
    public boolean placeRoomOrder(int userid, int roomType, int roomNumber, int days) {
        PreparedStatement statement = null;
        // Mendapatkan tanggal saat ini
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        try {

            DatabaseConnector connect = new DatabaseConnector();
            Connection conn = connect.getConnection();

            String sql = "INSERT INTO roomorders (userID, roomTypeID, roomNumber, days, orderDate) VALUES ('" + userid + "', '" + roomType + "', '" + roomNumber + "', '" + days + "', '" + sqlDate + "')";
            statement = conn.prepareStatement(sql);
            // String sql = "INSERT INTO roomorders (userID, roomTypeID, roomNumber, days, orderDate) VALUES (?, ?, ?, ?, ?)";
            // statement = conn.prepareStatement(sql);
            // // statement.setInt(1, null);
            // statement.setInt(2, userid);
            // statement.setInt(3, roomType);
            // statement.setInt(4, roomNumber);
            // statement.setInt(5, days);
            // statement.setDate(6, sqlDate);
            int insertCon = statement.executeUpdate();
            if (insertCon > 0) {
                if(updateRoomAvailability(roomType, roomNumber, false)){
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("err" + e.getMessage());
        }
        return false;
    }


    // =====================================================
    // specific room details based on room number
    @Override
    public Room roomDetails(int roomType, int roomNO){

        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = null;

        Room obj = null;

        String roomName;
        Double price; 
        String bedType;
        int roomType_id;

        int id; 
        int roomNumber = roomNO; // nomor kamar 
        String availability;
        String freeSnack; 
        String wifi;
        String television; 
        String fitnessCenter; 
        String minibar;
        String inRoomBreakfastService;
        String laundry; 
        String dailyHouseKeeping;
        String privateSwimming; 
        String luxuryBathub;

        // tipe 3 = deluxe, database roomType_id = 3
        // tipe 2 = premium, database roomType_id = 2
        // tipe 1 = standard, database roomType_id = 1

        switch (roomType) {
            case 3:
                try {
                    connection = databaseConnector.getConnection(); // Get the database connectioN

                    sql = "SELECT * FROM deluxeroom WHERE roomNumber = " + roomNO ;  
                    statement = connection.prepareStatement(sql);
                    resultSet = statement.executeQuery();       
                               

                    if(resultSet.next()){

                        id = resultSet.getInt("id");
                        availability = resultSet.getBoolean("availability") ? "Available" : "Not Available";
                        freeSnack = resultSet.getBoolean("freeSnack") ? "Yes" : "No";
                        television = resultSet.getBoolean("television") ? "Yes" : "No";
                        wifi = resultSet.getBoolean("wifi") ? "Yes" : "No";
                        minibar = resultSet.getBoolean("minibar") ? "Yes" : "No";
                        fitnessCenter = resultSet.getBoolean("fitnessCenter") ? "Yes" : "No";
                        laundry = resultSet.getBoolean("laundry") ? "Yes" : "No";
                        inRoomBreakfastService = resultSet.getBoolean("inRoomBreakfastService") ? "Yes" : "No";
                        privateSwimming = resultSet.getBoolean("privateSwimming") ? "Yes" : "No";
                        dailyHouseKeeping = resultSet.getBoolean("dailyHouseKeeping") ? "Yes" : "No";
                        luxuryBathub = resultSet.getBoolean("luxuryBathub") ? "Yes" : "No";

                        obj = new RoomDeluxe(0, null, null, null, id, roomNumber, availability, freeSnack, wifi, television, fitnessCenter, minibar, inRoomBreakfastService, laundry, dailyHouseKeeping, privateSwimming, luxuryBathub);
                    }

                    statement.close();
                    resultSet.close();
                    
                    sql = "SELECT * FROM roomType where roomtype_id = 3"; 
                    statement = connection.prepareStatement(sql);
                    resultSet = statement.executeQuery();  

                    if(resultSet.next()){
                        roomType_id = resultSet.getInt("roomType_id");
                        roomName = resultSet.getString("roomName"); 
                        bedType = resultSet.getString("bedType"); 
                        price = resultSet.getDouble("price"); 

                        obj.setRoomTypeId(roomType_id);
                        obj.setRoomName(roomName);
                        obj.setBedType(bedType);
                        obj.setPrice(price);
                    }
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        databaseConnector.closeResources(resultSet, statement, connection);
                }
                break;


            case 2:
                try {
                    connection = databaseConnector.getConnection(); // Get the database connectio

                    sql = "SELECT * FROM premiumroom WHERE roomNumber = " + roomNO ;  
                    statement = connection.prepareStatement(sql);
                    resultSet = statement.executeQuery();       
                               
                    if(resultSet.next()){

                        id = resultSet.getInt("id");
                        availability = resultSet.getBoolean("availability") ? "Available" : "Not Available";
                        freeSnack = resultSet.getBoolean("freeSnack") ? "Yes" : "No";
                        television = resultSet.getBoolean("television") ? "Yes" : "No";
                        wifi = resultSet.getBoolean("wifi") ? "Yes" : "No";
                        minibar = resultSet.getBoolean("minibar") ? "Yes" : "No";
                        fitnessCenter = resultSet.getBoolean("fitnessCenter") ? "Yes" : "No";
                
                        obj = new RoomPremium(0, null, null, null, id, roomNumber, availability, freeSnack, wifi, television, fitnessCenter, minibar);

                    }

                    statement.close();
                    resultSet.close();
                    
                    sql = "SELECT * FROM roomType where roomtype_id = 2"; 
                    statement = connection.prepareStatement(sql);
                    resultSet = statement.executeQuery();  

                    if(resultSet.next()){
                        roomName = resultSet.getString("roomName"); 
                        price = resultSet.getDouble("price"); 
                        bedType = resultSet.getString("bedType"); 
                        roomType_id = resultSet.getInt("roomType_id");

                        obj.setBedType(bedType);
                        obj.setPrice(price);
                        obj.setRoomName(roomName);
                        obj.setRoomTypeId(roomType_id);
                    }

                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        databaseConnector.closeResources(resultSet, statement, connection);
                }

                break;


            case 1:
               try {
                    connection = databaseConnector.getConnection(); // Get the database connectio

                    sql = "SELECT * FROM standardroom WHERE roomNumber = " + roomNO ;  
                    statement = connection.prepareStatement(sql);
                    resultSet = statement.executeQuery();       
                               
                    if(resultSet.next()){
                        id = resultSet.getInt("id");
                        availability = resultSet.getBoolean("availability") ? "Available" : "Not Available";
                        freeSnack = resultSet.getBoolean("freeSnack") ? "Yes" : "No";
                        wifi = resultSet.getBoolean("wifi") ? "Yes" : "No";

                        obj = new RoomStandard(0, null, null, null, id, roomNumber, availability, freeSnack, wifi);
                    }
                    statement.close();
                    resultSet.close();
                    
                    sql = "SELECT * FROM roomType where roomtype_id = 1"; 
                    statement = connection.prepareStatement(sql);
                    resultSet = statement.executeQuery();  

                    if(resultSet.next()){
                        roomName = resultSet.getString("roomName"); 
                        price = resultSet.getDouble("price"); 
                        bedType = resultSet.getString("bedType"); 
                        roomType_id = resultSet.getInt("roomType_id");

                        obj.setRoomName(roomName);
                        obj.setBedType(bedType);
                        obj.setPrice(price);
                        obj.setRoomTypeId(roomType_id);
                    }

                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        databaseConnector.closeResources(resultSet, statement, connection);
                }
                break;
        }
        return (Room)obj; 
    }

    
    // specific room details based on room type
    @Override
    public Room getSpecificRoomType(int roomType) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = null;

        Room obj = null; 


        sql = "SELECT * FROM roomType where roomtype_id = " + roomType; 
        try {
            
            connection = databaseConnector.getConnection(); // Get the database connectio
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            if(resultSet.next()){
                double price = resultSet.getDouble("price"); 
                String name = resultSet.getString("roomName");
                String bed = resultSet.getString("bedType");
                obj = new RoomType(roomType, name, bed, price);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnector.closeResources(resultSet, statement, connection);
        }
        return (Room)obj;
    }


}

      

