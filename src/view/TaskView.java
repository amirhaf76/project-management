package view;

import model.Task;

import javax.swing.*;
import java.awt.*;

/** @noinspection ALL*/
public class TaskView extends JFrame {

    public TaskView(Task task) {
        super(task.getName());
        createGUI(task);
    }

    private void createGUI(Task task) {

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
        Dimension labelDimension = new Dimension(frameSize.width/2, frameSize.height/2);
        JLabel title = new JLabel("Title:");
        JLabel state = new JLabel("State:");
        JLabel percentage = new JLabel("Percentage:");
        JLabel start = new JLabel("Start:");
        JLabel end = new JLabel("End:");

        title.setPreferredSize(labelDimension);
        state.setPreferredSize(labelDimension);
        percentage.setPreferredSize(labelDimension);
        start.setPreferredSize(labelDimension);
        end.setPreferredSize(labelDimension);

        JLabel title1 = new JLabel(task.getName());
        JLabel state1 = new JLabel(task.getState() + "");
        JLabel percentage1 = new JLabel(task.getPercentage() + "");
        JLabel start1 = new JLabel(task.getStart().toString());
        JLabel end1 = new JLabel(task.getEnd().toString());

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
        panel.add(percentage, grid);
        grid.gridy = 2;
        panel.add(state, grid);
        grid.gridy = 3;
        panel.add(start,grid);
        grid.gridy = 4;
        panel.add(end, grid);

        grid.gridx = 1;
        grid.gridy = 0;

        panel.add(title1, grid);
        grid.gridy = 1;
        panel.add(percentage1, grid);
        grid.gridy = 2;
        panel.add(state1, grid);
        grid.gridy = 3;
        panel.add(start1,grid);
        grid.gridy = 4;
        panel.add(end1, grid);

        panel.validate();

        super.getContentPane().add(panel, BorderLayout.CENTER);
        super.pack();
        super.validate();
        super.setVisible(true);


    }
}
