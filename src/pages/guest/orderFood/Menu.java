package pages.guest.orderFood;

public abstract class Menu {

    private int itemNo;
    private String itemName;
    private int Price;
    private String Type;

    public Menu(int itemNo, String itemName, int price, String type) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        Price = price;
        Type = type;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public abstract int hitungTotal(int jumlah);

    public  abstract String getDescription();

    @Override
    public String toString() {
        return itemName;
    }
}
