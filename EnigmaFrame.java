import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {

    private JTextArea decryptTextField;
    private JTextArea encryptTextField;

    private JComboBox<String> innerComboBox;
    private JComboBox<String> middleComboBox;
    private JComboBox<String> outerComboBox;

    private JTextField initialPositionField;

    // Construct JFRAME
    public EnigmaFrame() {
        super();
        setTitle("Enigma Machine");
        JTabbedPane tabPanel = new JTabbedPane();   

        JPanel page1 = new JPanel(); 
        page1.setLayout(new BoxLayout(page1, BoxLayout.Y_AXIS));
        JPanel page2 = new JPanel(new BorderLayout()); 

        // MARK: PAGE 1
        JPanel encryptDecryptPanel = new JPanel(new FlowLayout());
        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");
        EnigmaListener listener = new EnigmaListener();
        encryptButton.addActionListener(listener);
        decryptButton.addActionListener(listener);
        encryptDecryptPanel.add(encryptButton);
        encryptDecryptPanel.add(decryptButton);

        encryptTextField = new JTextArea();
        decryptTextField = new JTextArea();
        JPanel encryptPanel = new JPanel(new BorderLayout());
        JPanel decryptPanel = new JPanel(new BorderLayout());
        encryptPanel.add(new JLabel(" Encrypt: "), BorderLayout.WEST);
        encryptPanel.add(encryptTextField);
        decryptPanel.add(new JLabel(" Decrypt: "), BorderLayout.WEST);
        decryptPanel.add(decryptTextField);

        page1.add(encryptPanel);
        page1.add(encryptDecryptPanel);
        page1.add(decryptPanel);
        

        // MARK: PAGE 2 
        String rotors[] = {"1", "2", "3", "4", "5"};
        JPanel settingsPanel = new JPanel(new FlowLayout());
        initialPositionField = new JTextField(5);
        innerComboBox = new JComboBox<String>(rotors);
        middleComboBox = new JComboBox<String>(rotors);
        outerComboBox = new JComboBox<String>(rotors);


        settingsPanel.add(new JLabel("Inner:"));
        settingsPanel.add(innerComboBox);
        settingsPanel.add(new JLabel("Middle:"));
        settingsPanel.add(middleComboBox);
        settingsPanel.add(new JLabel("Outer:"));
        settingsPanel.add(outerComboBox);
        settingsPanel.add(new JLabel("Initial Position:"));
        settingsPanel.add(initialPositionField);

        page2.add(settingsPanel, BorderLayout.NORTH);

        tabPanel.addTab("Enigma", page1); 
        tabPanel.addTab("Settings", page2); 

        add(tabPanel);
    }

    private class EnigmaListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int inner = Integer.parseInt((String) innerComboBox.getSelectedItem());
            int middle = Integer.parseInt((String) middleComboBox.getSelectedItem());
            int outer = Integer.parseInt((String) outerComboBox.getSelectedItem());
            String initialPosition = initialPositionField.getText();
            String input = encryptTextField.getText();
            String output = decryptTextField.getText();

            Enigma enigma = new Enigma(inner, middle, outer, initialPosition);

            if (e.getActionCommand().equals("Encrypt")) {
                String encryptedMessage = enigma.encrypt(input);
                decryptTextField.setText(encryptedMessage);
            } else if (e.getActionCommand().equals("Decrypt")) {
                String decryptedMessage = enigma.decrypt(output);
                encryptTextField.setText(decryptedMessage);
            }
        }
   }


}