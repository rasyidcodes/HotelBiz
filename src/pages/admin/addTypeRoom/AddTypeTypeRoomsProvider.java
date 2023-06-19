package pages.admin.addTypeRoom;

import config.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AddTypeTypeRoomsProvider implements AddTypeRoomsInterface {

    @Override
    public List<String> getRoomTypes() throws SQLException {
        List<String> roomTypes = new ArrayList<>();
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection conn = databaseConnector.getConnection();

        try {
            String query = "SELECT DISTINCT roomName FROM roomtype";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                roomTypes.add(rs.getString("roomName"));
            }

            rs.close();
            st.close();
        } finally {
            conn.close();
        }

        return roomTypes;
    }

    @Override
    public List<String> getBedTypes() throws SQLException {
        List<String> bedTypes = new ArrayList<>();
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection conn = databaseConnector.getConnection();

        try {
            String query = "SELECT DISTINCT bedType FROM roomtype";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                bedTypes.add(rs.getString("bedType"));
            }

            rs.close();
            st.close();
        } finally {
            conn.close();
        }

        return bedTypes;
    }



    @Override
    public Vector<Vector<Object>> getAllRooms() throws SQLException {
        Vector<Vector<Object>> rooms = new Vector<>();
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection conn = databaseConnector.getConnection();

        try {
            String query = "SELECT * FROM roomtype";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Vector<Object> room = new Vector<>();
                room.add(rs.getString("roomtype_id"));
                room.add(rs.getString("roomName"));
                room.add(rs.getString("bedType"));
                room.add(rs.getString("Price"));
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
    public void addRooms(String roomNumber, String roomType, String bedType, String price) throws SQLException {
        PreparedStatement ps = null;

        try {
            DatabaseConnector databaseConnector = new DatabaseConnector();
            Connection conn = databaseConnector.getConnection();
            ps = conn.prepareStatement("INSERT INTO roomtype(roomtype_id,roomName,bedType,Price) VALUES (?,?,?,?)");
            ps.setString(1, roomNumber);
            ps.setString(2, roomType);
            ps.setString(3, bedType);
            ps.setString(4, price);

            if (ps.executeUpdate() > 0) {
                System.out.println("New Room Added");
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Override
    public void updateRooms(String roomNumber, String roomType, String bedType, String price, String roomTypeId) throws SQLException {
        PreparedStatement ps = null;
        System.out.println("updateee");
        try {
            DatabaseConnector databaseConnector = new DatabaseConnector();
            Connection conn = databaseConnector.getConnection();
            ps = conn.prepareStatement("UPDATE roomtype SET roomtype_id=?, roomName=?, bedType=?, price=? WHERE roomtype_id=?");
            ps.setString(1, roomNumber);
            ps.setString(2, roomType);
            ps.setString(3, bedType);
            ps.setString(4, price);
            ps.setString(5, roomTypeId);

            if (ps.executeUpdate() > 0) {
                System.out.println("Room Updated");
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Override
    public void deleteRooms(String roomNumber) throws SQLException {
        PreparedStatement ps = null;

        try {
            DatabaseConnector databaseConnector = new DatabaseConnector();
            Connection conn = databaseConnector.getConnection();
            ps = conn.prepareStatement("DELETE FROM roomtype WHERE roomtype_id=?");
            ps.setString(1, roomNumber);

            if (ps.executeUpdate() > 0) {
                System.out.println("Room Deleted");
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
}
