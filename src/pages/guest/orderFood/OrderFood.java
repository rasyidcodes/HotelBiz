package pages.guest.orderFood;

import config.DatabaseConnector;
import config.MyException;
import pages.auth.Guest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class OrderFood extends JFrame{


    //combobox
    JComboBox<String> comboBoxTopping;

    //button group
    ButtonGroup buttonGroupSugar;
    ButtonGroup buttonGroupICE;

    //instance object
    Meal selectedDish;
    Drink selectedDrink;

    private JPanel contentPane;
    private JTextField name;
    private JTextField addr;
    private JTextField phone;
    private JTextField meal;
    private JTextField drink;
    JComboBox comboBox_Dish = new JComboBox();
    JComboBox comboBox_Drink = new JComboBox();
    private JTable table;
    private JTable table_1;
    JTextArea area = new JTextArea();
    private JTextField totalA;

    private JLabel valueMeal =  new JLabel();
    private JLabel valueDrink  = new JLabel();
    private JLabel valueTotal =  new JLabel();
    JLabel a1 = new JLabel("*");
    JLabel a2 = new JLabel("*");
    JLabel a3 = new JLabel("*");
    SimpleDateFormat sf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
    Date dt= new Date();
    int flag=0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OrderFood frame = new OrderFood();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public OrderFood() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1367, 772);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                FillDishes();
                FillDrinks();
                a1.setVisible(false);
                a2.setVisible(false);
                a3.setVisible(false);
            }
        });

        //define public object


        FillCombo();
