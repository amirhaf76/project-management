import java.util.ArrayList;
import java.util.Iterator;

public class Project {

    static private int ids = 1;

    private int teamMembersId = 1;

    private int id;
    private Manager manager;
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Task> tasks = new ArrayList<>();
    private GanttChart ganttChart; // TODO: 1/16/2020 add ganttChart

    public Project(Manager manager) {
        this.manager = manager;
        this.id = ids;
        ids++;
        ganttChart = new GanttChart();
    }

    public Manager getManger() {
        return manager;
    }

    public void changeManger(Manager manager) {
        this.manager = manager;
    }

    public void addTeamMembers(Team team, User user) {
        if ( teams.contains(team) ) {
            team.getTeamMember().add(
                    new TeamMember(teamMembersId,
                            user.getUsername(),
                            user.getPassword(),
                            user.getEmail(),
                            user.getPhoneNumber()
                    )
            );
            teamMembersId++;
        }
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public int getId() {
        return id;
    }

    public Manager getManager() {
        return manager;
    }

    // TODO: 1/17/2020 ????
//    public void createGaanttChart()

    public GanttChart getGanttChart() {
        return ganttChart;
    }
}
