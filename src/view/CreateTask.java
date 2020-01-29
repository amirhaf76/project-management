package view;

import controller.Controller;
import model.Task;
import view.com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.Format;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;


/** @noinspection ALL*/
public class CreateTask extends JFrame{

    public CreateTask() {
        super("Create Task");
        createGUI();
    }
    private void createGUI() {

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
        Dimension labelDimension = new Dimension(frameSize.width/3, frameSize.height/3);
        JLabel title = new JLabel("Title:");
        JLabel state = new JLabel("State:");
        JLabel percentage = new JLabel("Percentage:");
        JLabel start = new JLabel("Start:");
        JLabel startLine = new JLabel("Start Line:");
        JLabel end = new JLabel("End:");
        JLabel deadLine = new JLabel("Dead Line:");

        title.setPreferredSize(labelDimension);
        state.setPreferredSize(labelDimension);
        percentage.setPreferredSize(labelDimension);
        start.setPreferredSize(labelDimension);
        startLine.setPreferredSize(labelDimension);
        end.setPreferredSize(labelDimension);
        deadLine.setPreferredSize(labelDimension);

        Dimension dimension = new Dimension(2 * frameSize.width / 3, 2 *frameSize.height / 3);
        JTextField title1 = new JTextField();
        JTextField state1 = new JTextField();
        JTextField percentage1 = new JTextField();
        JDateChooser startDate = new JDateChooser();
        TimeGetter startTime = new TimeGetter(dimension);
        JDateChooser endDate = new JDateChooser();
        TimeGetter endTime = new TimeGetter(dimension);

        title.setPreferredSize(dimension);
        state.setPreferredSize(dimension);
        percentage.setPreferredSize(dimension);
        start.setPreferredSize(dimension);
        end.setPreferredSize(dimension);

        JButton ok = new JButton("Ok");
        JButton cancel = new JButton("Cancel");
        ok.setPreferredSize(labelDimension);
        cancel.setPreferredSize(labelDimension);
        ok.setBackground(color);
        cancel.setBackground(color);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 1/27/2020 create task and send it to database ok
                System.out.println(startDate.getDate());
                DateTimeFormatter formater1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                System.out.println(startDate.getDate().getYear());
                LocalDateTime first = LocalDateTime.ofInstant(startDate.getDate().toInstant(), ZoneId.systemDefault());
                LocalDateTime second = LocalDateTime.ofInstant(startDate.getDate().toInstant(), ZoneId.systemDefault());

                Controller controller = new Controller();
                try {
                    controller.sendTaskDataToDb(
                            title.getText(),
                            "",
                            first.format(formater1),
                            second.format(formater1),
                            1,
                            11
                    );
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateTask.super.setVisible(false);
            }
        });

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
        panel.add(startLine, grid);
        grid.gridy = 5;
        panel.add(end, grid);
        grid.gridy = 6;
        panel.add(deadLine, grid);

        grid.gridx = 1;
        grid.gridy = 0;

        panel.add(title1, grid);
        grid.gridy = 1;
        panel.add(percentage1, grid);
        grid.gridy = 2;
        panel.add(state1, grid);
        grid.gridy = 3;
        panel.add(startDate,grid);
        grid.gridy = 4;
        panel.add(startTime,grid);
        grid.gridy = 5;
        panel.add(endDate,grid);
        grid.gridy = 6;
        panel.add(endTime, grid);

        grid.gridy = 7;
        grid.gridx = 0;
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.LAST_LINE_START;
        panel.add(ok, grid);
        grid.gridx = 1;
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.LAST_LINE_END;
        panel.add(cancel, grid);


        panel.validate();

        super.getContentPane().add(panel, BorderLayout.CENTER);
        super.pack();
        super.validate();
        super.setVisible(true);


    }
}
class TimeGetter extends JPanel {
    private JTextField hour = new JTextField();
    private JTextField minutes = new JTextField();

    TimeGetter(Dimension dimension) {
        super(new BorderLayout());
        Color color = new Color(105,105,105);
        super.setBackground(color);
        super.setPreferredSize(dimension);
        Dimension fieldDimension = new Dimension(dimension.width/2, dimension.height /2 );
        hour.setPreferredSize(fieldDimension);
        minutes.setPreferredSize(fieldDimension);
        LineBorder lineBorder = new LineBorder(Color.BLACK, 2);
        hour.setBorder(BorderFactory.createTitledBorder(lineBorder, "Hour"));
        minutes.setBorder(BorderFactory.createTitledBorder(lineBorder, "Minute"));
        super.add(hour, BorderLayout.CENTER);
        super.add(minutes, BorderLayout.EAST);
        super.setVisible(true);
        super.validate();
    }

    public int getHour() {
        return Integer.parseInt(hour.getText());
    }

    public int getMinutes() {
        return Integer.parseInt(minutes.getText());
    }

}
