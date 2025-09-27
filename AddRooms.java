import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener {
    JButton addBtn, cancelBtn;
    JTextField tfroom, tfprice;
    JComboBox<String> availableCombo, cleanCombo, bedCombo;

    AddRooms() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(330, 200, 940, 470);
        setTitle("Add Rooms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 19));
        heading.setBounds(150, 20, 200, 30);
        add(heading);

        // Room Number
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomno.setBounds(60, 80, 120, 20);
        add(lblroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);

        // Availability
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 130, 120, 20);
        add(lblavailable);

        String availableOptions[] = {"Available", "Occupied"};
        availableCombo = new JComboBox<>(availableOptions);
        availableCombo.setBounds(200, 130, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        // Cleaning Status
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60, 180, 120, 20);
        add(lblclean);

        String cleanOptions[] = {"Cleaned", "Dirty"};
        cleanCombo = new JComboBox<>(cleanOptions);
        cleanCombo.setBounds(200, 180, 150, 30);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);

        // Price
        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60, 230, 120, 20);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        // Bed Type
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblbed.setBounds(60, 280, 120, 20);
        add(lblbed);

        String bedOptions[] = {"Single Bed", "Double Bed"};
        bedCombo = new JComboBox<>(bedOptions);
        bedCombo.setBounds(200, 280, 150, 30);
        bedCombo.setBackground(Color.WHITE);
        add(bedCombo);

        // Buttons
        addBtn = new JButton("Add Room");
        addBtn.setBounds(60, 350, 130, 30);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.addActionListener(this);
        add(addBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(220, 350, 130, 30);
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.addActionListener(this);
        add(cancelBtn);

        // Image
        ImageIcon i1 = new ImageIcon("C:\\Users\\skssa\\OneDrive\\Desktop\\PROJECTS\\twelve.jpg");
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setVisible(true);
    }

  @Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == addBtn) {
        String roomNo = tfroom.getText();
        String available = (String) availableCombo.getSelectedItem();
        String clean = (String) cleanCombo.getSelectedItem();
        String price = tfprice.getText();
        String bed = (String) bedCombo.getSelectedItem();

        try {
            conn conn = new conn();
            String str = "INSERT INTO addrooms VALUES('" + roomNo + "', '" + available + "', '" + clean + "', '" + price + "', '" + bed + "')";
            conn.s.executeUpdate(str);

            JOptionPane.showMessageDialog(this,
                "Room Added Successfully!\n\n" +
                "Room No: " + roomNo +
                "\nAvailable: " + available +
                "\nClean Status: " + clean +
                "\nPrice: " + price +
                "\nBed Type: " + bed
            );

            setVisible(false);  // close after success (optional)
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while adding room: " + e.getMessage());
        }

    } else if (ae.getSource() == cancelBtn) {
        setVisible(false);
    }
}


    public static void main(String[] args) {
        new AddRooms();
    }
}
