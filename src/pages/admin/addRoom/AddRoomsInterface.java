package pages.admin.addRoom;

import java.sql.SQLException;
import java.util.Vector;

public interface AddRoomsInterface {

    Vector<Vector<Object>> getAllRooms() throws SQLException;

    boolean addRooms(int roomNumber, String roomtypeSelected);
    boolean updateRooms(int roomNumber, int avail);
}