//        ActionLogic(selectedDish, selectedDrink);
        //FillDishes();





        //UI=============UI=============UI=============UI=============UI=============
        //UI=============UI=============UI=============UI=============UI=============
        //UI=============UI=============UI=============UI=============UI=============

        //LABEL SELECT MEAL =========================================================
        JLabel lblSelectDish = new JLabel("SELECT MEAL");

        lblSelectDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblSelectDish.setBounds(34, 128, 181, 22);
        contentPane.add(lblSelectDish);

        //JComboBox comboBox_Dish = new JComboBox();
        comboBox_Dish.setFont(new Font("High Tower Text", Font.BOLD, 21));
        comboBox_Dish.setBounds(213, 122, 281, 34);
        contentPane.add(comboBox_Dish);

        //QTY
        JLabel lblQty = new JLabel("Quantity");
        lblQty.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblQty.setBounds(34, 178, 181, 22);
        contentPane.add(lblQty);

        SpinnerModel spinnerModelQtyMeal = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner spinnerQtyMeal = new JSpinner(spinnerModelQtyMeal);
        spinnerQtyMeal.setBounds(213, 181, 281, 34);
        contentPane.add(spinnerQtyMeal);


        JLabel lblTopping = new JLabel("Topping");
        lblTopping.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblTopping.setBounds(34, 220, 181, 22);
        contentPane.add(lblTopping);

        Map<String, Double> itemPriceMap = new HashMap<>();
        itemPriceMap.put(" Tidak ada", 0.0);
        itemPriceMap.put("Krupuk", 2000.0);
        itemPriceMap.put("Udang", 10000.0);
        itemPriceMap.put("Keju", 8000.0);

        comboBoxTopping = new JComboBox<>(itemPriceMap.keySet().toArray(new String[0]));
        comboBoxTopping.setBounds(213, 220, 181, 30);
        contentPane.add(comboBoxTopping);

        comboBoxTopping.setRenderer(new ItemRenderer(itemPriceMap));

        //LABEL SELECT MEAL =========================================================




        //LABEL SELECT DRINK
        JLabel lblPinaColada = new JLabel("SELECT DRINK");
        lblPinaColada.setFont(new Font("High Tower Text", Font.BOLD, 21));
        lblPinaColada.setBounds(22, 299, 183, 26);
        contentPane.add(lblPinaColada);

        //JComboBox comboBox_Drink = new JComboBox();
        comboBox_Drink.setFont(new Font("High Tower Text", Font.BOLD, 21));
        comboBox_Drink.setBounds(215, 295, 268, 34);
        contentPane.add(comboBox_Drink);


        JLabel lblQtyDrink = new JLabel("Quantity");
        lblQtyDrink.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblQtyDrink.setBounds(34, 350, 181, 22);
        contentPane.add(lblQtyDrink);

        SpinnerModel spinnerModelDrink = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner spinnerQtyDrink = new JSpinner(spinnerModelDrink);
        spinnerQtyDrink.setBounds(213, 350, 281, 34);
        contentPane.add(spinnerQtyDrink);




        //Choose sugar=======================================================================
        JLabel lblDrinkIce = new JLabel("Choose SUGAR");
        lblDrinkIce.setFont(new Font("High Tower Text", Font.BOLD, 21));
        lblDrinkIce.setBounds(22, 400, 183, 26);
        contentPane.add(lblDrinkIce);

        JRadioButton noSugarButton = new JRadioButton("No ");
        noSugarButton.setBounds(215, 400, 60, 26);
        JRadioButton lessSugarButton = new JRadioButton("Less ");
        lessSugarButton.setBounds(280   , 400, 60, 26);

        JRadioButton normalSugarButton = new JRadioButton("Normal ");
        normalSugarButton.setBounds(340   , 400, 80, 26);

        JRadioButton extraSugarButton = new JRadioButton("Extra ");
        extraSugarButton.setBounds(420   , 400, 80, 26);

        // Set the default selection to normal sugar
        normalSugarButton.setSelected(true);

        // Create a button group to group the radio buttons
        buttonGroupSugar = new ButtonGroup();
        buttonGroupSugar.add(noSugarButton);
        buttonGroupSugar.add(lessSugarButton);
        buttonGroupSugar.add(normalSugarButton);
        buttonGroupSugar.add(extraSugarButton);

        contentPane.add(noSugarButton);
        contentPane.add(lessSugarButton);
        contentPane.add(normalSugarButton);
        contentPane.add(extraSugarButton);

        //Choose sugar=======================================================================

        //Choose ICE=======================================================================
        JLabel lblChooseIce = new JLabel("Choose ICE");
        lblChooseIce.setFont(new Font("High Tower Text", Font.BOLD, 21));
        lblChooseIce.setBounds(22, 440, 183, 26);
        contentPane.add(lblChooseIce);

        JRadioButton noICEButton = new JRadioButton("No ");
        noICEButton.setBounds(215, 440, 60, 26);

        JRadioButton lessICEButton = new JRadioButton("Less ");
        lessICEButton.setBounds(280   , 440, 60, 26);

        JRadioButton normalICEButton = new JRadioButton("Normal ");
        normalICEButton.setBounds(340   , 440, 80, 26);

        JRadioButton extraICEButton = new JRadioButton("Extra ");
        extraICEButton.setBounds(420   , 440, 80, 26);

        normalICEButton.setSelected(true);

         buttonGroupICE = new ButtonGroup();
        buttonGroupICE.add(noICEButton);
        buttonGroupICE.add(lessICEButton);
        buttonGroupICE.add(normalICEButton);
        buttonGroupICE.add(extraICEButton);

        contentPane.add(noICEButton);
        contentPane.add(lessICEButton);
        contentPane.add(normalICEButton);
        contentPane.add(extraICEButton);

        //Choose ICE=======================================================================


        JLabel lblTotal = new JLabel("COST OF MEAL :");
        lblTotal.setFont(new Font("High Tower Text", Font.BOLD, 21));
        lblTotal.setBounds(33, 530, 192, 34);
        contentPane.add(lblTotal);

//        meal = new JTextField();
//        meal.setFont(new Font("High Tower Text", Font.PLAIN, 20));
//        meal.setBounds(233, 530, 140, 34);
//        contentPane.add(meal);
//        meal.setColumns(10);
        valueMeal.setFont(new Font("High Tower Text", Font.PLAIN, 20));
        valueMeal.setBounds(233, 530, 140, 34);
        contentPane.add(valueMeal);

        JLabel lblCostOfDrinks = new JLabel("COST OF DRINKS : ");
        lblCostOfDrinks.setFont(new Font("High Tower Text", Font.BOLD, 21));
        lblCostOfDrinks.setBounds(22, 590, 207, 26);
        contentPane.add(lblCostOfDrinks);

