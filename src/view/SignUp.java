package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/** @noinspection ALL*/
public class SignUp extends JFrame{

    private JTextField usernameField = new JTextField(16);
    private JTextField emailField = new JTextField(16);
    private JTextField phoneField = new JTextField(16);
    private JPasswordField passwordField = new JPasswordField(16);

    public SignUp () {
        super("Sign Up");
        JFrame frame = this;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setLocation(screenSize.width/3, screenSize.height/3);
        frame.setSize(screenSize.width/3, screenSize.height/3);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.weightx = 1;
        grid.weighty = 1;

        frame.setResizable(false);
        frame.setVisible(true);



        JLabel username = new JLabel("Username");
        JLabel password = new JLabel("Password");
        JLabel email = new JLabel("Email");
        JLabel phoneNumber = new JLabel("Phone number");


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
                Controller controller = new Controller();

                if (usernameField.getText().equals("") || passwordField.getText().equals("") ||
                phoneField.getText().equals("") || emailField.getText().equals("") ) {
                    javax.swing.JOptionPane.showMessageDialog(null ,
                        "Check Fields !",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    // TODO: 1/25/2020 create user and send it to database ok
                    try {
                        controller.sendUserDataToDb(usernameField.getText(),
                                passwordField.getText(),
                                emailField.getText(),
                                phoneField.getText());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    SignUp.super.setVisible(false);
                }
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

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public void setPhoneField(JTextField phoneField) {
        this.phoneField = phoneField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }
}
