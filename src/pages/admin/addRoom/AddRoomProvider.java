package pages.admin.addRoom;

import config.DatabaseConnector;

import java.sql.*;
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

        PreparedStatement ps = null;
        return true;

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