//        drink = new JTextField();
//        drink.setFont(new Font("High Tower Text", Font.PLAIN, 20));
//        drink.setBounds(233, 590, 140, 34);
//        contentPane.add(drink);
//        drink.setColumns(10);

        valueDrink.setFont(new Font("High Tower Text", Font.PLAIN, 20));
        valueDrink.setBounds(233, 590, 140, 34);
        contentPane.add(valueDrink);


        JButton btnGenerateReceipt = new JButton("GENERATE RECEIPT");
        btnGenerateReceipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(valueMeal.getText().equals("") || valueTotal.getText().equals("") || valueDrink.getText().equals("")){
                    JOptionPane.showMessageDialog(contentPane, "please order first", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    sf.format(dt);
//                    calculateAmount();
                    area.setText("***********************************************\n");
                    area.setText(area.getText()+"***               YOUR BILL RECEIPT        	    ***\n");
                    area.setText(area.getText()+"***********************************************\n\n");
                    area.setText(area.getText()+"TIME     : "+sf.format(dt)+"\n\n");
                    area.setText(area.getText()+"NAME     :    "+"Rasyid"+"\n\n");
                    area.setText(area.getText()+"ADDRESS  :    "+"kalirase"+"\n\n");
                    area.setText(area.getText()+"PHONE NUM  :    "+"087867677"+"\n\n");
                    area.setText(area.getText()+"ORDERED DISH  : "+selectedDish.getItemName()+"\n\n");
                    area.setText(area.getText()+"DESCRIPTION  : "+selectedDish.getDescription()+"\n\n");
                    area.setText(area.getText()+"ORDERED DRINK  : "+selectedDrink.getItemName()+"\n\n");
                    area.setText(area.getText()+"DESCRIPTION  : "+selectedDrink.getDescription()+"\n\n");
                    area.setText(area.getText()+"TOTAL AMOUNT   :   "+valueTotal.getText()+"\n\n");
                    ///////////////////////////area.setText(area.getText()+"COST OF MEAL : "+drink.getText()+"\n\n");

//                    addToDatabase();
                    flag=1;
                }
            }
        });
        btnGenerateReceipt.setFont(new Font("High Tower Text", Font.BOLD, 21));
        btnGenerateReceipt.setBounds(600, 673, 281, 39);
        contentPane.add(btnGenerateReceipt);

