package pages.guest.orderFood;

public class Drink extends Menu{

    String ice = "";
    String sugar = "";

    public Drink(int itemNo, String itemName, int price, String type) {
        super(itemNo, itemName, price, type);
    }

    @Override
    public int hitungTotal(int jumlah) {
        return jumlah * getPrice();
    }

    @Override
    public String getDescription() {
//        System.out.println("ice : " + ice + " sugar : " + sugar);

        return "ice : " + ice + " sugar : " + sugar;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }
}
