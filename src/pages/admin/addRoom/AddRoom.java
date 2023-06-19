package pages.admin.addRoom;

import pages.admin.AdminMainPage;
import pages.admin.addTypeRoom.AddTypeRooms;
import pages.admin.addTypeRoom.AddTypeRoomsInterface;
import pages.admin.addTypeRoom.AddTypeTypeRoomsProvider;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Vector;

public class AddRoom extends JFrame {

    private AddRoomsInterface roomsProvider;
    private JPanel contentPane;

    private JTable table;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddRoom frame = new AddRoom();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddRoom() {
        roomsProvider = new AddRoomProvider();
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


        //Make table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 20, 431, 300);
        contentPane.add(scrollPane);

        JButton btnEditRoomType = new JButton("edit room type");
        btnEditRoomType.setBounds(30, 350, 150, 30);
        contentPane.add(btnEditRoomType);


        JButton btnBack = new JButton("BACK");
        btnBack.setBounds(800, 500, 150, 30);
        contentPane.add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminMainPage adminMainPage=new AdminMainPage();
                adminMainPage.showLoginForm();
            }
        });


        table = new JTable();
        scrollPane.setViewportView(table);


        JLabel lbladdRoom = new JLabel("ADD ROOM");
        lbladdRoom.setForeground(Color.white);
//        lbladdRoom.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lbladdRoom.setBounds(500, 20, 136, 38);
        contentPane.add(lbladdRoom);

        JLabel lblroomNumber = new JLabel("Room number");
        lblroomNumber.setForeground(Color.white);
//        lblroomNumber.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblroomNumber.setBounds(500, 50, 136, 38);
        contentPane.add(lblroomNumber);

        JTextField tf_roomnumber = new JTextField();
//        tf_roomnumber.setFont(new Font("High Tower Text", Font.BOLD, 20));
        tf_roomnumber.setBounds(700, 50, 147, 30);
        contentPane.add(tf_roomnumber);


        JLabel lblroomtype = new JLabel("Room Type");
        lblroomtype.setForeground(Color.white);
//        lblroomtype.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblroomtype.setBounds(500, 100, 136, 38);
        contentPane.add(lblroomtype);

        JComboBox roomtypecombo = new JComboBox<>();
        roomtypecombo.addItem("Standard Room");
        roomtypecombo.addItem("Premium Room");
        roomtypecombo.addItem("Deluxe Room");
//        roomtypecombo.setFont(new Font("High Tower Text", Font.BOLD, 20));
        roomtypecombo.setBounds(700, 100, 147, 30);
        contentPane.add(roomtypecombo);


        JButton btnAddDish = new JButton("add rooms");
//        btnAddDish.setFont(new Font("High Tower Text", Font.BOLD, 15));
        btnAddDish.setBounds(500, 150, 150, 30);
        contentPane.add(btnAddDish);


        JLabel lblAVAILABILITY = new JLabel("SET AVAILABILITY");
        lblAVAILABILITY.setForeground(Color.white);
//        lblAVAILABILITY.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblAVAILABILITY.setBounds(500, 200, 300, 38);
        contentPane.add(lblAVAILABILITY);

        JLabel lblroomNumberAvail = new JLabel("Room number");
        lblroomNumberAvail.setForeground(Color.white);
//        lblroomNumberAvail.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblroomNumberAvail.setBounds(500, 250, 136, 38);
        contentPane.add(lblroomNumberAvail);

        JTextField tf_roomnumberavail = new JTextField();
//        tf_roomnumberavail.setForeground(Color.white);
//        tf_roomnumberavail.setFont(new Font("High Tower Text", Font.BOLD, 20));
        tf_roomnumberavail.setBounds(700, 250, 147, 30);
        contentPane.add(tf_roomnumberavail);

        JLabel lblroomavail = new JLabel("Status");
        lblroomavail.setForeground(Color.white);
//        lblroomavail.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblroomavail.setBounds(500, 300, 136, 38);
        contentPane.add(lblroomavail);

        JComboBox roomavailcombo = new JComboBox<>();
        roomavailcombo.addItem("1");
        roomavailcombo.addItem("0");

//        roomavailcombo.setFont(new Font("High Tower Text", Font.BOLD, 20));
        roomavailcombo.setBounds(700, 300, 147, 30);
        contentPane.add(roomavailcombo);

        JButton btnupdateavail = new JButton("update");
//        btnupdateavail.setFont(new Font("High Tower Text", Font.BOLD, 15));
        btnupdateavail.setBounds(500, 350, 150, 30);
        contentPane.add(btnupdateavail);

        btnEditRoomType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTypeRooms addTypeRooms =  new AddTypeRooms();
                addTypeRooms.setVisible(true);
            }
        });

        btnAddDish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomtypeselected = roomtypecombo.getSelectedItem().toString();
                int roomNumber = Integer.valueOf(tf_roomnumber.getText());
                if (roomsProvider.addRooms(roomNumber, roomtypeselected)){
                    try {
                        displayRooms();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }else {
                    System.out.println("failed to insert");
                }
            }
        });

        btnupdateavail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int roomNumber  = Integer.valueOf(tf_roomnumberavail.getText());
                int avail =  Integer.valueOf(roomavailcombo.getSelectedItem().toString());
                if (roomsProvider.updateRooms(roomNumber, avail)){
                    try {
                        displayRooms();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    public void displayRooms() throws SQLException {
        Vector<Vector<Object>> rooms = roomsProvider.getAllRooms();
        Vector<String> header = new Vector<>();
        header.add("Room Number");
        header.add("Room Type");
        header.add("Bed Type");
        header.add("Availability");
        DefaultTableModel model = new DefaultTableModel(rooms, header);
        table.setModel(model);
    }
}
