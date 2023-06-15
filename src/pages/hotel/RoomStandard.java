package pages.hotel;



public class RoomStandard extends Room{

      private int id; // id kamar mengacu pada database standardroom

      private int roomNumber; // nomor kamar 
      private String availability;

      private String freeSnack; 
      private String wifi;

      @Override
      public String getDescription() {
      return 
             "roomNumber       : " + roomNumber + ",\n"
            + "availability           : " + availability + ",\n"
            + "freeSnack           : " + freeSnack + ",\n"
            + "wifi                      : " + wifi + "\n";
      }


      public RoomStandard(int roomTypeId, String roomName, String bedType, Double price,int id, int roomNumber,
                  String availability, String freeSnack, String wifi) {
            super(roomTypeId, roomName, bedType, price);
            this.id = id; 
            this.roomNumber = roomNumber;
            this.availability = availability;
            this.freeSnack = freeSnack;
            this.wifi = wifi;
      }

      
      public int getId() {
            return id;
      }


      public void setId(int id) {
            this.id = id;
      }


      public int getRoomNumber() {
            return roomNumber;
      }


      public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
      }


      public String getAvailability() {
            return availability;
      }


      public void setAvailability(String availability) {
            this.availability = availability;
      }


      public String getFreeSnack() {
            return freeSnack;
      }


      public void setFreeSnack(String freeSnack) {
            this.freeSnack = freeSnack;
      }


      public String getWifi() {
            return wifi;
      }


      public void setWifi(String wifi) {
            this.wifi = wifi;
      }

}

