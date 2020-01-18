package Model;

import java.util.Objects;

public class TeamMember extends User {

    private final int teamMemberId;

    public TeamMember(int teamMemberId, User user) {
        super(user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getPhoneNumber()
        );
        this.teamMemberId = teamMemberId;
    }

    public boolean setPercentageOnTask(Task task, int percentage) {
        if ( task.getTeamMembers().contains(this) ) {
            task.setPercentage(percentage);
            return true;
        }
        return false;
    }

    public int getTeamMemberId() {
        return teamMemberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TeamMember that = (TeamMember) o;
        return teamMemberId == that.teamMemberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), teamMemberId);
    }
}
