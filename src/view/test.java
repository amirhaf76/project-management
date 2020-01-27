package view;

import components.Corner;
import model.Task;
import model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
//        ManagementView mv = new ManagementView(new User("amir",
//                "12345678",
//                "email@email.com",
//                "###-9"));
//        GanttChart ganttChart = new GanttChart("hello", new ArrayList<>());
//        ganttChart.openGantt();
//        new SignUp();
//        new AddTeam();
//        new ProjectsView();
        new TaskView(new Task("test",
                LocalDateTime.now(),
                LocalDateTime.now())
        );

    }
}
