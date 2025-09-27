import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEmployees extends JFrame implements ActionListener {
    JTextField tfname, tfemail, tfphone, tfsalary, tfage, tfadhaar;
    JRadioButton rbmale, rbfemale;
    JComboBox<String> cbjob;
    JButton submit;

    AddEmployees() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setTitle("Add Employee");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // important fix

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.white);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 90, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);

        String str[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff",
                        "Room Service", "Chefs", "Waiters/Waitress", "Managers", "Accountant"};
        cbjob = new JComboBox<>(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.white);
        add(cbjob);

        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("E-MAIL");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);

        JLabel lbladhaar = new JLabel("ADHAAR");
        lbladhaar.setBounds(60, 380, 120, 30);
        lbladhaar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbladhaar);

        tfadhaar = new JTextField();
        tfadhaar.setBounds(200, 380, 150, 30);
        add(tfadhaar);

        submit = new JButton("SUBMIT");
        submit.setBounds(200, 430, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon("C:\\Users\\skssa\\OneDrive\\Desktop\\PROJECTS\\tenth.jpg");
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String adhaar = tfadhaar.getText();

        String gender = null;
        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        }

        String job = (String) cbjob.getSelectedItem();

        try {
            conn conn = new conn();
            String query = "INSERT INTO employees (name, age, gender, job, salary, phone, email, adhaar) " +
                           "VALUES ('" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + email + "', '" + adhaar + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee added successfully");

            setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddEmployees();
    }
}
