import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {

    Dashboard() {
        setTitle("Dashboard");
        setBounds(0, 0, 1550, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Custom panel with background image
        JPanel backgroundPanel = new JPanel() {
            Image bg = new ImageIcon("C:\\Users\\skssa\\OneDrive\\Desktop\\PROJECTS\\third.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };

        backgroundPanel.setLayout(new BorderLayout());

        // Text label
        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU", SwingConstants.CENTER);
        text.setFont(new Font("Tahoma", Font.BOLD, 46));
        text.setForeground(Color.WHITE);
        backgroundPanel.add(text, BorderLayout.NORTH);

        setContentPane(backgroundPanel);

        // Menu bar
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        // HOTEL MANAGEMENT MENU
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        // ADMIN MENU
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem addemployees = new JMenuItem("ADD EMPLOYEES");
        addemployees.addActionListener(this);
        admin.add(addemployees);

        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem addrivers = new JMenuItem("ADD DRIVERS");
        addrivers.addActionListener(this);
        admin.add(addrivers);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals("ADD EMPLOYEES")) {
            new AddEmployees();   // opens AddEmployees JFrame
        } else if (command.equals("ADD ROOMS")) {
            new AddRooms();       // opens AddRooms JFrame
        } else if (command.equals("RECEPTION")) {
            JOptionPane.showMessageDialog(this, "Reception Module Coming Soon!");
        } else if (command.equals("ADD DRIVERS")) {
            new AddDrivers();     // opens AddDrivers JFrame
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
