package pages.admin.addRoom;

import config.DatabaseConnector;

import java.sql.*;
import java.util.Objects;
import java.util.Vector;

public class AddRoomProvider implements  AddRoomsInterface{
    @Override
    public Vector<Vector<Object>> getAllRooms() throws SQLException {
        Vector<Vector<Object>> rooms = new Vector<>();
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection conn = databaseConnector.getConnection();

        try {
            String query = "select standardroom.roomNumber, standardroom.availability, roomtype.roomName, roomtype.bedType from standardroom INNER JOIN roomtype ON standardroom.roomtype_id = roomtype.roomtype_id UNION select premiumroom.roomNumber,premiumroom.availability, roomtype.roomName, roomtype.bedType from premiumroom INNER JOIN roomtype ON premiumroom.roomtype_id = roomtype.roomtype_id UNION select deluxeroom.roomNumber,deluxeroom.availability,  roomtype.roomName, roomtype.bedType from deluxeroom INNER JOIN roomtype ON deluxeroom.roomtype_id = roomtype.roomtype_id";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Vector<Object> room = new Vector<>();
                room.add(rs.getString("roomNumber"));
                room.add(rs.getString("roomName"));
                room.add(rs.getString("bedType"));
                room.add(rs.getString("availability"));
                rooms.add(room);
            }

            rs.close();
            st.close();
        } finally {
            conn.close();
        }

        return rooms;
    }



    @Override
    public boolean updateRooms(int roomNumber, int avail) {

        if (roomNumber >100){
            PreparedStatement ps = null;
            try {
                DatabaseConnector databaseConnector = new DatabaseConnector();
                Connection conn = databaseConnector.getConnection();
                ps = conn.prepareStatement("UPDATE standardroom SET  availability=? WHERE roomNumber=?");
                ps.setInt(1, avail);
                ps.setInt(2, roomNumber);


                if (ps.executeUpdate() > 0) {
                    System.out.println("sukses update");
                    return  true;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        if (roomNumber > 200){

            PreparedStatement ps = null;
            try {
                DatabaseConnector databaseConnector = new DatabaseConnector();
                Connection conn = databaseConnector.getConnection();
                ps = conn.prepareStatement("UPDATE premiumroom SET  availability=? WHERE roomNumber=?");
                ps.setInt(1, avail);
                ps.setInt(2, roomNumber);


                if (ps.executeUpdate() > 0) {
                    System.out.println("sukses update");
                    return  true;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }


        }
        if (roomNumber > 300){

            PreparedStatement ps = null;
            try {
                DatabaseConnector databaseConnector = new DatabaseConnector();
                Connection conn = databaseConnector.getConnection();
                ps = conn.prepareStatement("UPDATE deluxeroom SET  availability=? WHERE roomNumber=?");
                ps.setInt(1, avail);
                ps.setInt(2, roomNumber);


                if (ps.executeUpdate() > 0) {
                    System.out.println("sukses update");
                    return  true;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

        return false;
    }

    @Override
    public boolean addRooms(int roomNumber, String roomtypeselected) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection conn = databaseConnector.getConnection();

        System.out.println(roomtypeselected);


        if (Objects.equals(roomtypeselected, "Standard Room")){
            System.out.println("ini standard");

                    PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement("INSERT INTO standardroom(roomtype_id,roomNumber,availability,freeSnack, wifi) VALUES (?,?,?,?,?)");
                ps.setInt(1, 1);
                ps.setInt(2, roomNumber);
                ps.setInt(3, 1);
                ps.setInt(4, 1);
                ps.setInt(5,1);

                if (ps.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return false;
        }
        if (Objects.equals(roomtypeselected, "Premium Room")){
            System.out.println("ini premium");

            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement("INSERT INTO premiumroom(roomtype_id,roomNumber,availability,freeSnack, wifi,television, fitnessCenter, minibar) VALUES (?,?,?,?,?,?,?,?)");
                ps.setInt(1, 2);
                ps.setInt(2, roomNumber);
                ps.setInt(3, 1);
                ps.setInt(4, 1);
                ps.setInt(5,1);
                ps.setInt(6,1);
                ps.setInt(7,1);
                ps.setInt(8,1);

                if (ps.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return false;

        }
        if (Objects.equals(roomtypeselected, "Deluxe Room")){
            System.out.println("Ini deluxe");

            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement("INSERT INTO deluxeroom(roomtype_id,roomNumber,availability,freeSnack, wifi,television, fitnessCenter, minibar, inRoomBreakfastService, laundry, dailyHouseKeeping, privateSwimming, luxuryBathub) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, 3);
                ps.setInt(2, roomNumber);
                ps.setInt(3, 1);
                ps.setInt(4, 1);
                ps.setInt(5,1);
                ps.setInt(6,1);
                ps.setInt(7,1);
                ps.setInt(8,1);
                ps.setInt(9,1);
                ps.setInt(10,1);
                ps.setInt(11,1);
                ps.setInt(12,1);
                ps.setInt(13,1);

                if (ps.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return false;

        }
        return true;
//        PreparedStatement ps = null;
//        return true;

//        try {
//            ps = conn.prepareStatement("INSERT INTO roomtype(roomtype_id,roomName,bedType,Price) VALUES (?,?,?,?)");
////            ps.setString(1, roomNumber);
////            ps.setString(2, roomType);
////            ps.setString(3, bedType);
////            ps.setString(4, price);
//
//            if (ps.executeUpdate() > 0) {
//                return true;
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return false;
    }
}
