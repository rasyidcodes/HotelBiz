package pages.guest.orderFood;

import config.DatabaseConnector;
import pages.auth.Guest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuProvider implements OrderService {

    @Override
    public List<Menu> getAllDishes() {
        List<Menu> dishes = new ArrayList<>();
        try {
            DatabaseConnector connect=new DatabaseConnector();
            Connection conn=connect.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM restaurant where Type='MEAL' ORDER BY itemName ASC");
            while (resultSet.next()) {
                int itemNo = resultSet.getInt("itemNo");
                String itemName = resultSet.getString("itemName");
                int price = resultSet.getInt("Price");
                String Type = resultSet.getString("Type");
                // Retrieve other properties as needed

                Meal dish = new Meal(itemNo, itemName, price, Type);
                // Set other properties on the dish object as needed

                dishes.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dishes;
    }

    @Override
    public List<Menu> getAllDrink() {
        List<Menu> drinks = new ArrayList<>();
        try {
            DatabaseConnector connect=new DatabaseConnector();
            Connection conn=connect.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM restaurant where Type='DRINK' ORDER BY itemName ASC");
            while (resultSet.next()) {
                int itemNo = resultSet.getInt("itemNo");
                String itemName = resultSet.getString("itemName");
                int price = resultSet.getInt("Price");
                String Type = resultSet.getString("Type");
                // Retrieve other properties as needed

                Drink drink = new Drink(itemNo, itemName, price, Type);
                // Set other properties on the dish object as needed
                drinks.add(drink);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drinks;
    }

    @Override
    public DefaultTableModel fillMeal() {

        DatabaseConnector connect = new DatabaseConnector();
        Connection conn = connect.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("MEAL NAME");
        model.addColumn("PRICE");

        try{
            String query = "SELECT * FROM restaurant where Type='MEAL'";
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery(query);
            while(rs.next())
            {
                model.addRow(new Object[] {
                        rs.getString("itemName"),
                        rs.getString("Price"),
                });
            }

            System.out.println("jml +" + model.getColumnCount());
            return model;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public DefaultTableModel fillDrink() {
        DatabaseConnector connect = new DatabaseConnector();
        Connection conn = connect.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("MEAL NAME");
        model.addColumn("PRICE");

        try{
            String query = "SELECT * FROM restaurant where Type='DRINK'";
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery(query);
            while(rs.next())
            {
                model.addRow(new Object[] {
                        rs.getString("itemName"),
                        rs.getString("Price"),
                });
            }

            System.out.println("jml +" + model.getColumnCount());
            return model;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean checkoutMenu(String custName, String custAddr, int phone, String meal, String drink, int Price, String description, int status) {

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            DatabaseConnector connect = new DatabaseConnector();
            Connection conn = connect.getConnection();

            String sql = "INSERT INTO reservationMenu (custName, custAddr, Phone, Meal, Drink, Price, description, status) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, custName);
            statement.setString(2, custAddr);
            statement.setInt(3, phone);
            statement.setString(4, meal);
            statement.setString(5, drink);
            statement.setInt(6, Price);
            statement.setString(7, description);
            statement.setInt(8, status);

            int insertCon = statement.executeUpdate();
            if (insertCon > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("err" + e.getMessage());
        }

        return false;
    }


}
