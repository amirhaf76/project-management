package Test;

import static org.junit.jupiter.api.Assertions.*;

import model.TeamMember;
import model.User;
import org.junit.jupiter.api.*;

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
        int id = TeamMember.getBaseTeamMemberId();

        TeamMember teamMember = new TeamMember(user1);

        assertEquals(id, teamMember.getTeamMemberId());
    }

    @Test
    void equals() {
        int id = TeamMember.getBaseTeamMemberId();
        TeamMember teamMember1 = new TeamMember(user1);

        // same id
        TeamMember.setBaseTeamMemberId(id);
        TeamMember teamMember2 = new TeamMember(user2);

        // same user
        TeamMember teamMember3 = new TeamMember(user1);

        TeamMember teamMember4 = new TeamMember(user2);

        TeamMember.setBaseTeamMemberId(teamMember1.getTeamMemberId());
        TeamMember teamMember5 = new TeamMember(user1);

        // same id
        assertNotEquals(teamMember1, teamMember3);

        // same user
        assertNotEquals(teamMember1, teamMember2);

        // nothing same
        assertNotEquals(teamMember1, teamMember4);

        System.out.println(teamMember1.getTeamMemberId());
        System.out.println(teamMember5.getTeamMemberId());
        // all same
        assertEquals(teamMember1, teamMember5);
    }
}