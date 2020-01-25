package view;


import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/** @noinspection ALL*/
public class Login extends JFrame{

    private static JTextField usernameField = new JTextField(16);
    private static JPasswordField passwordField = new JPasswordField(16);

    public Login() {
        super("Login");
        JFrame frame = this;

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
//
//        try {
//            Image image = ImageIO.read(new File("F:\\Amir\\pdf\\Software Engineering\\ProjectManagement\\DSC100256920.jpg"));
//            JLabel backGround = new JLabel( new ImageIcon(image.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT)));
//            frame.getLayeredPane().add(backGround, JLayeredPane.FRAME_CONTENT_LAYER);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        JLabel username = new JLabel("Username");
        JLabel password = new JLabel("Password");


        Dimension labelDimension = new Dimension(frame.getWidth()/5, frame.getHeight()/5);
        username.setPreferredSize(labelDimension);
        password.setPreferredSize(labelDimension);

        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.gridx = 0;
        grid.gridy = 0;

        frame.add(username, grid);
        grid.gridy = 1;
        frame.add(password, grid);


        // JTextField
        Dimension fieldDimension = new Dimension(4 * frame.getWidth()/5, frame.getHeight()/5);

        usernameField.setBounds(labelDimension.width, 0, fieldDimension.width, fieldDimension.height);
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



        JButton ok = new JButton("ok");
        ok.setBounds(0, 4 * labelDimension.height, labelDimension.width, labelDimension.height);


        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 1/25/2020 create user and send it to database
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

    public static JPasswordField getPasswordField() {
        return passwordField;
    }
}