//        BTN TOTAL
        JButton btnTotal = new JButton("TOTAL");
        btnTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {



                    //MEAL LOGIC
                    //Instance object
                     selectedDish = (Meal) comboBox_Dish.getSelectedItem();

                    //get Qty Meal
                    int qtyMeal = (int) spinnerModelQtyMeal.getValue();

                    //get data from combobox topping
                    Object objSelectedTopping =  comboBoxTopping.getSelectedItem();
                    String selectedTopping = (String) objSelectedTopping;

                    //add topping
                    selectedDish.setTopping(selectedTopping);

                    int mealPrice = selectedDish.hitungTotal(qtyMeal);

                    //DRINK LOGIC
                    //Instane object
                     selectedDrink = (Drink) comboBox_Drink.getSelectedItem();

                    //get qty drink
                    int qtyDrink = (int) spinnerQtyDrink.getValue();

                    //get data from radiobutton sugar
                    String selectedSugar = getSelectedButtonText(buttonGroupSugar);
                    selectedDrink.setSugar(selectedSugar);

                    String selectedICE = getSelectedButtonText(buttonGroupICE);
                    selectedDrink.setIce(selectedICE);

                    int drinkPrice= selectedDrink.hitungTotal(qtyDrink);
//                    System.out.println(drinkPrice);

                    valueMeal.setText(String.valueOf(mealPrice));
                    valueDrink.setText(String.valueOf(drinkPrice));
                    valueTotal.setText(String.valueOf(drinkPrice + mealPrice));












//                    System.out.println(selectedValue);
//                    System.out.println(selectedDrink.getItemName());
//                    System.out.println(selectedDish.getItemName());

//                    if(name.getText().equals(""))
//                    {   a1.setVisible(true);
//                        throw new MyException("Exception : Please Fill all the details");
//
//                    }
//                    else if(addr.getText().equals(""))
//                    {   a2.setVisible(true);
//                        throw new MyException("Exception :Please Fill all the details");
//
//                    }
//                    else if(phone.getText().equals(""))
//                    {   a3.setVisible(true);
//                        throw new MyException("Exception :Please Fill all the details");
//
//                    }
//
//                    else
//                    {
//                        calculateAmount();
//                    }
//                    calculateAmount();
                }

                catch(Exception exception)
                {
                    JOptionPane.showMessageDialog(OrderFood.this, exception.getMessage());
                }
            }
        });
        btnTotal.setFont(new Font("High Tower Text", Font.BOLD, 21));
        btnTotal.setBounds(330, 480, 154, 39);
        contentPane.add(btnTotal);

        JButton btnCheckout = new JButton("CHECKOUT");
        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkOut();

            }
        });
        btnCheckout.setFont(new Font("High Tower Text", Font.BOLD, 21));
        btnCheckout.setBounds(930, 673, 207, 39);
        contentPane.add(btnCheckout);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(522, 88, 350, 280);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(522, 388, 350, 259);
        contentPane.add(scrollPane_1);

        table_1 = new JTable();
        scrollPane_1.setViewportView(table_1);
        area.setFont(new Font("High Tower Text", Font.PLAIN, 18));


        area.setBounds(909, 190, 447, 470);
        contentPane.add(area);

