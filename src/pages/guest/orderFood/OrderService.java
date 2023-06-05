package pages.guest.orderFood;

import java.util.List;

public interface OrderService {
    List<Menu> getAllDishes();
    List<Menu> getAllDrink();

    boolean checkoutMenu(String custName, String custAddr, int phone, String meal, String drink, int Price, String description,int status);
}
