package Model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private static final User USER1 = new User("User#1",
            "password#1",
            "user_1@email.com",
            "###-1"
    );

    private static final User USER2 = new User("User#2",
            "password#2",
            "user_2@email.com",
            "###-2"
    );
    private static final Manager MANAGER1 = new Manager(USER1);
    private static final Manager MANAGER2 = new Manager(USER1);

    private static final Project PROJECT1 = new Project(MANAGER1);


    @Test
    void changeManger() {
        Manager manager1 = new Manager(USER1);
        Manager manager2 = new Manager(USER2);

        Project project = new Project(manager1);

        assertEquals(manager1, project.getManager());

        project.changeManger(manager2);

        assertEquals(manager2, project.getManager());


    }

    @Test
    void getId() {
        int id1 = Project.getBaseProjectId();
        Project temp = new Project(MANAGER1);

        assertEquals(id1, temp.getId());

        int id2 = Project.getBaseProjectId();
        temp = new Project(MANAGER2);

        assertNotEquals(id1, temp.getId());
        assertEquals(id2, temp.getId());
    }

    @Test
    void getManager() {
        assertEquals(MANAGER1, PROJECT1.getManager());
        assertNotEquals(new Manager(USER1) , PROJECT1.getManager());
    }

    @Test
    void getTeams() {
        Team team = new Team("Team#1");

        ArrayList<Team> teams = PROJECT1.getTeams();
        teams.add(team);

        assertEquals(teams, PROJECT1.getTeams());
    }

    @Test
    void getTasks() {
        Task task = new Task("Task", LocalDateTime.now(),
                LocalDateTime.of(2017, 11, 23,23, 12));

        ArrayList<Task> tasks = PROJECT1.getTasks();
        tasks.add(task);

        assertEquals(tasks, PROJECT1.getTasks());
    }

    @Test
    void getGanttChart() {
    }

    @Test
    void createGaanttChart() {
    }

    @Test
    void equal() {
        int id = Project.getBaseProjectId();
        Project project1 = new Project(MANAGER1);

        // same id
        Project.setBaseProjectId(id);
        Project project2 = new Project(MANAGER2);

        // same manager
        Project project3 = new Project(MANAGER1);

        // same manager nad id
        Project.setBaseProjectId(id);
        Project project4 = new Project(MANAGER1);

        // nothing same
        Project project5 = new Project(MANAGER2);


    }
}