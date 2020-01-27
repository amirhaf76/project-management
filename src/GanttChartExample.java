import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import javax.swing.*;


import org.jfree.chart.*;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;


public class GanttChartExample extends JFrame {

    private static final long serialVersionUID = 1L;

    private Comparable comparable;

    public GanttChartExample(String title) {
        super(title);
        // Create dataset
        IntervalCategoryDataset dataset = getCategoryDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createGanttChart(
                "Gantt Chart Example", // Chart title
                "Software Development Phases", // X-Axis Label
                "Timeline", // Y-Axis Label
                dataset);

        ChartPanel panel = new ChartPanel(chart);
        JPopupMenu taskPopup = panel.getPopupMenu();
        JMenuItem property = new JMenuItem("property");
        JMenuItem addPercentage = new JMenuItem("add percentage");
        JMenuItem comments = new JMenuItem("comments");


        property.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comparable.equals("GUI") ) {
                    System.out.println("yes");

                }
            }
        });
        taskPopup.add(property);
        taskPopup.add(addPercentage);
        taskPopup.add(comments);


        panel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
                ChartEntity ce = panel.getEntityForPoint(event.getTrigger().getX(), event.getTrigger().getY());

                System.out.println(ce.getToolTipText());
                if ( ce instanceof CategoryItemEntity) {
                    comparable = ((CategoryItemEntity) ce).getColumnKey();
                    System.out.println( ((CategoryItemEntity) ce).getColumnKey());
                }
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent event) {

            }
        });
        setContentPane(panel);
    }

    private IntervalCategoryDataset getCategoryDataset() {

        TaskSeries series1 = new TaskSeries("Estimated Date");

        Task t1 = new Task("GUI",
                Date.from(LocalDate.of(2017,7,3).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2017, 7,7).atStartOfDay().toInstant(ZoneOffset.UTC))
        );

        t1.setPercentComplete(0.75);

        series1.add(t1);
        series1.add(new Task("Requirement",
                Date.from(LocalDate.of(2017,7,3).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2017, 7,7).atStartOfDay().toInstant(ZoneOffset.UTC))
        ));

        series1.add(new Task("Design",Date.from(LocalDate.of(2017, 7,10).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2017, 7, 14).atStartOfDay().toInstant(ZoneOffset.UTC))
        ));

//        for (int i = 0; i < 20; i++) {
//            series1.add(new Task("Design" + i,Date.from(LocalDate.of(2017, 7,10).atStartOfDay().toInstant(ZoneOffset.UTC)),
//                    Date.from(LocalDate.of(2017, 7, 14).atStartOfDay().toInstant(ZoneOffset.UTC))
//            ));
//        }

        series1.add(new Task("Coding",Date.from(LocalDate.of(2017, 7,17).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2017, 7, 21).atStartOfDay().toInstant(ZoneOffset.UTC))
        ));

        series1.add(new Task("Testing", Date.from(LocalDate.of(2017, 7,24).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2017, 7, 28).atStartOfDay().toInstant(ZoneOffset.UTC))
        ));

        series1.add(new Task("Deployment", Date.from(LocalDate.of(2017, 07,31).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2017, 8, 4).atStartOfDay().toInstant(ZoneOffset.UTC))
        ));

        TaskSeries series2 = new TaskSeries("Actual Date");
        series2.add(new Task("Requirement",Date.from(LocalDate.of(2017, 7,3).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2017, 7, 05).atStartOfDay().toInstant(ZoneOffset.UTC))
        ));

        series2.add(new Task("Design",
                Date.from(LocalDate.of(2017, 7, 6).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2017, 7, 17).atStartOfDay().toInstant(ZoneOffset.UTC))
        ));

        series2.add(new Task("Coding",
                Date.from(LocalDate.of(2017, 7, 18).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2017, 7, 27).atStartOfDay().toInstant(ZoneOffset.UTC))
        ));

        series2.add(new Task("Testing",
                Date.from(LocalDate.of(2017, 7, 28).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2017, 8, 1).atStartOfDay().toInstant(ZoneOffset.UTC))
        ));

        series2.add(new Task("Deployment",
                Date.from(LocalDate.of(2017, 8, 2).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2017, 8, 4).atStartOfDay().toInstant(ZoneOffset.UTC))
        ));

        TaskSeriesCollection dataset = new TaskSeriesCollection();
        dataset.add(series1);
//        dataset.add(series2);
        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GanttChartExample example = new GanttChartExample("Gantt Chart Example");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
//            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}