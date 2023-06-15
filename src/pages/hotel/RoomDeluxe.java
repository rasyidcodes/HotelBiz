package pages.hotel;


public class RoomDeluxe extends Room {
      
      private int id; // id kamar mengacu pada database deluxeroom
      
      private int roomNumber; // nomor kamar 
      private String availability;

      private String freeSnack; 
      private String wifi;

      private String television; 
      private String fitnessCenter; 
      private String minibar;

      private String inRoomBreakfastService;
      private String laundry; 
      private String dailyHouseKeeping;
      private String privateSwimming; 
      private String luxuryBathub;

      @Override
      public String getDescription() {
      return
            "roomNumber                        : " + roomNumber + ",\n"
            + "availability                             : " + availability + ",\n"
            + "freeSnack                             : " + freeSnack + ",\n"
            + "wifi                                        : " + wifi + ",\n"
            + "television                               : " + television + ",\n"
            + "fitnessCenter                         : " + fitnessCenter + ",\n"
            + "minibar                                  : " + minibar + ",\n"
            + "inRoomBreakfastService      : " + inRoomBreakfastService + ",\n"
            + "laundry                                  : " + laundry + ",\n"
            + "dailyHouseKeeping              : " + dailyHouseKeeping + ",\n"
            + "privateSwimming                   : " + privateSwimming + ",\n"
            + "luxuryBathub                        : " + luxuryBathub + "\n";
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

      public String getInRoomBreakfastService() {
            return inRoomBreakfastService;
      }

      public void setInRoomBreakfastService(String inRoomBreakfastService) {
            this.inRoomBreakfastService = inRoomBreakfastService;
      }

      public String getLaundry() {
            return laundry;
      }

      public void setLaundry(String laundry) {
            this.laundry = laundry;
      }

      public String getDailyHouseKeeping() {
            return dailyHouseKeeping;
      }

      public void setDailyHouseKeeping(String dailyHouseKeeping) {
            this.dailyHouseKeeping = dailyHouseKeeping;
      }

      public String getPrivateSwimming() {
            return privateSwimming;
      }

      public void setPrivateSwimming(String privateSwimming) {
            this.privateSwimming = privateSwimming;
      }

      public String getLuxuryBathub() {
            return luxuryBathub;
      }

      public void setLuxuryBathub(String luxuryBathub) {
            this.luxuryBathub = luxuryBathub;
      }

      public RoomDeluxe(int roomTypeId, String roomName, String bedType, Double price, int id, int roomNumber,
                  String availability, String freeSnack, String wifi, String television, String fitnessCenter,
                  String minibar, String inRoomBreakfastService, String laundry, String dailyHouseKeeping,
                  String privateSwimming, String luxuryBathub) {
                        
            super(roomTypeId, roomName, bedType, price);
            this.id = id;
            this.roomNumber = roomNumber;
            this.availability = availability;
            this.freeSnack = freeSnack;
            this.wifi = wifi;
            this.television = television;
            this.fitnessCenter = fitnessCenter;
            this.minibar = minibar;
            this.inRoomBreakfastService = inRoomBreakfastService;
            this.laundry = laundry;
            this.dailyHouseKeeping = dailyHouseKeeping;
            this.privateSwimming = privateSwimming;
            this.luxuryBathub = luxuryBathub;
      }
      


}
