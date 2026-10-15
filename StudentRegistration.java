
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class StudentRegistration extends JFrame implements ActionListener {

    JTextField nameField, rollField, courseField, emailField;
    JButton registerButton;

    StudentRegistration() {
        setTitle("Student Registration Portal");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        panel.add(rollField);

        panel.add(new JLabel("Course:"));
        courseField = new JTextField();
        panel.add(courseField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);

        panel.add(new JLabel(""));
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText().trim();
        String roll = rollField.getText().trim();
        String course = courseField.getText().trim();
        String email = emailField.getText().trim();

        if (name.isEmpty() || roll.isEmpty()
                || course.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this, "Please fill all the fields!");
            return;
        }

        File file = new File("students.csv");
        boolean addHeader = !file.exists() || file.length() == 0;

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(file, true))) {

            if (addHeader) {
                writer.println("Name,Roll Number,Course,Email");
            }

            writer.println(
                    "\"" + name.replace("\"", "\"\"") + "\","
                            + "\"" + roll.replace("\"", "\"\"") + "\","
                            + "\"" + course.replace("\"", "\"\"") + "\","
                            + "\"" + email.replace("\"", "\"\"") + "\""
            );

            JOptionPane.showMessageDialog(
                    this, "Registration Successful!");

            nameField.setText("");
            rollField.setText("");
            courseField.setText("");
            emailField.setText("");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    this, "Error saving student details!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentRegistration();
        });
    }
}
