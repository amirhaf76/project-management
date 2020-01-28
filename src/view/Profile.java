package view;

import model.User;
import view.com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** @noinspection ALL*/
public class Profile extends JFrame {

    private JLabel email1 = new JLabel("emial");
    private JLabel title1 = new JLabel("Username:");
    private JLabel phoneNumber1 = new JLabel("phoneNumber");
    private JTextField bio1 = new JTextField();


    private User user;
    public Profile() {
        super("Profile");
        createGUI();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        email1.setText(user.getEmail());
        title1.setText(user.getUsername());
        phoneNumber1.setText(user.getPhoneNumber());
        bio1.setText(user.getBio());
        super.validate();
    }

    private void createGUI() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize().getSize();
        Color color = new Color(105,105,105);

        // frame
        Dimension frameSize = new Dimension(400, 400);
        super.setVisible(false);
        super.setLayout(new BorderLayout());
        super.setSize(frameSize);
        super.setPreferredSize(frameSize);
        super.setLocation(screenSize.width/4, screenSize.height/4);
        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        super.setBackground(color);
        super.setResizable(false);

        //JLable
        Dimension labelDimension = new Dimension(frameSize.width/3, frameSize.height/3);
        JLabel title = new JLabel("Username:");
        JLabel email = new JLabel("emial");
        JLabel phoneNumber = new JLabel("phoneNumber");
        JLabel bio = new JLabel("bio");


        title.setPreferredSize(labelDimension);
        email.setPreferredSize(labelDimension);
        phoneNumber.setPreferredSize(labelDimension);
        bio.setPreferredSize(labelDimension);
        title1.setPreferredSize(labelDimension);
        email1.setPreferredSize(labelDimension);
        phoneNumber1.setPreferredSize(labelDimension);
        Dimension dimension = new Dimension(2 * frameSize.width / 3, 2 *frameSize.height / 3);


        bio1.setPreferredSize(dimension);




        JButton ok = new JButton("Ok");
        JButton cancel = new JButton("Cancel");
        ok.setPreferredSize(labelDimension);
        cancel.setPreferredSize(labelDimension);
        ok.setBackground(color);
        cancel.setBackground(color);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 1/27/2020 create task and send it to database
                // TODO: 1/27/2020 check information
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile.super.setVisible(false);
            }
        });

        // JPanel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setPreferredSize(frameSize);
        panel.setVisible(true);
        GridBagConstraints grid = new GridBagConstraints();
        panel.setBackground(color);

        grid.anchor = GridBagConstraints.CENTER;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.weightx = 1;
        grid.weighty = 1;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.gridx = 0;
        grid.gridy = 0;

        panel.add(title, grid);
        grid.gridy = 1;
        panel.add(phoneNumber, grid);
        grid.gridy = 2;
        panel.add(email, grid);
        grid.gridy = 3;
        panel.add(bio,grid);

        grid.gridx = 1;
        grid.gridy = 0;

        panel.add(title1, grid);
        grid.gridy = 1;
        panel.add(phoneNumber1, grid);
        grid.gridy = 2;
        panel.add(email1, grid);
        grid.gridy = 3;
        panel.add(bio1,grid);

        grid.gridy = 4;
        grid.gridx = 0;
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.LAST_LINE_START;
        panel.add(ok, grid);
        grid.gridx = 1;
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.LAST_LINE_END;
        panel.add(cancel, grid);


        panel.validate();

        super.getContentPane().add(panel, BorderLayout.CENTER);
        super.pack();
        super.validate();
        super.setVisible(true);


    }
}
