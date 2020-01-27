package view;

import components.Corner;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ManagementView mv = new ManagementView();
        GanttChart ganttChart = new GanttChart("hello", new ArrayList<>());
        ganttChart.openGantt();
        new SignUp();

    }
}
