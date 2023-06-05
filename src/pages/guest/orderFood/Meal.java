package pages.guest.orderFood;

public class Meal extends Menu{

    String topping = "topping";
    int toppingHarga = 0;
    public Meal(int itemNo, String itemName, int price, String type) {
        super(itemNo, itemName, price, type);
    }

    @Override
    public int hitungTotal(int jumlah) {
        return (jumlah * getPrice()) + toppingHarga;
    }

    @Override
    public String getDescription() {
//        System.out.println("topping :" + topping + " harga :" + toppingHarga );
        return "topping :" + topping + " harga :" + toppingHarga;
    }

    public void setTopping(String topping) {
        if (topping == " Tidak ada"){
            toppingHarga = 0;
        }else if(topping == "Krupuk"){
            toppingHarga = 2000;
        }else if(topping == "Udang") {
            toppingHarga = 10000;
        }else if(topping == "Keju"){
            toppingHarga = 8000;
        }
        this.topping = topping;
    }

}
