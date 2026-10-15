
import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    LoginForm() {
        setTitle("Login Form");
        setSize(350, 200);
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton submit = new JButton("Submit");

        add(nameLabel);
        add(nameField);
        add(passLabel);
        add(passField);
        add(new JLabel(""));
        add(submit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