//        totalA = new JTextField();
//        totalA.setFont(new Font("High Tower Text", Font.BOLD, 20));
//        totalA.setBounds(231, 650, 142, 34);
//        contentPane.add(totalA);
//        totalA.setColumns(10);

        valueTotal.setFont(new Font("High Tower Text", Font.BOLD, 20));
        valueTotal.setBounds(231, 650, 142, 34);
        contentPane.add(valueTotal);

        JLabel lblTotalAmount = new JLabel("TOTAL");
        lblTotalAmount.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblTotalAmount.setBounds(73, 650, 126, 25);
        contentPane.add(lblTotalAmount);

        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(flag==0)
                    JOptionPane.showMessageDialog(null, "First you need to generate receipt");
                else {
//                    secondPage sp = new secondPage();
//                    sp.setVisible(true);
//                    sp.pack();
//                    sp.setLocationRelativeTo(null);
//                    sp.setBounds(100, 100, 1015, 574);
//                    setVisible(false);
                }

            }
        });
        btnBack.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnBack.setBounds(1200, 673, 148, 39);
        contentPane.add(btnBack);

        a1.setForeground(Color.RED);
        a1.setFont(new Font("Tahoma", Font.BOLD, 21));
        a1.setBounds(473, 304, 21, 21);
        contentPane.add(a1);


        a2.setFont(new Font("Tahoma", Font.BOLD, 20));
        a2.setForeground(Color.RED);
        a2.setBounds(473, 366, 21, 21);
        contentPane.add(a2);


        a3.setForeground(Color.RED);
        a3.setFont(new Font("Tahoma", Font.BOLD, 20));
        a3.setBounds(473, 419, 21, 16);
        contentPane.add(a3);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("images\\41.jpg"));
        label.setBounds(0, 0, 1385, 187);
        contentPane.add(label);
    }

    private void ActionLogic(Menu selectedDish, Menu selectedDrink) {
//        comboBox_Dish.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Retrieve the selected item
////                Menu selectedDish = (Menu) comboBox_Dish.getSelectedItem();
//                if (selectedDish != null) {
//                    int selectedId = selectedDish.getItemNo();
//                    // Use the selected ID as needed
//                    System.out.println("Selected ID: " + selectedId);
//                }
//            }
//        });
//
////        Drink selectedDish = (Drink) comboBox_Drink.getSelectedItem();
//        comboBox_Drink.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Retrieve the selected item
//
//                if (selectedDrink != null) {
//                    int selectedId = selectedDrink.hitungTotal(12);
//                    // Use the selected ID as needed
//                    System.out.println("Selected ID: " + selectedId);
//                }
//            }
//        });
    }

    private void FillCombo()
    {  PreparedStatement ps = null;
        ResultSet result = null;
        PreparedStatement ps1 = null;
        ResultSet result1 = null;
        try {
            DatabaseConnector connect=new DatabaseConnector();
            Connection conn=connect.getConnection();


            MenuProvider dishDAO = new MenuProvider();

            // Fetch all dishes from the database
            List<Menu> dishes = dishDAO.getAllDishes();

            // Populate the JComboBox
            for (Menu dish : dishes) {
                comboBox_Dish.addItem(dish);
            }


            //GET DATA FROM INTERFACE
            MenuProvider drinkDao = new MenuProvider();
            List<Menu> drinks = drinkDao.getAllDrink();

            // Populate the JComboBox
            for (Menu drink : drinks) {
                comboBox_Drink.addItem(drink);
            }



//            String sql2 = "SELECT * FROM restaurant where Type='DRINK' ORDER BY itemName ASC";
//            ps1=conn.prepareStatement(sql2);
//            result1= ps1.executeQuery();
//            while(result1.next())
//            {
//                String Dname= result1.getString("itemName");
//                comboBox_Drink.addItem(Dname);
//
//            }



        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void FillDishes()
    {
        DatabaseConnector connect=new DatabaseConnector();
        Connection conn=connect.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DISH NAME");
        model.addColumn("PRICE");

        try {
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
            rs.close();
            st.close();
            conn.close();
            table.setModel(model);
            table.setAutoResizeMode(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(250);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void FillDrinks()
    {
        DatabaseConnector connect=new DatabaseConnector();
        Connection conn=connect.getConnection();
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("DRINK NAME");
        model2.addColumn("PRICE");

        try {
            String query = "SELECT * FROM restaurant where Type='DRINK'";
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery(query);
            while(rs.next())
            {
                model2.addRow(new Object[] {
                        rs.getString("itemName"),
                        rs.getString("Price"),

                });
            }
            rs.close();
            st.close();
            conn.close();
            table_1.setModel(model2);
            table_1.setAutoResizeMode(0);
            table_1.getColumnModel().getColumn(0).setPreferredWidth(250);
            table_1.getColumnModel().getColumn(1).setPreferredWidth(100);

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void calculateAmount()
    {
        DatabaseConnector connect=new DatabaseConnector();
        Connection conn=connect.getConnection();
        PreparedStatement ps = null;
        ResultSet result = null;
        PreparedStatement ps1 = null;
        ResultSet result1 = null;
        String mealAmount=null;
        String drinkAmount=null;
        String di=(String)comboBox_Dish.getSelectedItem();
        String dr=(String)comboBox_Drink.getSelectedItem();




    }


    public void checkOut()
    {
        if(valueMeal.getText().equals("") || valueTotal.getText().equals("") || valueDrink.getText().equals("")){
            JOptionPane.showMessageDialog(contentPane, "please order first", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            MenuProvider menuProvider = new MenuProvider();
            boolean res = menuProvider.checkoutMenu("rasyid","kalirase",98889999, selectedDish.getItemName(),selectedDrink.getItemName(), Integer.valueOf(valueTotal.getText()), selectedDish.getDescription() + " "+ selectedDrink.getDescription(), 1);
            if (res){
                System.out.println("sukses");
            }else {
                System.out.println("gagal");
            }
        }
    }

    class ItemRenderer extends JLabel implements ListCellRenderer<String> {
        private Map<String, Double> itemPriceMap;

        public ItemRenderer(Map<String, Double> itemPriceMap) {
            this.itemPriceMap = itemPriceMap;
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            setText(value + " - Rp " + itemPriceMap.get(value));
            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            return this;
        }
    }

    private static String getSelectedButtonText(ButtonGroup buttonGroup) {
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }


}
