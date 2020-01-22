package Model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.Random;

class TeamMemberTest {

    private static User user1 = new User("user#1",
            "password#1",
            "user_1@email.com",
            "###-1"
    );

    private static User user2 = new User("user#2",
            "password#2",
            "user_2@email.com",
            "###-2"
    );

    @Test
    void setPercentageOnTask() {
    }

    @Test
    void getTeamMemberId() {
        Random random = new Random(400L);
        int id = random.nextInt();

        TeamMember teamMember = new TeamMember(id, user1);

        assertEquals(id, teamMember.getTeamMemberId());
    }

    @Test
    void equals() {
        TeamMember teamMember1 = new TeamMember(1, user1);
        TeamMember teamMember2 = new TeamMember(2, user1);
        TeamMember teamMember3 = new TeamMember(1, user2);
        TeamMember teamMember4 = new TeamMember(2, user2);
        TeamMember teamMember5 = new TeamMember(1, user1);

        // same id
        assertNotEquals(teamMember1, teamMember3);

        // same user
        assertNotEquals(teamMember1, teamMember2);

        // nothing same
        assertNotEquals(teamMember1, teamMember4);

        // all same
        assertEquals(teamMember1, teamMember5);
    }
}