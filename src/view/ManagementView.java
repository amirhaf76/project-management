package view;


import controller.Controller;
import model.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/** @noinspection ALL*/
public class ManagementView extends JFrame{

    private User user;
    private static ArrayList<Task> tasks;
    private static ArrayList<Team> teams;
    private static ArrayList<TeamMember> teamMembers;
    private GanttChart ganttChart;
    private Project project;



    public ManagementView(User user, Project project) {
        super("Project Management");
        this.user = user;
        this.project = project;
        try {
            createGUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createGUI() throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize().getSize();

        ganttChart = new GanttChart( new ArrayList<>());
        ganttChart.openGantt();

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

        usernameLabel.setPreferredSize(labelDimension);
        typeOfUserLabel.setPreferredSize(labelDimension);

        // JButton
        JButton closeProjectButton = new JButton("Close Project");
        closeProjectButton.setPreferredSize(new Dimension(labelDimension.width/2, labelDimension.height / 2));
        closeProjectButton.setBackground(new Color(105,105,105));
//        closeProjectButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        closeProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProjectsView(user);
                ManagementView.super.setVisible(false);
                ganttChart.setVisible(false);
            }
        });

        // PmJList
        // TODO: 1/27/2020 get all teams of Project from database ok
        Controller controller = new Controller();
        try {
            controller.fetchProjectsFromDb(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Task[] tasks = new Task[2];
        Team[] teams =new Team[2];
        TeamMember[] teamMembers = new TeamMember[5];

        Dimension listDimension = new Dimension(frameSize.width / 5,  frameSize.height-100);
        PmJList<Task> todo = new PmJList<>("ToDo", new Task[0]); // her !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!111111111
        PmJList<Task> doing = new PmJList<>("Doing", new Task[0]);
        PmJList<Task> done = new PmJList<>("Done", new Task[0]);
        PmJList<Team> teamJList = new PmJList<>("Team", new Team[0]);
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

        // TODO: 1/28/2020 if the user is manager ok
        if (controller.checkUserIsmanager(project.getId(), user.getId()) ){
            todo.addTaskPropertyToPopUp();doing.addTaskPropertyToPopUp();done.addTaskPropertyToPopUp();
            todo.addAssignTaskToPopUp();doing.addAssignTaskToPopUp();done.addAssignTaskToPopUp();
            teamJList.addTeamToPopUp();
            teamMemberJList.addAddTeamMemberToPopUp();
            todo.creatTask();
        }
        else {

            todo.addTaskPropertyToPopUp();doing.addTaskPropertyToPopUp();done.addTaskPropertyToPopUp();
            todo.addSetPercentageToPopUp();doing.addSetPercentageToPopUp();done.addSetPercentageToPopUp();
        }

        // TODO: 1/28/2020 else ok



        createListener(todo);
        createListener(doing);
        createListener(done);
        createListener(teamJList);
        createListener(teamMemberJList);

        teamJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if ( !e.getValueIsAdjusting() ) {
                    updateTeamMemberAndTasks();
                    teamMemberJList.clearSelection();
                }
            }
        });

        teamMemberJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if ( !e.getValueIsAdjusting() ) {
                    updateTasks();
                }
            }
        });


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

    private void updateTasks() {
        Controller controller = new Controller();
        try {
            controller.fetchTeamMembersFromDb(project.getId());
            controller.fetchTasksFromDb(project.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.validate();
        // TODO: 1/28/2020 get team members from database ok
        // TODO: 1/28/2020 get tasks from database ok

    }

    private void updateTeamMemberAndTasks() {
        // TODO: 1/28/2020 get tasks from database ok
        Controller controller = new Controller();
        try {
            controller.fetchTasksFromDb(project.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.validate();
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


    public void updateManagementView() {
        // TODO: 1/28/2020 get all tasks of project from database ok
        Controller controller = new Controller();
        try {
            controller.fetchTasksFromDb(project.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ganttChart.updateGantt(tasks);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void setTasks(ArrayList<Task> tasks) {
        ManagementView.tasks = tasks;
    }

    public static ArrayList<Team> getTeams() {
        return teams;
    }

    public static void setTeams(ArrayList<Team> teams) {
        ManagementView.teams = teams;
    }

    public static ArrayList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public static void setTeamMembers(ArrayList<TeamMember> teamMembers) {
        ManagementView.teamMembers = teamMembers;
    }

    public GanttChart getGanttChart() {
        return ganttChart;
    }

    public void setGanttChart(GanttChart ganttChart) {
        this.ganttChart = ganttChart;
    }
}



