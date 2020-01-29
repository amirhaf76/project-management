package view;

import controller.Controller;
import model.Project;
import model.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.PrimitiveIterator;

/** @noinspection ALL*/
public class ProjectsView extends JFrame {

    private static User user;
    private  JLabel username = new JLabel("username");
    private static ArrayList<Project> projects = new ArrayList<>();
    private PmJList<Project> projectPmJList;

    public ProjectsView(User user){
        super("Project View");
        this.user = user;
        Controller controller = new Controller();
        try {System.out.println(user);
            controller.fetchProjectsFromDb(this.user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        createGraphic();
    }

    private void createGraphic() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize().getSize();
        Color color = new Color(105,105,105);
        ProjectsView projectsView = this;

        // frame
        Dimension frameSize = new Dimension(500, 500);
        super.setVisible(false);
        super.setLayout(new BorderLayout());
        super.setSize(frameSize);
        super.setPreferredSize(frameSize);
        super.setLocation(screenSize.width/4, screenSize.height/4);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setBackground(color);
        super.setResizable(false);

        // JLabel
        Dimension labelDimension = new Dimension (frameSize.width/3, frameSize.height /3);
        JLabel profile = new JLabel("Profile");



        profile.setPreferredSize(labelDimension);
        username.setPreferredSize(labelDimension);
        profile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2);
                    Profile profile1 = new Profile();
                    profile1.setUser(user);
            }
        });



        // JList

        Project[] p = new Project[projects.size()];
        projects.toArray(p);
        Dimension listDimension = new Dimension(frameSize.width, frameSize.height);
        projectPmJList = new PmJList<>("Project",
                p);
        projectPmJList.setPreferredSize(listDimension);

        JScrollPane sp = new JScrollPane(projectPmJList);
        sp.setSize(listDimension);
        sp.setPreferredSize(listDimension);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        LineBorder line = new LineBorder(Color.BLACK, 2);
        TitledBorder title = new TitledBorder(line, "Project" );
        title.setTitleJustification(TitledBorder.CENTER);
        sp.setBorder(title);
        sp.setBackground(color);

        // JButton
        Dimension buttonDimension = new Dimension(frameSize.width/3,
                frameSize.height/3);
        JButton openProject = new JButton("Open");
        JButton createProject = new JButton("Create project");

        openProject.setPreferredSize(buttonDimension);
        createProject.setPreferredSize(buttonDimension);

        openProject.setBackground(color);
        createProject.setBackground(color);

        openProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ManagementView(user, projectPmJList.getList()[projectPmJList.getSelectedIndex()]);
                ProjectsView.super.setVisible(false);
            }
        });
        createProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CreateProject vp = new CreateProject(projectsView, user);

            }
        });


        // JPanel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setPreferredSize(frameSize);
        panel.setVisible(true);
        GridBagConstraints grid = new GridBagConstraints();
        panel.setBackground(color);

        grid.anchor = GridBagConstraints.FIRST_LINE_START;
        grid.fill = GridBagConstraints.NONE;
        grid.weightx = 1;
        grid.weighty = 1;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.gridx = 0;
        grid.gridy = 0;

        panel.add(profile, grid);
        grid.gridx = 2;
        grid.anchor = GridBagConstraints.FIRST_LINE_END;
        panel.add(username, grid);
        grid.anchor = GridBagConstraints.CENTER;
        grid.fill = GridBagConstraints.BOTH;
        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 3;
        panel.add(sp, grid);
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.LAST_LINE_START;
        grid.gridy = 2;
        grid.gridwidth = 1;
        panel.add(createProject, grid);
        grid.anchor = GridBagConstraints.LAST_LINE_END;
        grid.gridx = 2;
        panel.add(openProject, grid);

        panel.validate();

        super.getContentPane().add(panel, BorderLayout.CENTER);
        super.pack();
        super.validate();
        super.setVisible(true);


    }


    public void updateProjectView(){
        // TODO: 1/27/2020 get list of project from database
        Controller controller = new Controller();
        try {
            controller.fetchProjectsFromDb(ProjectsView.user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Project[] p = new Project[projects.size()];
        projects.toArray(p);
        projectPmJList.setList(p);
        projectPmJList.validate();
        super.validate();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setText() {
        username.setText(user.getUsername());
    }



    public static ArrayList<Project> getProjects() {
        return projects;
    }

    public static void setProjects(ArrayList<Project> projects) {
        ProjectsView.projects = projects;
    }
}
