package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static javax.swing.JOptionPane.*;

public class CreateTask {
    private static JLabel username = new JLabel("Username");
    private static JLabel password = new JLabel("Password");
    private static JLabel email = new JLabel("Email");
    private static JLabel phoneNumber = new JLabel("Phone number");

    private static JTextField usernameField = new JTextField(16);
    private static JTextField emailField = new JTextField(16);
    private static JTextField phoneField = new JTextField(16);
    private static JPasswordField passwordField = new JPasswordField(16);
    public static void main(String[] args) {
        JFrame frame = new JFrame("Create Task");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setLocation(screenSize.width/3, screenSize.height/3);
        frame.setSize(screenSize.width/3, screenSize.height/3);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.weightx = 1;
        grid.weighty = 1;

        frame.setResizable(false);
        frame.setVisible(true);

//        try {
//            Image image = ImageIO.read(new File("F:\\Amir\\pdf\\Software Engineering\\ProjectManagement\\DSC100256920.jpg"));
//            JLabel backGround = new JLabel( new ImageIcon(image.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT)));
//            frame.add(backGround);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        Dimension labelDimension = new Dimension(frame.getWidth()/5, frame.getHeight()/5);
        username.setPreferredSize(labelDimension);
        password.setPreferredSize(labelDimension);
        email.setPreferredSize(labelDimension);
        phoneNumber.setPreferredSize(labelDimension);

        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.gridx = 0;
        grid.gridy = 0;

        frame.add(username, grid);
        grid.gridy = 1;
        frame.add(password, grid);
        grid.gridy = 2;
        frame.add(email, grid);
        grid.gridy = 3;
        frame.add(phoneNumber, grid);


        // JTextField
        Dimension fieldDimension = new Dimension(4 * frame.getWidth()/5, frame.getHeight()/5);

        usernameField.setBounds(labelDimension.width, 0, fieldDimension.width, fieldDimension.height);
        emailField.setBounds(labelDimension.width, 3 * fieldDimension.height, fieldDimension.width, fieldDimension.height);
        phoneField.setBounds(labelDimension.width, 2 * fieldDimension.height, fieldDimension.width, fieldDimension.height);
        passwordField.setBounds(labelDimension.width, fieldDimension.height, fieldDimension.width, fieldDimension.height);

//        usernameField.setPreferredSize(fieldDimension);
//        emailField.setPreferredSize(fieldDimension);
//        passwordField.setPreferredSize(fieldDimension);
//        phoneField.setPreferredSize(fieldDimension);
//
//        usernameField.setVisible(true);
//        emailField.setVisible(true);
//        passwordField.setVisible(true);
//        phoneField.setVisible(true);

        grid.gridwidth = 4;
        grid.gridheight = 1;
        grid.gridx = 1;
        grid.gridy = 0;
        frame.add(usernameField, grid);
        grid.gridy = 1;
        frame.add(passwordField, grid);
        grid.gridy = 2;
        frame.add(phoneField, grid);
        grid.gridy = 3;
        frame.add(emailField, grid);



        JButton ok = new JButton("ok");
        ok.setBounds(0, 4 * labelDimension.height, labelDimension.width, labelDimension.height);


        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(usernameField.getText());
            }
        });
        grid.gridwidth = 5;
        grid.gridheight = 1;
        grid.gridx = 0;
        grid.gridy = 4;

        frame.add(ok, grid, 1);
        frame.pack();
        frame.validate();

    }

    public static JTextField getUsernameField() {
        return usernameField;
    }

    public static JTextField getEmailField() {
        return emailField;
    }

    public static JTextField getPhoneField() {
        return phoneField;
    }

    public static JPasswordField getPasswordField() {
        return passwordField;
    }
}
