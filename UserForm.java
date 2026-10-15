
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UserForm extends JFrame {

    JTextField nameField;
    JPasswordField passField;
    JButton submit;

    UserForm() {
        setTitle("User Form");
        setSize(350, 200);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Password:"));
        passField = new JPasswordField();
        add(passField);

        submit = new JButton("Submit");
        add(new JLabel(""));
        add(submit);

        submit.addActionListener(e -> saveData());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void saveData() {
        String name = nameField.getText();
        String password = new String(passField.getPassword());

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/LoginDB",
                    "root",
                    "your_password"
            );

            String sql = "INSERT INTO users VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, password);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Data saved successfully!");

            nameField.setText("");
            passField.setText("");

            ps.close();
            con.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Database Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new UserForm();
    }
}
