package view;

import model.Project;
import model.Task;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

/** @noinspection ALL*/
public class PmJList<T> extends JList<T> {

    private JPopupMenu popupMenu = new JPopupMenu();
    private T[] list;

    PmJList(String name, T[] list){
        super(list);
        this.list = list;
        Color color = new Color(105,105,105);
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
                // TODO: 1/27/2020 show property of task
                new TaskView((Task)PmJList.super.getSelectedValuesList().get(PmJList.super.getSelectedIndex()));
            }
        });
        popupMenu.add(addTeam);
    }

    void addTeamMemberPropertyToPopUp() {
        JMenuItem addTeam = new JMenuItem("Property");
        addTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 1/27/2020 show property of teamMember

            }
        });
        popupMenu.add(addTeam);
    }

    void addSetPercentageToPopUp() {
        JMenuItem addTeam = new JMenuItem("Set Percentage");
        addTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPercentage((Task) PmJList.super.getSelectedValuesList().get(
                        PmJList.super.getSelectedIndex()
                ));
            }
        });
        popupMenu.add(addTeam);
    }

    void addTeamToPopUp(){
        JMenuItem addTeam = new JMenuItem("Add team");
        addTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTeam addTeam = new AddTeam((Project) PmJList.super.getSelectedValuesList().get(
                        PmJList.super.getSelectedIndex()
                ));
            }
        });
        popupMenu.add(addTeam);
    }

    void addAssignTaskToPopUp() {
        JMenuItem addTeam = new JMenuItem("Add team");
        addTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssignTask assignTask = new AssignTask((Task) PmJList.super.getSelectedValuesList().get(
                        PmJList.super.getSelectedIndex()
                ));
            }
        });
        popupMenu.add(addTeam);
    }

    void addAddTeamMemberToPopUp(){
        JMenuItem addTeam = new JMenuItem("Add Team member");
        addTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 1/28/2020 get all team of project from database
//                AddUserToTeam addUserToTeam = new AddUserToTeam();

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
