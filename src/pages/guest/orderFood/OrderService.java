package pages.guest.orderFood;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.List;

public interface OrderService {
    List<Menu> getAllDishes();
    List<Menu> getAllDrink();

    DefaultTableModel fillMeal();

    DefaultTableModel fillDrink();

    boolean checkoutMenu(String custName, String custAddr, int phone, String meal, String drink, int Price, String description,int status);
}
