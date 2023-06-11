package pages.hotel;



public class RoomPremium extends Room {

      private int id; // id kamar mengacu pada database premmiumroom

      private int roomNumber; // nomor kamar 
      private String availability;

      private String freeSnack; 
      private String wifi;
      
      private String television; 
      private String  fitnessCenter; 
      private String minibar;


      public RoomPremium(int roomTypeId, String roomName, String bedType, Double price, int id, int roomNumber,
                  String availability, String freeSnack, String wifi, String television, String fitnessCenter,
                  String minibar) {
            super(roomTypeId, roomName, bedType, price);
            this.id = id;
            this.roomNumber = roomNumber;
            this.availability = availability;
            this.freeSnack = freeSnack;
            this.wifi = wifi;
            this.television = television;
            this.fitnessCenter = fitnessCenter;
            this.minibar = minibar;
      }

      @Override
      public String getDescription() {
      return "RoomPremium [\n"
            + "id=" + id + ",\n"
            + "roomNumber=" + roomNumber + ",\n"
            + "availability=" + availability + ",\n"
            + "freeSnack=" + freeSnack + ",\n"
            + "wifi=" + wifi + ",\n"
            + "television=" + television + ",\n"
            + "fitnessCenter=" + fitnessCenter + ",\n"
            + "minibar=" + minibar + "\n"
            + "]";
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

      public String getTelevision() {
            return television;
      }

      public void setTelevision(String television) {
            this.television = television;
      }

      public String getFitnessCenter() {
            return fitnessCenter;
      }

      public void setFitnessCenter(String fitnessCenter) {
            this.fitnessCenter = fitnessCenter;
      }

      public String getMinibar() {
            return minibar;
      }

      public void setMinibar(String minibar) {
            this.minibar = minibar;
      }


}
