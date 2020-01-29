package view;

import controller.Controller;
import model.Task;
import model.Team;
import model.TeamMember;
import model.User;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignTask extends JFrame {

    private JTextField username = new JTextField(16);
    private static User user;

    public AssignTask(Task task) {
        super("Assign a task");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        super.setLocation(screenSize.width/3, screenSize.height/3);
        super.setSize(screenSize.width/3, screenSize.height/3);
        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        super.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.weightx = 1;
        grid.weighty = 1;
        grid.anchor = GridBagConstraints.CENTER;

        JLabel username = new JLabel("Enter name for team");


        Dimension labelDimension = new Dimension(2 * super.getWidth()/5, super.getHeight()/5);
        username.setPreferredSize(labelDimension);

        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.gridx = 0;
        grid.gridy = 0;

        super.add(username, grid);
        grid.gridy = 1;

        // JTextField
        Dimension fieldDimension = new Dimension(3 * super.getWidth()/5, super.getHeight()/5);

        this.username.setBounds(labelDimension.width, 0, fieldDimension.width, fieldDimension.height);

        grid.gridwidth = 4;
        grid.gridheight = 1;
        grid.gridx = 1;
        grid.gridy = 0;
        super.add(this.username, grid);
        grid.gridy = 1;

        JButton ok = new JButton("ok");
        ok.setBounds(0, 4 * labelDimension.height, labelDimension.width, labelDimension.height);


        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!AssignTask.this.username.getText().equals("")) {
                    Controller controller = new Controller();
                    try {
                        controller.fetchUserFromDbAssignTask(AssignTask.this.username.getText());
                        controller.sendTaskAssignmentDataToDb(task.getId(),  user.getId());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    // TODO: 1/25/2020 add teammember to the task in database
                    AssignTask.super.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "Choose a name for the team !",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        super.add(ok, grid, 1);
        super.pack();
        super.validate();
        super.setResizable(false);
        super.setVisible(true);

    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        AssignTask.user = user;
    }
}
