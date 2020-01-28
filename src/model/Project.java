package model;

import view.GanttChart;

import java.util.ArrayList;
import java.util.Objects;

public class Project {

//    static private int baseProjectId = 1;

    private int id;

    private String name;
    private String description;
    private Manager manager;
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Task> tasks = new ArrayList<>();
    private GanttChart ganttChart; // TODO: 1/16/2020 add ganttChart

    public Project() {
        this.manager = manager;
    }

    public void changeManger(Manager manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public Manager getManager() {
        return manager;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void setGanttChart(GanttChart ganttChart) {
        this.ganttChart = ganttChart;
    }

    public GanttChart getGanttChart() {
        return ganttChart;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // TODO: 1/17/2020 ????
    public void createGaanttChart(){ }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                manager.equals(project.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manager);
    }
}
