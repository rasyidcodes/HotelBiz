package pages.admin.addTypeRoom;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public interface AddTypeRoomsInterface {
    Vector<Vector<Object>> getAllRooms() throws SQLException;
    void addRooms(String roomNumber, String roomType, String bedType, String price) throws SQLException;
    void updateRooms(String roomNumber, String roomType, String bedType, String price, String roomTypeId) throws SQLException;
    void deleteRooms(String roomNumber) throws SQLException;
    List<String> getRoomTypes() throws SQLException;
    List<String> getBedTypes() throws SQLException;

}
