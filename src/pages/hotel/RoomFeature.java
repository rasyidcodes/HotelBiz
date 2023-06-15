package pages.hotel;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class RoomFeature extends JFrame{

    //   1 standard. 2 premium. 3 deluxe. 
      
      // show room card 
      public void showRoomCard(){
            JFrame frame = new JFrame("ROOM");

            // get data from interface 
            HotelProvider hotelDAO = new HotelProvider(); 
            List<Room> roominfo = hotelDAO.showRoomType();

            JPanel panelA = new JPanel();
            panelA.setBackground(Color.BLACK);
            panelA.setPreferredSize(new Dimension(520, 200));
            panelA.setLayout(new BoxLayout(panelA, BoxLayout.X_AXIS));
    
            JPanel panelB = new JPanel();
            panelB.setBackground(Color.WHITE);
            panelB.setPreferredSize(new Dimension(520, 200));
            panelB.setLayout(new BoxLayout(panelB, BoxLayout.X_AXIS));
    
            JPanel panelC = new JPanel();
            panelC.setBackground(Color.BLUE);
            panelC.setPreferredSize(new Dimension(520, 160));
            panelC.setLayout(new BoxLayout(panelC, BoxLayout.X_AXIS));

            // SUBPANEL A
            JPanel subpanelA1 = new JPanel(){
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    try {
                        // Baca file gambar
                        File imageFile = new File("src/pages/image/KAMAR2.jpg");
                        Image image = ImageIO.read(imageFile);

                        // Gambar gambar ke panel1
                        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            subpanelA1.setPreferredSize(new Dimension(250, 90));
            panelA.add(subpanelA1);

            JPanel subpanelA2 = new JPanel(); 
            subpanelA2.setPreferredSize(new Dimension(250, 230));
            subpanelA2.setBackground(Color.WHITE);
            subpanelA2.setLayout(new GridLayout(10,1));
            panelA.add(subpanelA2); 
            // Mengatur EmptyBorder untuk memberikan padding
            int padding = 10;
            subpanelA2.setBorder(new EmptyBorder(padding, padding, padding, padding));

            JLabel namakamar1 = new JLabel(roominfo.get(2).getRoomName()); 
            JLabel price1 = new JLabel(String.valueOf(roominfo.get(2).getPrice()));
            JLabel bedType1 = new JLabel(roominfo.get(2).getBedType()); 
            JLabel facility1 = new JLabel("WHATS WILL YOU GET? ");
            JLabel info1 = new JLabel("1. PREMIUM'S ROOM facilities ");
            JLabel info2 = new JLabel("2. Private Swimming"); 
            JLabel info3 = new JLabel("3. Luxury Bathub ");
            JLabel info4 = new JLabel("4. In Room Breakfast Service");
            JLabel enter = new JLabel("  ");
            subpanelA2.add(namakamar1);
            subpanelA2.add(price1);
            subpanelA2.add(bedType1);
            subpanelA2.add(facility1);
            subpanelA2.add(info1);
            subpanelA2.add(info2);
            subpanelA2.add(info3);
            subpanelA2.add(info4);
            subpanelA2.add(enter);
            namakamar1.setFont(new Font("Poppins", Font.BOLD, 18));
            namakamar1.setForeground(new Color(128, 0, 128));
            price1.setFont(new Font("Poppins", Font.BOLD, 17));
            bedType1.setFont(new Font("Poppins", Font.PLAIN, 10));
            info1.setFont(new Font("Poppins", Font.PLAIN, 10));
            info2.setFont(new Font("Poppins", Font.PLAIN, 10));
            info3.setFont(new Font("Poppins", Font.PLAIN, 10));
            info4.setFont(new Font("Poppins", Font.PLAIN, 10));

            JButton buttonRoomA = new JButton("See Room Availability");
            buttonRoomA.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    roomDetailsBook(3);
                    // frame.dispose();
                }
            });
            subpanelA2.add(buttonRoomA);


            // SUBPANEL B (PREMIUM ROOM)
            JPanel subpanelB1 = new JPanel() {
                  @Override
                  protected void paintComponent(Graphics g) {
                      super.paintComponent(g);
                      try {
                          // Read the image file
                          File imageFile = new File("src/pages/image/KAMAR1.jpg");
                          Image image = ImageIO.read(imageFile);
              
                          // Draw the image on the panel
                          g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }
              };
              subpanelB1.setPreferredSize(new Dimension(250, 90));
              panelB.add(subpanelB1);

              JPanel subpanelB2 = new JPanel();
              subpanelB2.setPreferredSize(new Dimension(250, 230));
              subpanelB2.setBackground(Color.WHITE);
              subpanelB2.setLayout(new GridLayout(10, 1));
              panelB.add(subpanelB2);
              // Set EmptyBorder to provide padding
              subpanelB2.setBorder(new EmptyBorder(padding, padding, padding, padding));

              JLabel namakamar2 = new JLabel(roominfo.get(1).getRoomName());
              JLabel price2 = new JLabel(String.valueOf(roominfo.get(1).getPrice()));
              JLabel bedType2 = new JLabel(roominfo.get(1).getBedType());
              JLabel facility2 = new JLabel("WHAT WILL YOU GET?");
              JLabel info2_4 = new JLabel("1. STANDARD'S ROOM FACILITIES");
              JLabel info2_1 = new JLabel("2. Fitness Center");
              JLabel info2_2 = new JLabel("3. Television");
              JLabel info2_3 = new JLabel("4. Minibar");
              JLabel enter2 = new JLabel(" ");
              subpanelB2.add(namakamar2);
              subpanelB2.add(price2);
              subpanelB2.add(bedType2);
              subpanelB2.add(facility2);
              subpanelB2.add(info2_4);
              subpanelB2.add(info2_1);
              subpanelB2.add(info2_2);
              subpanelB2.add(info2_3);
              subpanelB2.add(enter2);
              namakamar2.setFont(new Font("Poppins", Font.BOLD, 18));
              namakamar2.setForeground(new Color(128, 0, 128));
              price2.setFont(new Font("Poppins", Font.BOLD, 17));
              bedType2.setFont(new Font("Poppins", Font.PLAIN, 10));
              info2_1.setFont(new Font("Poppins", Font.PLAIN, 10));
              info2_2.setFont(new Font("Poppins", Font.PLAIN, 10));
              info2_3.setFont(new Font("Poppins", Font.PLAIN, 10));
              info2_4.setFont(new Font("Poppins", Font.PLAIN, 10));

              JButton buttonRoomB = new JButton("See Room Availability"); 
              buttonRoomB.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    roomDetailsBook(2);
                }
              });              
              subpanelB2.add(buttonRoomB);
                           

            //   SUBPANEL C (STANDARD ROOM)
            JPanel subpanelC1 = new JPanel(){
                  @Override
                  protected void paintComponent(Graphics g) {
                      super.paintComponent(g);
                      try {
                          // Baca file gambar
                          File imageFile = new File("src/pages/image/KAMAR3.jpg");
                          Image image = ImageIO.read(imageFile);
  
                          // Gambar gambar ke panel1
                          g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }
              };
              subpanelC1.setPreferredSize(new Dimension(250, 90));
              panelC.add(subpanelC1);
              
              JPanel subpanelC2 = new JPanel();
              subpanelC2.setPreferredSize(new Dimension(250, 230));
              subpanelC2.setBackground(Color.WHITE);
              subpanelC2.setLayout(new GridLayout(8, 1));
              panelC.add(subpanelC2);
              // Set EmptyBorder to provide padding
              subpanelC2.setBorder(new EmptyBorder(padding, padding, padding, padding));
              
              JLabel namakamar3 = new JLabel(roominfo.get(0).getRoomName());
              JLabel price3 = new JLabel(String.valueOf(roominfo.get(0).getPrice()));
              JLabel bedType3 = new JLabel(roominfo.get(0).getBedType());
              JLabel facility3 = new JLabel("WHAT WILL YOU GET?");
              JLabel info3_1 = new JLabel("1. Free Snack");
              JLabel info3_2 = new JLabel("2. Wifi");
              JLabel enter3 = new JLabel(" ");
              subpanelC2.add(namakamar3);
              subpanelC2.add(price3);
              subpanelC2.add(bedType3);
              subpanelC2.add(facility3);
              subpanelC2.add(info3_1);
              subpanelC2.add(info3_2);
              subpanelC2.add(enter3);
              namakamar3.setFont(new Font("Poppins", Font.BOLD, 18));
              namakamar3.setForeground(new Color(128, 0, 128));
              price3.setFont(new Font("Poppins", Font.BOLD, 17));
              bedType3.setFont(new Font("Poppins", Font.PLAIN, 10));
              info3_1.setFont(new Font("Poppins", Font.PLAIN, 10));
              info3_2.setFont(new Font("Poppins", Font.PLAIN, 10));

              JButton buttonRoomC = new JButton("See Room Availability"); 
              buttonRoomC.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    roomDetailsBook(1);
                }
              });
              subpanelC2.add(buttonRoomC);
                            

            //  ------------------------------------------------------------

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new GridBagLayout());
            mainPanel.setBackground(new Color(230, 230, 255));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.insets = new Insets(30, 100, 10, 100); // Jarak antara panel dengan tepi kanan-kiri-atas-bawah
            mainPanel.add(panelA, gbc);
    
            gbc.gridy = 1;
            gbc.insets = new Insets(10, 100, 10, 100); // Jarak antara panel dengan tepi kanan-kiri-atas-bawah
            mainPanel.add(panelB, gbc);
    
            gbc.gridy = 2;
            gbc.insets = new Insets(10, 100, 30, 100); // Jarak antara panel dengan tepi kanan-kiri-atas-bawah
            mainPanel.add(panelC, gbc);

            frame.add(mainPanel);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }




      // room details & book panel 
      private void roomDetailsBook(int roomType){

            HotelProvider hotelDAO = new HotelProvider(); 

            JFrame frame = new JFrame("ROOM ID 1");
            frame.setUndecorated(true);

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


            //  ------------------------------------------------------------
            // PANEL A
            // JUDUL NAMA ROOM
            JPanel panelA = new JPanel();
            panelA.setBackground(new Color(155, 89, 182));
            panelA.setPreferredSize(new Dimension(900, 50));
            JButton buttonback = new JButton("BACK");
            buttonback.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                }
              }); 

            panelA.add(buttonback);

            JLabel labelRoomType = new JLabel(hotelDAO.getSpecificRoomType(roomType).getRoomName()); 
            labelRoomType.setForeground(Color.WHITE); // Mengatur warna teks 
            labelRoomType.setFont(new Font("Arial", Font.BOLD, 26));
            panelA.add(labelRoomType);


            //  ------------------------------------------------------------
            // PANEL B
            // panel B dibagi jad 2 : untuk tabel avail dan tabel info
            // YAITU PANEL B1 DAN B2
            JPanel panelB = new JPanel();
            panelB.setBackground(Color.WHITE);
            panelB.setPreferredSize(new Dimension(900,530));
            panelB.setLayout(new GridLayout(1, 2));

            JPanel panelB1 = new JPanel();
            JPanel panelB2 = new JPanel(); 
            panelB2.setBackground(Color.white);

            panelB.add(panelB1);
            panelB.add(panelB2);

            // PANEL B1 (TABEL AVAIL)
            DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Mencegah sel pada tabel agar tidak dapat diubah
                }
            };
            tableModel.addColumn("Room Number");
            tableModel.addColumn("Status");

            JTable Jtabel = new JTable(tableModel);

            // mengatur width kolom tertentu
            Jtabel.getColumnModel().getColumn(0).setPreferredWidth(180);
            Jtabel.getColumnModel().getColumn(1).setPreferredWidth(180);

            // Mengatur alignment nilai JTable ke CENTER
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            Jtabel.setDefaultRenderer(Object.class, centerRenderer);

            JScrollPane scrollPane = new JScrollPane(Jtabel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setPreferredSize(new Dimension(450, 530));
            panelB1.add(scrollPane);

            Jtabel.setRowHeight(30); // Tinggi baris
            Jtabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Jenis dan ukuran font teks
            Jtabel.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15)); 

            scrollPane.setBackground(Color.WHITE);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0)); // Tambahkan garis tepi
            scrollPane.getViewport().setBackground(Color.WHITE); // Warna latar belakang viewport

            // get data from interface 
            List<Room> rooms = hotelDAO.getRoomAvailable(roomType); 

            switch (roomType) {
                case 3:
                     for(Room objroom : rooms){
                        tableModel.addRow(new Object[]{
                            ((RoomDeluxe) objroom).getRoomNumber(), 
                            ((RoomDeluxe) objroom).getAvailability() 
                        });
                     }
                    break;
                case 2:
                     for(Room objroom : rooms){
                        tableModel.addRow(new Object[]{
                            ((RoomPremium) objroom).getRoomNumber(), 
                            ((RoomPremium) objroom).getAvailability()
                        });
                     }
                    break;
                case 1:
                     for(Room objroom : rooms){
                        tableModel.addRow(new Object[]{
                            ((RoomStandard) objroom).getRoomNumber(), 
                            ((RoomStandard) objroom).getAvailability() 
                        });
                     }
                    break;
            }

           
            // PANEL B2 (dibagi jadi 4 panel) B2A B2B B2C B2D
            JPanel panelB2B = new JPanel();
            panelB2B.setPreferredSize(new Dimension(450,310));
            panelB2B.setBackground(new Color(230, 230, 255));

            // panel B2B (ROOM DESCRIPTION)
            JLabel roomNumber = new JLabel("ROOM DETAILS : "); 
            panelB2B.add(roomNumber);

            JTextArea area = new JTextArea();
            area.setPreferredSize(new Dimension(350, 250));
            area.setEditable(false);
            panelB2B.add(area);
            // area.setText("***********************************************\n");

            // panel B2A (INPUT FIELD KAMAR NOMOR BERAPA)
            JPanel panelB2A = new JPanel(); 
            panelB2A.setPreferredSize(new Dimension(450,40));
            panelB2A.setBackground(new Color(128, 0, 128));
            

            JTextField roomNo = new JTextField(5); // Menentukan panjang teks input (jumlah kolom)
            panelB2A.add(roomNo);

            JButton buttonCheckRoomDetails = new JButton("Show Room Details");
            panelB2A.add(buttonCheckRoomDetails); 

            buttonCheckRoomDetails.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    roomNumber.setText("ROOM DETAILS: " + roomNo.getText());
                    area.setText("");
                    int roomNumber = Integer.parseInt(roomNo.getText());

                    try {
                        Room obj = hotelDAO.roomDetails(roomType, roomNumber);
                        area.append(obj.getDescription());
                    } catch (Exception ee) {
                        JOptionPane.showMessageDialog(null, "Please insert the right room number.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            });


            // PANEL B2C (CHECK CHARGES PERDAY)
            JPanel panelB2C = new JPanel();
            panelB2C.setPreferredSize(new Dimension(450,100));
            panelB2C.setBackground(Color.WHITE);
            panelB2C.setLayout(new GridLayout(2, 3));
            panelB2C.setBorder(new EmptyBorder(5,15,5,15));

            JLabel day = new JLabel("Days : ");
            JTextField days = new JTextField();
            JButton calculateButton = new JButton("Calculate");
            JLabel charges = new JLabel("Total Charges : "); 
            JLabel totalcharges = new JLabel(); 

            calculateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    int dayInput = Integer.parseInt(days.getText());
                    double calculatedCharges = dayInput * hotelDAO.getSpecificRoomType(roomType).getPrice();
                    totalcharges.setText("" + calculatedCharges);
                }
            });

            panelB2C.add(day); 
            panelB2C.add(days); 
            panelB2C.add(calculateButton);
            panelB2C.add(charges); 
            panelB2C.add(totalcharges); 


            // PANEL B2D
            // bookingbutton 
            JPanel panelB2D = new JPanel();
            panelB2D.setPreferredSize(new Dimension(450,310));
            panelB2D.setBackground(Color.WHITE);
            JButton bookroomButton = new JButton("BOOK ROOM");
            panelB2D.add(bookroomButton);
            

            // Panel B add
            panelB2.add(panelB2A);
            panelB2.add(panelB2B);
            panelB2.add(panelB2C);
            panelB2.add(panelB2D);

            //  ------------------------------------------------------------
            
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new GridBagLayout());
            mainPanel.setBackground(new Color(230, 230, 255));
            mainPanel.setPreferredSize(new Dimension(1000, 694));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.insets = new Insets(30, 50, 0, 50); // Jarak antara panel dengan tepi kanan-kiri-atas-bawah
            mainPanel.add(panelA, gbc);

            gbc.gridy = 1;
            gbc.insets = new Insets(0, 50, 30, 50); // Jarak antara panel dengan tepi kanan-kiri-atas-bawah
            mainPanel.add(panelB, gbc);

            frame.add(mainPanel);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }



      public static void main(String[] args) {
            RoomFeature a = new RoomFeature();
            // a.roomDetailsBook(2);
            a.showRoomCard();

            // HotelProvider b = new HotelProvider(); 
            // // RoomDeluxe aby = (RoomDeluxe) b.roomDetails(2, 310);
            // // System.out.println(aby.getDescription());

            // RoomStandard ac = (RoomStandard) b.roomDetails(0, 101);
            // System.out.println(ac.getDescription());

            // RoomPremium ab = (RoomPremium) b.roomDetails(1,201); 
            // System.out.println(ab.getDescription());

            // System.out.println(ab.hitungHarga(4));

            // System.out.println(a.roomType);





      }
      
}
