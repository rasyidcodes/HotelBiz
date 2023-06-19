package pages.admin.addTypeRoom;

import pages.admin.addRoom.AddRoom;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;
import java.util.List;

public class AddTypeRooms extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField r1;
    private JComboBox<String> r2;
    private JComboBox<String> r3;
    private JTextField r4;

    private AddTypeRoomsInterface roomsProvider;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddTypeRooms frame = new AddTypeRooms();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddTypeRooms() {
        roomsProvider = new AddTypeTypeRoomsProvider();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                try {
                    displayRooms();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 965, 577);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(155, 89, 182));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAddRooms = new JButton("ADD ROOMS");
        btnAddRooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    addRooms();
                    refreshtable();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

//        btnAddRooms.setFont(new Font("High Tower Text", Font.BOLD, 23));
        btnAddRooms.setBounds(12, 456, 225, 50);
        contentPane.add(btnAddRooms);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(330, 201, 431, 242);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnAddDish = new JButton("UPDATE ROOMS");
        btnAddDish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateRooms();
                    refreshtable();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

//        btnAddDish.setFont(new Font("High Tower Text", Font.BOLD, 23));
        btnAddDish.setBounds(518, 456, 270, 50);
        contentPane.add(btnAddDish);


        JButton btnDleteRooms = new JButton("DELETE ROOMS");
//        btnDleteRooms.setFont(new Font("High Tower Text", Font.BOLD, 23));
        btnDleteRooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteRooms();
                    refreshtable();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnDleteRooms.setBounds(248, 457, 258, 49);
        contentPane.add(btnDleteRooms);

        JScrollPane scrollpane = new JScrollPane();
        scrollpane.setBounds(330, 201, 431, 242);
        contentPane.add(scrollpane);

        JLabel lblRoomNumber = new JLabel("ROOM NO");
        lblRoomNumber.setForeground(Color.white);
//        lblRoomNumber.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblRoomNumber.setBounds(12, 153, 136, 38);
        contentPane.add(lblRoomNumber);

        JLabel lblRoomType = new JLabel("ROOM TYPE");
//        lblRoomType.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblRoomType.setForeground(Color.white);
        lblRoomType.setBounds(12, 216, 136, 38);
        contentPane.add(lblRoomType);

        JLabel lblBedType = new JLabel("BED TYPE");
        lblBedType.setForeground(Color.white);
//        lblBedType.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblBedType.setBounds(12, 289, 136, 25);
        contentPane.add(lblBedType);

        JLabel lblPrice = new JLabel("PRICE");
//        lblPrice.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblPrice.setForeground(Color.white);
        lblPrice.setBounds(23, 345, 107, 27);
        contentPane.add(lblPrice);

        r1 = new JTextField();
//        r1.setFont(new Font("High Tower Text", Font.BOLD, 20));

        r1.setBounds(160, 156, 147, 30);
        contentPane.add(r1);
        r1.setColumns(10);

        r2 = new JComboBox<>();
//        r2.setFont(new Font("High Tower Text", Font.BOLD, 20));
        r2.setBounds(160, 220, 147, 30);
        contentPane.add(r2);
        comboBox_RoomTypes();

        r3 = new JComboBox<>();
//        r3.setFont(new Font("High Tower Text", Font.BOLD, 20));
        r3.setBounds(160, 286, 147, 30);
        contentPane.add(r3);
        comboBox_BedTypes();

        r4 = new JTextField();
//        r4.setFont(new Font("High Tower Text", Font.BOLD, 20));
        r4.setBounds(160, 352, 147, 30);
        contentPane.add(r4);
        r4.setColumns(10);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    if (row < model.getRowCount()) {
                        String roomNumber = model.getValueAt(row, 0).toString();
                        String roomType = model.getValueAt(row, 1).toString();
                        String bedType = model.getValueAt(row, 2).toString();
                        String price = model.getValueAt(row, 3).toString();
                        r1.setText(roomNumber);
                        r2.setSelectedItem(roomType);
                        r3.setSelectedItem(bedType);
                        r4.setText(price);
                    }
                }
            }
        });


        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddRoom addRoom = new AddRoom();
                addRoom.setVisible(true);
            }
        });

        btnBack.setIcon(new ImageIcon("images\\back.png"));
//        btnBack.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                AdminForm af = new AdminForm();
//                af.setVisible(true);
//                af.pack();
//                af.setLocationRelativeTo(null);
//                af.setBounds(100, 100, 1080, 633);
//                setVisible(false);
//            }
//        });
//        btnBack.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnBack.setBounds(800, 457, 136, 50);
        contentPane.add(btnBack);

        JLabel lblNewLabel = new JLabel("Hotelbiz");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.white);
        lblNewLabel.setFont(new Font("High Tower Text", Font.BOLD, 37));
        lblNewLabel.setBounds(0, 0, 947, 142);
        contentPane.add(lblNewLabel);
        setVisible(true);
    }

    private void comboBox_RoomTypes() {
        try {
            List<String>roomTypes = roomsProvider.getRoomTypes();
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(roomTypes.toArray(new String[0]));
            r2.setModel(comboBoxModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void comboBox_BedTypes() {
        try {
            List<String> bedTypes = roomsProvider.getBedTypes();
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(bedTypes.toArray(new String[0]));
            r3.setModel(comboBoxModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayRooms() throws SQLException {
        Vector<Vector<Object>> rooms = roomsProvider.getAllRooms();
        Vector<String> header = new Vector<>();
        header.add("Room Number");
        header.add("Room Type");
        header.add("Bed Type");
        header.add("Price");
        DefaultTableModel model = new DefaultTableModel(rooms, header);
        table.setModel(model);
    }

    public void addRooms() throws SQLException {
        String roomNumber = r1.getText();
        String roomType = (String) r2.getSelectedItem();
        String bedType = (String) r3.getSelectedItem();
        String price = r4.getText();
        roomsProvider.addRooms(roomNumber, roomType, bedType, price);
    }

    public void updateRooms() throws SQLException {
        String roomNumber = r1.getText();
        String roomType = (String) r2.getSelectedItem();
        String bedType = (String) r3.getSelectedItem();
        String price = r4.getText();
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            String roomTypeId = model.getValueAt(selectedRow, 0).toString();
            roomsProvider.updateRooms(roomNumber, roomType, bedType, price, roomTypeId);
        }
    }

    public void deleteRooms() throws SQLException {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            String roomNumber = model.getValueAt(selectedRow, 0).toString();
            roomsProvider.deleteRooms(roomNumber);
        }
    }

    public void refreshtable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        r1.setText("");
        r2.setSelectedIndex(0);
        r3.setSelectedIndex(0);
        r4.setText("");
        displayRooms();
    }
}
