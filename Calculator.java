
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {

    TextField tf;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Button add, sub, mul, div, equal, clear;

    double num1, num2, result;
    char operator;

    Calculator() {
        setTitle("AWT Calculator");
        setSize(300, 350);
        setLayout(new BorderLayout());

        tf = new TextField();
        tf.setEditable(false);
        add(tf, BorderLayout.NORTH);

        Panel p = new Panel();
        p.setLayout(new GridLayout(4, 4, 5, 5));

        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        div = new Button("/");

        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        mul = new Button("*");

        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        sub = new Button("-");

        b0 = new Button("0");
        clear = new Button("C");
        equal = new Button("=");
        add = new Button("+");

        Button[] buttons = {
                b7, b8, b9, div,
                b4, b5, b6, mul,
                b1, b2, b3, sub,
                b0, clear, equal, add
        };

        for (Button b : buttons) {
            p.add(b);
            b.addActionListener(this);
        }

        add(p, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("C")) {
            tf.setText("");
        } else if (s.equals("+") || s.equals("-")
                || s.equals("*") || s.equals("/")) {
            num1 = Double.parseDouble(tf.getText());
            operator = s.charAt(0);
            tf.setText("");
        } else if (s.equals("=")) {
            num2 = Double.parseDouble(tf.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        tf.setText("Cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            tf.setText(String.valueOf(result));
        } else {
            tf.setText(tf.getText() + s);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
