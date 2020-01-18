package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Project {

    static private int projectId = 1;

    private int teamMembersId = 1;

    private final int id;
    private Manager manager;
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Task> tasks = new ArrayList<>();
    private GanttChart ganttChart; // TODO: 1/16/2020 add ganttChart

    public Project(Manager manager) {
        this.manager = manager;
        this.id = projectId;
        projectId++;
    }

    public void changeManger(Manager manager) {
        this.manager = manager;
    }

    public void addTeamMembers(Team team, User user) {
        if ( teams.contains(team) ) {
            team.getTeamMembers().add(
                    new TeamMember(teamMembersId, user)
            );
            teamMembersId++;
        }
    }

    public int getId() {
        return id;
    }

    public Manager getManger() {
        return manager;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    // TODO: 1/17/2020 ????
    public void createGaanttChart(){ }

    public GanttChart getGanttChart() {
        return ganttChart;
    }

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
