import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDrivers extends JFrame implements ActionListener {
    JButton addBtn, cancelBtn;
    JTextField tfname, tfage, tfcompany, tfmodel, tflocation;
    JComboBox<String> genderCombo, availableCombo;

    AddDrivers() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 980, 500);
        setTitle("Add Drivers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 19));
        heading.setBounds(150, 20, 200, 30);
        add(heading);

        // Name
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setBounds(60, 80, 120, 20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 30);
        add(tfname);

        // Age
        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblage.setBounds(60, 130, 120, 20);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 130, 150, 30);
        add(tfage);

        // Gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setBounds(60, 180, 120, 20);
        add(lblgender);

        String genderOptions[] = {"Male", "Female"};
        genderCombo = new JComboBox<>(genderOptions);
        genderCombo.setBounds(200, 180, 150, 30);
        genderCombo.setBackground(Color.WHITE);
        add(genderCombo);

        // Car Company
        JLabel lblcompany = new JLabel("Car Company");
        lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcompany.setBounds(60, 230, 120, 20);
        add(lblcompany);

        tfcompany = new JTextField();
        tfcompany.setBounds(200, 230, 150, 30);
        add(tfcompany);

        // Car Model
        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblmodel.setBounds(60, 280, 120, 20);
        add(lblmodel);

        tfmodel = new JTextField();
        tfmodel.setBounds(200, 280, 150, 30);
        add(tfmodel);

        // Availability
        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 330, 120, 20);
        add(lblavailable);

        String driverOptions[] = {"Available", "Busy"};
        availableCombo = new JComboBox<>(driverOptions);
        availableCombo.setBounds(200, 330, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        // Location
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbllocation.setBounds(60, 380, 120, 20);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200, 380, 150, 30);
        add(tflocation);

        // Buttons
        addBtn = new JButton("Add Driver");
        addBtn.setBounds(60, 420, 130, 30);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.addActionListener(this);
        add(addBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(220, 420, 130, 30);
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.addActionListener(this);
        add(cancelBtn);

        // Image
        ImageIcon i1 = new ImageIcon("C:\\Users\\skssa\\OneDrive\\Desktop\\PROJECTS\\eleven.jpg");
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) genderCombo.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String availability = (String) availableCombo.getSelectedItem();
            String location = tflocation.getText();

            try {
                conn c = new conn();
                String query = "INSERT INTO drivers VALUES('" + name + "', '" + age + "', '" + gender + "', '" + company + "', '" + model + "', '" + availability + "', '" + location + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(this,
                        "Driver Added Successfully!\n\n" +
                                "Name: " + name +
                                "\nAge: " + age +
                                "\nGender: " + gender +
                                "\nCompany: " + company +
                                "\nModel: " + model +
                                "\nAvailability: " + availability +
                                "\nLocation: " + location
                );

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error while adding driver: " + e.getMessage());
            }

        } else if (ae.getSource() == cancelBtn) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDrivers();
    }
}
