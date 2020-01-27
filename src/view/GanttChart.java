package view;

import java.awt.*;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;


import model.Task;
import org.jfree.chart.*;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

public class GanttChart extends JFrame{

    private static final long serialVersionUID = 1L;

    private ArrayList<Task> tasks;

    public GanttChart(String title, ArrayList<Task> tasks) {
        super();

        this.tasks = tasks;

        IntervalCategoryDataset dataset = createCategoryDataset();

        JFreeChart chart = ChartFactory.createGanttChart(title,
                "Tasks",
                "TimeLine",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);

        JPopupMenu Popup = chartPanel.getPopupMenu();
        JMenuItem property = new JMenuItem("property");
        JMenuItem addPercentage = new JMenuItem("add percentage");
        JMenuItem comments = new JMenuItem("comments");

        Popup.add(property);
        Popup.add(addPercentage);
        Popup.add(comments);

        chartPanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
                ChartEntity ce = chartPanel.getEntityForPoint(event.getTrigger().getX(), event.getTrigger().getY());
                if ( ce instanceof CategoryItemEntity) {
                    CategoryItemEntity cte = (CategoryItemEntity) ce;
                }
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent event) {

            }
        });

        getContentPane().add(chartPanel);
    }



    private IntervalCategoryDataset createCategoryDataset() {
        TaskSeries series = new TaskSeries("Tasks");

        for (Task t : tasks) {
            org.jfree.data.gantt.Task tempTask = new org.jfree.data.gantt.Task( t.getName(),
                    Date.from(t.getStart().toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC)),
                    Date.from(t.getEnd().toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC))
            );

            tempTask.setPercentComplete(0);
            series.add(tempTask);
        }
        TaskSeriesCollection dataset = new TaskSeriesCollection();
        dataset.add(series);
        return dataset;
    }

    public void openGantt() {
        SwingUtilities.invokeLater(() -> {
            GanttChart example = this;
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }

}


