package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

public class PmJList<T> extends JList<T> {

    private JPopupMenu popupMenu = new JPopupMenu();
    private T[] list;

    PmJList(String name, T[] list){
        super(list);
        this.list = list;
        Color color = new Color(105,105,105);
//        LineBorder line = new LineBorder(Color.BLACK, 2);
//        TitledBorder title = new TitledBorder(line, name);
//        title.setTitleJustification(TitledBorder.CENTER);
//        super.setBorder(title);
        super.setBackground(color);
        super.setSelectionBackground(Color.YELLOW);
        super.setSelectionMode(SINGLE_SELECTION);



        addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if ( !e.getValueIsAdjusting() ) {

                }
            }
        });

    }

    void addTaskPropertyToPopUp() {
        JMenuItem addTeam = new JMenuItem("Property");
        addTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 1/26/2020 create new team and send to database
                System.out.println(PmJList.super.getSelectedIndex());
            }
        });
        popupMenu.add(addTeam);
    }

    void addTeamMemberPropertyToPopUp() {
        JMenuItem addTeam = new JMenuItem("Property");
        addTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 1/26/2020 create new team and send to database
                System.out.println(PmJList.super.getSelectedIndex());
            }
        });
        popupMenu.add(addTeam);
    }

    void addTeamToPopUp(){
        JMenuItem addTeam = new JMenuItem("Add team");
        addTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 1/26/2020 create new team and send to database
                System.out.println(PmJList.super.getSelectedIndex());
            }
        });
        popupMenu.add(addTeam);
    }

    void addTeamMemberToPopUp(){
        JMenuItem addTeam = new JMenuItem("Add Team member");
        addTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 1/26/2020 create new team and send to database
            }
        });
        popupMenu.add(addTeam);
    }

    JPopupMenu getPopupMenu() {
        return popupMenu;
    }

    public T[] getList() {
        return list;
    }

    public void setList(T[] list) {
        this.list = list;
    }
}
