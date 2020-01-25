package Test;

import model.Team;
import model.TeamMember;
import model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    private static User user1 = new User("user#1",
            "password#1",
            "user_1@email.com",
            "###-1"
    );

    private final static Team TEAM1;
    private final static int TEAM1_ID;

    static {
        Team.setBaseTeamId(1);
        TEAM1= new Team("Team1");
        TEAM1_ID = 1;
    }

    @Test
    void getTeamMembers() {

        ArrayList<TeamMember> temp = TEAM1.getTeamMembers();

        temp.add(new TeamMember(user1));

        assertEquals(temp, TEAM1.getTeamMembers());
    }

    @Test
    void getTeamId() {
        assertEquals(TEAM1_ID, TEAM1.getTeamId());
    }

    @Test
    void getName() {
        assertEquals("Team1", TEAM1.getName());
    }

    @Test
    void equals() {
        int id = Team.getBaseTeamId();
        String name = "name";
        Team team1 = new Team(name);

        Team.setBaseTeamId(id);
        Team team2 = new Team(name);
        assertEquals(team1, team2);

        Team.setBaseTeamId(id);
        Team team3 = new Team(name + "2");
        assertNotEquals(team3, team1);
    }
}