package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** @noinspection ALL*/
public class AddTeam extends JFrame {

    private static JTextField teamName = new JTextField(16);

    public AddTeam() {
        super("Add Team");
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
        grid.anchor = grid.CENTER;

        frame.setResizable(false);
        frame.setVisible(true);

//        try {
//            Image image = ImageIO.read(new File("F:\\Amir\\pdf\\Software Engineering\\ProjectManagement\\DSC100256920.jpg"));
//            JLabel backGround = new JLabel( new ImageIcon(image.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT)));
//            frame.add(backGround);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        JLabel username = new JLabel("Enter name for team");


        Dimension labelDimension = new Dimension(2 * frame.getWidth()/5, frame.getHeight()/5);
        username.setPreferredSize(labelDimension);

        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.gridx = 0;
        grid.gridy = 0;

        frame.add(username, grid);
        grid.gridy = 1;

        // JTextField
        Dimension fieldDimension = new Dimension(3 * frame.getWidth()/5, frame.getHeight()/5);

        teamName.setBounds(labelDimension.width, 0, fieldDimension.width, fieldDimension.height);
//        teamName.setPreferredSize(fieldDimension);
//        emailField.setPreferredSize(fieldDimension);
//        passwordField.setPreferredSize(fieldDimension);
//        phoneField.setPreferredSize(fieldDimension);
//
//        teamName.setVisible(true);
//        emailField.setVisible(true);
//        passwordField.setVisible(true);
//        phoneField.setVisible(true);

        grid.gridwidth = 4;
        grid.gridheight = 1;
        grid.gridx = 1;
        grid.gridy = 0;
        frame.add(teamName, grid);
        grid.gridy = 1;



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

    public static JTextField getTeamName() {
        return teamName;
    }

    public static void setTeamName(JTextField teamName) {
        AddTeam.teamName = teamName;
    }
}
