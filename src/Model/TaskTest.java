package Model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private static final int NUMBER = 2;
    private static final Task[] TASKS = new Task[NUMBER];
    private static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.now();
    private static final Random RANDOM = new Random(400L);


    private static final User USER = new User("user#1",
            "password#1",
            "user_1@email.com",
            "###-1"
    );

    static {
        for (int i = 0; i < TASKS.length; i++ ) {
            TASKS[i] = new Task(i,
                    "TASKS#" + i,
                    LOCAL_DATE_TIME,
                    LOCAL_DATE_TIME.plusDays(i + 1) // " + 1 " cause i start from zero
            );
        }
    }
    @Test
    void getAndSetPercentage() {
        int percentage;

        // first percentage of each TASKS
        assertEquals(0, TASKS[0].getPercentage());

        // set 100
        percentage = 100;
        TASKS[0].setPercentage(percentage);
        assertEquals(percentage, TASKS[0].getPercentage());

        // set 0
        percentage = 0;
        TASKS[0].setPercentage(percentage);
        assertEquals(percentage, TASKS[0].getPercentage());

        // set between 0 and 100 without inclusive of 0 and 100
        percentage = RANDOM.nextInt(98) + 1;
        TASKS[0].setPercentage(percentage);
        assertEquals(percentage, TASKS[0].getPercentage());

        // more than 100
        percentage = RANDOM.nextInt() + 200;
        TASKS[0].setPercentage(percentage);
        assertNotEquals(percentage, TASKS[0].getPercentage());

        // less than 0
        percentage = -1 * (RANDOM.nextInt() + 1 );
        TASKS[0].setPercentage(percentage);
        assertNotEquals(percentage, TASKS[0].getPercentage());
    }

    @Test
    void getId() {
        for (int i = 0; i < TASKS.length; i++)
            assertEquals(i, TASKS[i].getId());
    }

    @Test
    void getName() {
        for (int i = 0; i < TASKS.length; i++)
            assertEquals("TASKS#" + i, TASKS[i].getName());
    }

    @Test
    void getStart() {
        for (Task task1 : TASKS) assertEquals(LOCAL_DATE_TIME, task1.getStart());
    }

    @Test
    void getEnd() {
        for (int i = 0; i < TASKS.length; i++)
            assertEquals(LOCAL_DATE_TIME.plusDays(i + 1), TASKS[i].getEnd());
    }

    @Test
    void getComments() {
        TaskComment comment = new TaskComment(USER, 1, "COMMENT");

        ArrayList<TaskComment> comments1 = TASKS[0].getComments();
        comments1.add(comment);

        ArrayList<TaskComment> comments2 = TASKS[0].getComments();

        assertEquals(comments1, comments2);
    }

    @Test
    void getTeamMembers() {
        TeamMember teamMember = new TeamMember(1, USER);

        ArrayList<TeamMember> teamMembers1 = TASKS[0].getTeamMembers();
        teamMembers1.add(teamMember);

        ArrayList<TeamMember> teamMembers2 = TASKS[0].getTeamMembers();

        assertEquals(teamMembers1, teamMembers2);
    }
}