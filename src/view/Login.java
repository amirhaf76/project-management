package view;


import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

/** @noinspection ALL*/
public class Login extends JFrame{

    private JTextField usernameField = new JTextField(16);
    private JPasswordField passwordField = new JPasswordField(16);

    public Login() {
        super("Login");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        super.setLocation(screenSize.width/3, screenSize.height/3);
        super.setSize(screenSize.width/3, screenSize.height/3);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        super.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.weightx = 1;
        grid.weighty = 1;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.gridx = 0;
        grid.gridy = 0;



        // label
        Dimension labelDimension = new Dimension(super.getWidth()/5, super.getHeight()/5);
        JLabel username = new JLabel("Username");
        JLabel password = new JLabel("Password");

        username.setPreferredSize(labelDimension);
        password.setPreferredSize(labelDimension);


        super.add(username, grid);
        grid.gridy = 1;
        super.add(password, grid);


        // JTextField
        Dimension fieldDimension = new Dimension(4 * super.getWidth()/5, super.getHeight()/5);

        usernameField.setBounds(labelDimension.width, 0, fieldDimension.width, fieldDimension.height);
        passwordField.setBounds(labelDimension.width, fieldDimension.height, fieldDimension.width, fieldDimension.height);

        grid.gridwidth = 4;
        grid.gridheight = 1;
        grid.gridx = 1;
        grid.gridy = 0;
        super.add(usernameField, grid);
        grid.gridy = 1;
        super.add(passwordField, grid);


        JButton ok = new JButton("ok");
        JButton signUp = new JButton("sign Up");
        ok.setPreferredSize(new Dimension(labelDimension.width, labelDimension.height/2));
        signUp.setPreferredSize(new Dimension(labelDimension.width, labelDimension.height/2));

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO: 1/25/2020 check user from database
//                if () {
                    Login.super.setVisible(false);
                    ProjectsView projectsView = new ProjectsView();

//                }
//                else {
//                    javax.swing.JOptionPane.showMessageDialog(null ,
//                            "Your username or Your password is wrong !",
//                            "Error", JOptionPane.ERROR_MESSAGE);
//                }


            }
        });;
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp signUp = new SignUp();
            }
        });;

        grid.fill = GridBagConstraints.NONE;
        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 2;
        grid.anchor = GridBagConstraints.LAST_LINE_START;
        super.add(ok, grid);
        grid.gridx = 3;
        grid.anchor = GridBagConstraints.LAST_LINE_END;
        super.add(signUp, grid);

        super.pack();
        super.validate();
        super.setResizable(false);
        super.setVisible(true);
    }

}
