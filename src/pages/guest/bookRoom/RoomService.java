package pages.guest.bookRoom;

import java.util.List;

public interface RoomService {

    public List<Room> showRoomType();
    public List<Room> getRoomAvailable(int roomType);
    public Room getSpecificRoomType(int roomType);
    public Room roomDetails(int roomType, int roomNO);
    public boolean updateRoomAvailability(int roomType, int roomNumber, boolean Availability);
    public boolean placeRoomOrder(int userid, int roomType, int roomNumber, int days);

}