package pages.admin.addMenu;


import config.DatabaseConnector;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Menu extends JFrame {

    private JPanel contentPane;
    private JTextField d1;
    private JTextField d2;
    private JTextField d3;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
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
    public Menu() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {

                displayDishes();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 972, 611);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDishName = new JLabel("NAMA MENU");
//        lblDishName.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblDishName.setBounds(33, 211, 155, 22);
        contentPane.add(lblDishName);

        JLabel lblD = new JLabel("HARGA MENU");
//        lblD.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblD.setBounds(33, 284, 155, 27);
        contentPane.add(lblD);

        JLabel lblDishType = new JLabel("TIPE MENU");
//        lblDishType.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblDishType.setBounds(33, 353, 155, 27);
        contentPane.add(lblDishType);

        d1 = new JTextField();
        d1.setFont(new Font("High Tower Text", Font.BOLD, 20));
        d1.setBounds(182, 207, 232, 30);
        contentPane.add(d1);
        d1.setColumns(10);

        d2 = new JTextField();
        d2.setFont(new Font("High Tower Text", Font.BOLD, 20));
        d2.setBounds(182, 282, 232, 30);
        contentPane.add(d2);
        d2.setColumns(10);

        d3 = new JTextField();
        d3.setFont(new Font("High Tower Text", Font.BOLD, 20));
        d3.setBounds(182, 351, 232, 30);
        contentPane.add(d3);
        d3.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(456, 194, 418, 279);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("Hotelbiz");
        lblNewLabel.setHorizontalAlignment(0);
        lblNewLabel.setFont(new Font("High Tower Text", 1, 37));
        lblNewLabel.setBounds(0, 0, 947, 142);
        this.contentPane.add(lblNewLabel);
        this.setVisible(true);

        JButton btnAddDish = new JButton("ADD MENU");
        btnAddDish.setIcon(new ImageIcon("images\\plus (1).png"));
        btnAddDish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDishes();

            }
        });
//        btnAddDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnAddDish.setBounds(45, 486, 176, 53);
        contentPane.add(btnAddDish);

        JButton btnDeleteDish = new JButton("DELETE MENU");
        btnDeleteDish.setIcon(new ImageIcon("images\\iconfinder_f-cross_256_282471 (1).png"));
        btnDeleteDish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteDishes();
            }
        });
//        btnDeleteDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnDeleteDish.setBounds(245, 486, 221, 53);
        contentPane.add(btnDeleteDish);

        JButton btnUpdateDish = new JButton("UPDATE MENU");
        btnUpdateDish.setIcon(new ImageIcon("images\\updated.png"));
        btnUpdateDish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDishes();
            }
        });
//        btnUpdateDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnUpdateDish.setBounds(502, 486, 221, 53);
        contentPane.add(btnUpdateDish);

        JButton btnBack = new JButton("BACK");
        btnBack.setIcon(new ImageIcon("images\\back.png"));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
            }
        });
//        btnBack.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnBack.setBounds(765, 486, 143, 53);
        contentPane.add(btnBack);

        JLabel label = new JLabel("");
        label.setBounds(879, 100, 239, 163);
        contentPane.add(label);

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("images\\34.jpg"));
        lblNewLabel.setBounds(0, 0, 300, 195);
        contentPane.add(lblNewLabel);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("images\\i3.jpg"));
        label_1.setBounds(310, -1, 319, 195);
        contentPane.add(label_1);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("images\\cock.jpg"));
        lblNewLabel_1.setBounds(623, 0, 331, 195);
        contentPane.add(lblNewLabel_1);
    }

    public void displayDishes() {
        DatabaseConnector connect = new DatabaseConnector();
        Connection conn = connect.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NO MENU");
        model.addColumn("NAMA MENU");
        model.addColumn("TIPE MENU");
        model.addColumn("HARGA");

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    d1.setText(table.getValueAt(selectedRow, 1).toString());  // Mengisi kolom "Nama Menu"
                    d2.setText(table.getValueAt(selectedRow, 3).toString());  // Mengisi kolom "Harga Menu"
                    d3.setText(table.getValueAt(selectedRow, 2).toString());  // Mengisi kolom "Tipe Menu"
                }
            }
        });

        try {
            String query = "SELECT * FROM restaurant";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("itemNo"),
                        rs.getString("itemName"),
                        rs.getString("Type"),
                        rs.getString("Price")
                });
            }

            rs.close();
            st.close();
            conn.close();
            table.setModel(model);
            table.setAutoResizeMode(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(70);
            table.getColumnModel().getColumn(1).setPreferredWidth(167);
            table.getColumnModel().getColumn(2).setPreferredWidth(90);
            table.getColumnModel().getColumn(3).setPreferredWidth(90);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void addDishes() {
        DatabaseConnector connect = new DatabaseConnector();
        Connection conn = connect.getConnection();

        try {
            String query = "INSERT INTO restaurant (itemName, Type, Price) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, d1.getText());
            pst.setString(2, d3.getText());
            pst.setString(3, d2.getText());
            pst.executeUpdate();
            pst.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Menu added successfully");
            displayDishes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDishes() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Pilih menu yang akan diperbarui");
            return;
        }

        String itemName = d1.getText();
        String price = d2.getText();
        String type = d3.getText();

        if (itemName.isEmpty() || price.isEmpty() || type.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi semua kolom dengan benar");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin memperbarui menu ini?",
                "Konfirmasi Pembaruan", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            DatabaseConnector connect = new DatabaseConnector();
            Connection conn = connect.getConnection();
            try {
                String query = "UPDATE restaurant SET itemName=?, Type=?, Price=? WHERE itemNo=?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, itemName);
                pst.setString(2, type);
                pst.setString(3, price);
                pst.setString(4, table.getValueAt(row, 0).toString());
                pst.executeUpdate();
                pst.close();
                conn.close();
                JOptionPane.showMessageDialog(null, "Menu berhasil diperbarui");
                displayDishes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    public void deleteDishes() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Select a menu to delete");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this menu?",
                "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            DatabaseConnector connect = new DatabaseConnector();
            Connection conn = connect.getConnection();
            try {
                String query = "DELETE FROM restaurant WHERE itemNo=?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, table.getValueAt(row, 0).toString());
                pst.executeUpdate();
                pst.close();
                conn.close();
                JOptionPane.showMessageDialog(null, "Menu deleted successfully");
                displayDishes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}