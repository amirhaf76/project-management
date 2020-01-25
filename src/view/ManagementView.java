package view;

import model.Task;
import model.Team;
import model.TeamMember;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ManagementView extends JFrame {
    public static void main(String[] atgs) {

        Login login = new Login();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize().getSize();

        GanttChart ganttChart = new GanttChart("hello", new ArrayList<>());

        // frame
        Dimension frameSize = new Dimension(1000, 400);
        JFrame frame  = new JFrame("Project Management");
        frame.setLayout(null);
        frame.setSize(frameSize);
        frame.setLocation(screenSize.width/8, screenSize.height/4);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);

        // list
        Dimension listDimension = new Dimension(frameSize.width / 5, frameSize.height / 5);
        JList<Task> todo = new JList<>();
        JList<Task> doing = new JList<>();
        JList<Task> done = new JList<>();
        JList<Team> teamJList = new JList<>();
        JList<TeamMember> teamMemberJList = new JList<>();

        todo.setBackground(Color.cyan);
        doing.setBackground(Color.red);
        done.setBackground(Color.gray);
        teamJList.setBackground(Color.YELLOW);
        teamMemberJList.setBackground(Color.black);

        todo.setPreferredSize(listDimension);
        doing.setPreferredSize(listDimension);
        done.setPreferredSize(listDimension);
        teamJList.setPreferredSize(listDimension);
        teamMemberJList.setPreferredSize(listDimension);

        // panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setSize(frameSize);
        GridBagConstraints grid = new GridBagConstraints();

//        grid.fill = GridBagConstraints.HORIZONTAL;
//        grid.gridy = 0;
//        grid.gridx = 0;
//        grid.gridheight = 1;
//        grid.gridwidth = 1;
//        grid.weightx = 1;
//        grid.weighty = 1;
//        grid.anchor = GridBagConstraints.CENTER;
//
//        panel.add(teamJList, grid);
//        grid.gridx = 1;
//        panel.add(teamMemberJList, grid);
//        grid.gridx = 2;
//        panel.add(todo, grid);
//        grid.gridx = 3;
//        panel.add(doing, grid);
//        grid.gridx = 4;
//        panel.add(done, grid);

        frame.getContentPane().add(panel);
//        frame.pack();
        frame.invalidate();

    }
}
