
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad extends JFrame implements ActionListener {

    JTextArea area;
    JFileChooser chooser;

    Notepad() {
        setTitle("My Notepad");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area = new JTextArea();
        area.setFont(new Font("Arial", Font.PLAIN, 16));
        add(new JScrollPane(area), BorderLayout.CENTER);

        chooser = new JFileChooser();

        JMenuBar mb = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        String[] fileItems = {"New", "Open", "Save", "Save As", "Exit"};
        String[] editItems = {"Cut", "Copy", "Paste"};

        for (String item : fileItems) {
            JMenuItem mi = new JMenuItem(item);
            mi.addActionListener(this);
            file.add(mi);
        }

        for (String item : editItems) {
            JMenuItem mi = new JMenuItem(item);
            mi.addActionListener(this);
            edit.add(mi);
        }

        mb.add(file);
        mb.add(edit);
        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case "New":
                    area.setText("");
                    break;

                case "Open":
                    if (chooser.showOpenDialog(this)
                            == JFileChooser.APPROVE_OPTION) {
                        File f = chooser.getSelectedFile();
                        BufferedReader br = new BufferedReader(
                                new FileReader(f));
                        area.read(br, null);
                        br.close();
                    }
                    break;

                case "Save":
                case "Save As":
                    if (chooser.showSaveDialog(this)
                            == JFileChooser.APPROVE_OPTION) {
                        File f = chooser.getSelectedFile();
                        BufferedWriter bw = new BufferedWriter(
                                new FileWriter(f));
                        bw.write(area.getText());
                        bw.close();
                    }
                    break;

                case "Cut":
                    area.cut();
                    break;

                case "Copy":
                    area.copy();
                    break;

                case "Paste":
                    area.paste();
                    break;

                case "Exit":
                    System.exit(0);
                    break;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "File operation failed: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Notepad();
    }
}
