package pages.hotel;

import java.util.List;

public interface HotelService {

      public List<Room> showRoomType();
      public List<Room> getRoomAvailable(int roomType); 
      public Room getSpecificRoomType(int roomType);
      public Room roomDetails(int roomType, int roomNO);
 
}
