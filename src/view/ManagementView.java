package view;

import model.Task;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ManagementView extends JFrame {
    public static void main(String[] atgs) {

        JFrame frame  = new JFrame("Project Management");
        GanttChart ganttChart = new GanttChart("hello", new ArrayList<Task>());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize().getSize();
        Dimension frameSize = new Dimension(1000, 400);

        JList<Task> jList = new JList<>();
        jList.setListData(new Task[]{new Task("task", LocalDateTime.now(), LocalDateTime.now())});


        frame.setLayout(null);
        frame.setSize(frameSize);
        frame.setBackground(Color.gray);
        frame.setLocation(screenSize.width/8, screenSize.height/4);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);

        JPanel panel1 = new JPanel(null);
        JPanel panel2 = new JPanel(null);
        panel1.setBackground(Color.red);
        panel2.setBackground(Color.blue);

//        panel1.setLocation(0,0);
//        panel1.setSize(frameSize.width/2, frameSize.height);
//        panel1.setPreferredSize(new Dimension(frameSize.width/2, frameSize.height));
        panel1.setBounds(0 , 0,200, frameSize.height);
        jList.setBounds(0 , 0,200, frameSize.height);
        jList.setVisibleRowCount(2);
        jList.setBackground(Color.cyan);
        jList.setBorder(BorderFactory.createLoweredBevelBorder());
        jList.setVisible(true);
        panel1.add(jList);
        panel1.setVisible(true);

//        panel2.setLocation(frameSize.width/2, 0);
//        panel2.setSize(frameSize.width/2, frameSize.height);
//        panel2.setPreferredSize(new Dimension(frameSize.width/2, frameSize.height));
        panel2.setBounds(200, 0, 800, frameSize.height);
//        panel2.setBorder(BorderFactory.createLoweredBevelBorder());
//        ganttChart.setSize(800, frameSize.height);
//        ganttChart.setBounds(0,0,800, frameSize.height);
//        panel2.add(ganttChart);
        panel2.setVisible(true);

        SwingUtilities.invokeLater(() -> {
            GanttChart example = new GanttChart("Gantt Chart Example", new ArrayList<>());
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });


        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.WEST);

    }
}
