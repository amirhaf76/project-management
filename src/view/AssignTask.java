package view;

import model.Task;
import model.Team;
import model.TeamMember;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignTask extends JFrame {

    public AssignTask(Task task, Team[] teams , TeamMember[] teamMembers)  {
        super("Assign a Task");
        Dimension frameSize = new Dimension(200, 600);
        super.setVisible(false);
        super.setLayout(new BorderLayout());
        super.setSize(frameSize);
        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(null);

        // JComboBox
        Dimension comboBoxDimension = new Dimension(frameSize.width, frameSize.height/3);
        JComboBox<Team>  teamsBox = new JComboBox<>(teams);
        JComboBox<TeamMember> teamMemberBox = new JComboBox<>(teamMembers);

        teamsBox.setPreferredSize(comboBoxDimension);
        teamMemberBox.setPreferredSize(comboBoxDimension);

        // JButton
        JButton ok = new JButton("Ok");
        ok.setPreferredSize(new Dimension(frameSize.width/3, frameSize.height/3));
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 1/27/2020 update teamMembers in database

            }
        });

        // JPanel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(frameSize);
        panel.setVisible(true);
        panel.setBackground(new Color(105,105,105));

        panel.add(teamsBox, BorderLayout.NORTH);
        panel.add(teamMemberBox, BorderLayout.CENTER);
        panel.add(ok, BorderLayout.SOUTH);
        panel.validate();

        super.add(panel, BorderLayout.CENTER);
        super.validate();
        super.setVisible(true);
    }
}
