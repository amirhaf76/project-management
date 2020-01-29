package view;

import controller.Controller;
import model.User;
import org.jfree.data.category.CategoryRangeInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProject extends JFrame{
    private JTextField projectName = new JTextField(16);
    private ProjectsView projectsView;
    private static User user;

    public CreateProject(ProjectsView projectsView, User user) {
        this(user);
        this.projectsView = projectsView;
    }

    public CreateProject(User user) {
        super("Create Project");
        CreateProject.user = user;

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

        JLabel username = new JLabel("Enter name for project");


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

        projectName.setBounds(labelDimension.width, 0, fieldDimension.width, fieldDimension.height);

        grid.gridwidth = 4;
        grid.gridheight = 1;
        grid.gridx = 1;
        grid.gridy = 0;
        super.add(projectName, grid);
        grid.gridy = 1;

        JButton ok = new JButton("ok");
        ok.setBounds(0, 4 * labelDimension.height, labelDimension.width, labelDimension.height);


        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!projectName.getText().equals("")) {

                    // TODO: 1/27/2020 create Project and send it to database ok
                    try {

                        Controller controller = new Controller();
                        System.out.println("jf");
                        controller.fetchUserFromDbCreateProject(CreateProject.user.getUsername());
                        controller.sendProjectDataToDb(projectName.getText(), "", user.getId() );
                        System.out.println("jk");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    projectsView.updateProjectView();
                    CreateProject.super.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "Choose a name for the project !",
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

    public ProjectsView getProjectsView() {
        return projectsView;
    }

    public void setProjectsView(ProjectsView projectsView) {
        this.projectsView = projectsView;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        CreateProject.user = user;
    }
}
