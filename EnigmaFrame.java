import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class EnigmaFrame extends JFrame {

    // Construct JFRAME
    public EnigmaFrame() {
        setTitle("Enigma Machine");
        JTabbedPane tabPanel = new JTabbedPane();   

        JPanel page1 = new JPanel(); 
        page1.setLayout(new BoxLayout(page1, BoxLayout.Y_AXIS));
        JPanel page2 = new JPanel(new BorderLayout()); 


        // MARK: PAGE 1
        JPanel encryptDecryptPanel = new JPanel(new FlowLayout());
        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");
        encryptDecryptPanel.add(encryptButton);
        encryptDecryptPanel.add(decryptButton);

        JTextArea encryptTextField = new JTextArea();
        JTextArea decryptTextField = new JTextArea();
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
        JTextField initialPositionField = new JTextField(5);
        JComboBox<String> innerComboBox = new JComboBox<String>(rotors);
        JComboBox<String> middleComboBox = new JComboBox<String>(rotors);
        JComboBox<String> outerComboBox = new JComboBox<String>(rotors);


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


}