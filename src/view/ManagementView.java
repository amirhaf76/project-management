package view;


import model.Task;
import model.Team;
import model.TeamMember;
import model.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/** @noinspection ALL*/
public class ManagementView extends JFrame{

    private User user;

    public ManagementView(User user) {
        super("Project Management");
        this.user = user;
        createGUI();
    }

    private void createGUI() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize().getSize();

        GanttChart ganttChart = new GanttChart("hello", new ArrayList<>());

        // frame
        Dimension frameSize = new Dimension(1000, 500);
        super.setVisible(false);
        super.setLayout(new BorderLayout());
        super.setSize(frameSize);
        super.setPreferredSize(frameSize);
        super.setLocation(screenSize.width/8, screenSize.height/4);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setBackground(new Color(105,105,105));
        super.setResizable(false);



        // label
        Dimension labelDimension = new Dimension(frameSize.width / 5,frameSize.height /5);
        JLabel usernameLabel = new JLabel("Username");
        JLabel usernameLabel2 = new JLabel("<Username>");
        JLabel typeOfUserLabel = new JLabel("type");
        JLabel typeOfUserLabel2 = new JLabel("<type>");
        JButton closeProjectButton = new JButton("Close Project");

        usernameLabel.setPreferredSize(labelDimension);
        typeOfUserLabel.setPreferredSize(labelDimension);
        closeProjectButton.setPreferredSize(new Dimension(labelDimension.width/2, labelDimension.height / 2));

        closeProjectButton.setBackground(new Color(105,105,105));
//        closeProjectButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        closeProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // list
        String[] s = new String[]{"hello", "hi"};
        Task[] tasks = new Task[2];
        Team[] teams =new Team[2];
        TeamMember[] teamMembers = new TeamMember[5];

        Dimension listDimension = new Dimension(frameSize.width / 5,  frameSize.height-100);
        PmJList<String> todo = new PmJList<>("ToDo", s);
        PmJList<Task> doing = new PmJList<>("Doing", tasks);
        PmJList<Task> done = new PmJList<>("Done", tasks);
        PmJList<Team> teamJList = new PmJList<>("Team", teams);
        PmJList<TeamMember> teamMemberJList = new PmJList<>("Team member", teamMembers);

        todo.setPreferredSize(listDimension);
        todo.setSize(listDimension);
        doing.setPreferredSize(listDimension);
        doing.setSize(listDimension);
        done.setPreferredSize(listDimension);
        done.setSize(listDimension);
        teamJList.setPreferredSize(listDimension);
        teamJList.setSize(listDimension);
        teamMemberJList.setPreferredSize(listDimension);
        teamMemberJList.setSize(listDimension);

        todo.addTaskPropertyToPopUp();doing.addTaskPropertyToPopUp();done.addTaskPropertyToPopUp();
        teamJList.addTeamToPopUp();
        teamMemberJList.addTeamMemberPropertyToPopUp();teamMemberJList.addTeamMemberToPopUp();

        createListener(todo);
        createListener(doing);
        createListener(done);
        createListener(teamJList);
        createListener(teamMemberJList);


        // main panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setPreferredSize(new Dimension(frameSize.width, 4*frameSize.height/5));
        panel.setVisible(true);
        GridBagConstraints grid = new GridBagConstraints();


        // head panel
        JPanel head = new JPanel(new GridBagLayout());
        head.setPreferredSize(new Dimension(frameSize.width, frameSize.height/5));
        head.setVisible(true);

        grid.anchor = GridBagConstraints.CENTER;
        grid.fill = GridBagConstraints.BOTH;
        grid.weighty = 1;
        grid.weightx = 1;
        grid.gridheight = 1;
        grid.gridwidth = 1;
        grid.ipadx = 0;
        grid.ipady = 0;


        // add to main panel
        panel.add(this.createJScrollPane(teamJList, listDimension, "Team"), grid);
        grid.gridx = 1;
        panel.add(this.createJScrollPane(teamMemberJList, listDimension, "Team member"), grid);
        grid.gridx = 2;
        panel.add(this.createJScrollPane(todo, listDimension, "To Do"), grid);
        grid.gridx = 3;
        panel.add(this.createJScrollPane(doing, listDimension, "Doing"), grid);
        grid.gridx = 4;
        panel.add(this.createJScrollPane(done, listDimension, "Done"), grid);
        panel.setBackground(new Color(105,105,105));
        panel.validate();

        // add to head
        grid.gridx = 0;
        head.add(usernameLabel, grid);
        grid.gridy = 1;
        head.add(typeOfUserLabel, grid);
        grid.gridx = 1;
        grid.gridy= 0;
        head.add(usernameLabel2, grid);
        grid.gridy = 1;
        head.add(typeOfUserLabel2, grid);
        grid.gridx = 2;
        grid.gridy = 0;
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.EAST;
        head.add(closeProjectButton, grid);
        head.setBackground(new Color(105,105,105));


        super.pack();
        super.getContentPane().add(panel, BorderLayout.CENTER);
        super.getContentPane().add(head, BorderLayout.NORTH);
        super.validate();
        super.setVisible(true);
    }

    private JScrollPane createJScrollPane(Component component, Dimension dimension, String name) {
        JScrollPane sp = new JScrollPane(component);
        sp.setSize(dimension);
        sp.setPreferredSize(dimension);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        LineBorder line = new LineBorder(Color.BLACK, 2);
        TitledBorder title = new TitledBorder(line, name );
        title.setTitleJustification(TitledBorder.CENTER);
        sp.setBorder(title);
        Color color = new Color(105,105,105);
        sp.setBackground(color);

        return sp;
    }

    private void createListener(PmJList list) {
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if ( e.BUTTON3 == e.getButton()) {
                    list.getPopupMenu().show(list, e.getX(), e.getY());
                    System.out.println(list);
                }
                if (e.getClickCount() == 2)
                    list.clearSelection();
            }
        });
    }


}



