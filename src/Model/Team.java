package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Team {

    private final int teamId;
    private String name;

    private final ArrayList<TeamMember> teamMembers = new ArrayList<>();

    public Team(int teamId, String name) {
        this.name = name;
        this.teamId = teamId;
    }

    public ArrayList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamId == team.teamId &&
                name.equals(team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, name);
    }
}
