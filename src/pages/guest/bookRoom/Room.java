package pages.guest.bookRoom;




public abstract class Room {

    private int roomTypeId; // tipe room mengacu pada database roomType
    private String roomName; // either deluxe, premium, standard
    private String bedType;
    private Double price;

    // constructor
    public Room(int roomTypeId, String roomName, String bedType, Double price) {
        this.roomTypeId = roomTypeId;
        this.roomName = roomName;
        this.bedType = bedType;
        this.price = price;
    }

    // abstract method
    public abstract String getDescription();


    public double hitungHarga(double hari){
        return hari*getPrice();
    };


    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }






}
