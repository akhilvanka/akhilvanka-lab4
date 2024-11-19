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

        // Text Area
        JTextArea encryptTextField = new JTextArea();
        JTextArea decryptTextField = new JTextArea();

        page1.add(encryptTextField);
        page1.add(encryptDecryptPanel);
        page1.add(decryptTextField);
        

        tabPanel.addTab("Enigma", page1); 
        tabPanel.addTab("Settings", page2); 

        add(tabPanel);
    }


}